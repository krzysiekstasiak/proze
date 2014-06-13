/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.InputOutput;

import EntitiesModels.Comment;
import EntitiesModels.QuestionError;
import EntitiesModels.QuestionProposition;
import EntitiesModels.TestEntity;
import EntitiesModels.TestSolution;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Krzysztof
 */
public class ServerConnection implements TestEntityStore {

    private final Client client = ClientBuilder.newClient();
    private WebTarget target;

    private final ExecutorService threadPool = Executors.newWorkStealingPool(Runtime.getRuntime().availableProcessors());
    private final Semaphore clientSemaphore = new Semaphore(1, true);

    private boolean logged = false;
    private long sessionID = -1;

    private ServerConnection() {
        this.target = client.target("http://localhost:8080/WebService/webresources/");
    }

    public void setServerURL(String serverURL) {
        this.target = client.target(serverURL).path("WebService/webresources/");
    }

    public boolean isLogged() {
        return logged;
    }

    public Future<Boolean> login(final String login, final String password) {
        if (this.logged) {
            throw new IllegalStateException("User must be logged out.");
        }
        return this.threadPool.submit(new Callable<Boolean>() {

            @Override
            public Boolean call() throws Exception {
                clientSemaphore.acquire();
                WebTarget sessionTarget = target.path("session");
                String response = sessionTarget.queryParam("login", login).queryParam("password", password).request(MediaType.TEXT_PLAIN).get(String.class);
                clientSemaphore.acquire();
                if (response == "Authentication Error") {
                    return false;
                } else {
                    long receivedID = Long.valueOf(response);
                    sessionID = receivedID;
                    return true;
                }
            }
        });
    }

    public void logout() {
        if (!this.logged) {
            throw new IllegalStateException("User must be logged in");
        }
        this.threadPool.submit(new Callable<Boolean>() {

            @Override
            public Boolean call() throws Exception {
                clientSemaphore.acquire();
                WebTarget sessionTarget = target.path("session").path(String.valueOf(sessionID));
                sessionTarget.request().delete();
                clientSemaphore.release();
                return true;
            }
        });
    }

    @Override
    public Future<Boolean> storeTest(final TestEntity testEntity) {
        if (!this.logged) {
            throw new IllegalStateException("User is not logged in.");
        }
        return this.threadPool.submit(new Callable<Boolean>() {

            @Override
            public Boolean call() throws Exception {
                byte[] byteArray = Serializer.serializeObject(testEntity);
                clientSemaphore.acquire();
                WebTarget testEntityTarget = target.path("test").path(String.valueOf(sessionID));
                testEntityTarget.request().post(Entity.entity(new ByteArrayInputStream(byteArray), MediaType.APPLICATION_OCTET_STREAM));
                clientSemaphore.release();
                return true;
            }
        });
    }

    @Override
    public Future<TestEntity> getTest(long testID, String groupName) {
        return this.getTest(testID);
    }

    @Override
    public Future<TestEntity> getTest(final long testID) {
        if (!this.logged) {
            throw new IllegalStateException("User is not logged in.");
        }
        return this.threadPool.submit(new Callable<TestEntity>() {

            @Override
            public TestEntity call() throws Exception {
                clientSemaphore.acquire();
                WebTarget testEntityTarget = getTestTarget(testID);
                InputStream inputStream = (InputStream) testEntityTarget.request(MediaType.APPLICATION_OCTET_STREAM).get().getEntity();
                clientSemaphore.release();
                return (TestEntity) Serializer.deserializeFromStream(inputStream);
            }
        });
    }

    public Future<Date> getTestModificationDate(final long testID) {
        if (!this.logged) {
            throw new IllegalStateException("User is not logged in.");
        }
        return this.threadPool.submit(new Callable<Date>() {

            @Override
            public Date call() throws Exception {
                clientSemaphore.acquire();
                WebTarget testDateTarget = getTestTarget(testID).path("date");
                String response = testDateTarget.request(MediaType.TEXT_PLAIN).get(String.class);
                clientSemaphore.release();
                return DateFormat.getInstance().parse(response);
            }
        });
    }

    private WebTarget getTestTarget(long testID) {
        return target.path("test").path(String.valueOf(sessionID)).path(String.valueOf(testID));
    }

    public Future<TestEntity> createTest(final String name, final String groupName) {
        if (!this.logged) {
            throw new IllegalStateException("User is not logged in.");
        }
        return this.threadPool.submit(new Callable<TestEntity>() {

            @Override
            public TestEntity call() throws Exception {
                clientSemaphore.acquire();
                WebTarget testEntityTarget = target.path("test").path(String.valueOf(sessionID));
                testEntityTarget.queryParam("name", name).queryParam("groupName", groupName);
                InputStream inputStream = (InputStream) testEntityTarget.request(MediaType.APPLICATION_OCTET_STREAM).get().getEntity();
                clientSemaphore.release();
                return (TestEntity) Serializer.deserializeFromStream(inputStream);
            }
        });
    }

    public Future<Boolean> postSolution(final TestSolution solution) {
        if (!this.logged) {
            throw new IllegalStateException("User is not logged in.");
        }
        return this.threadPool.submit(new Callable<Boolean>() {

            @Override
            public Boolean call() throws Exception {
                byte[] byteArray = Serializer.serializeObject(solution);
                clientSemaphore.acquire();
                WebTarget solutionTarget = getTestTarget(solution.getTestID()).path("solution");
                solutionTarget.request(MediaType.APPLICATION_OCTET_STREAM).post(Entity.entity(new ByteArrayInputStream(byteArray), MediaType.APPLICATION_OCTET_STREAM));
                clientSemaphore.release();
                return true;
            }
        });
    }

    public Future<Boolean> postComment(final String content, int rating, final long testID) {
        if (!this.logged) {
            throw new IllegalStateException("User must be logged in.");
        }
        return this.threadPool.submit(new Callable<Boolean>() {

            @Override
            public Boolean call() throws Exception {
                clientSemaphore.acquire();
                WebTarget commentTarget = getTestTarget(testID).path("comment");
                commentTarget.queryParam("rating", String.valueOf(testID));
                commentTarget.request(MediaType.TEXT_PLAIN).put(Entity.text(content));
                clientSemaphore.release();
                return true;
            }
        });
    }

    public Future<List<Comment>> getComments(final long testID) {
        if (!this.logged) {
            throw new IllegalStateException("User must be logged in.");
        }
        return this.threadPool.submit(new Callable<List<Comment>>() {

            @Override
            public List<Comment> call() throws Exception {
                clientSemaphore.acquire();
                WebTarget commentTarget = getTestTarget(testID).path("comment");
                InputStream inputStream = (InputStream) commentTarget.request(MediaType.APPLICATION_OCTET_STREAM).get().getEntity();
                clientSemaphore.release();
                return (List<Comment>) Serializer.deserializeFromStream(inputStream);
            }
        });
    }

    public Future<Boolean> postQuestionProposition(final long testID, final QuestionProposition questionProposition) {
        if (!this.logged) {
            throw new IllegalStateException("User must be logged in.");
        }
        return this.threadPool.submit(new Callable<Boolean>() {

            @Override
            public Boolean call() throws Exception {
                byte[] byteArray = Serializer.serializeObject(questionProposition);
                clientSemaphore.acquire();
                WebTarget propositionTarget = getTestTarget(testID).path("proposition");
                propositionTarget.request(MediaType.APPLICATION_OCTET_STREAM).post(Entity.entity(new ByteArrayInputStream(byteArray), MediaType.APPLICATION_OCTET_STREAM_TYPE));
                clientSemaphore.release();
                return true;
            }
        });
    }

    public Future<List<QuestionProposition>> getQuestionPropositions(final long testID) {
        if (!this.logged) {
            throw new IllegalStateException("User must be logged in.");
        }
        return this.threadPool.submit(new Callable<List<QuestionProposition>>() {

            @Override
            public List<QuestionProposition> call() throws Exception {
                clientSemaphore.acquire();
                WebTarget propositionTarget = getTestTarget(testID).path("proposition");
                InputStream inputStream = (InputStream) propositionTarget.request(MediaType.APPLICATION_OCTET_STREAM).get().getEntity();
                clientSemaphore.release();
                return (List<QuestionProposition>) Serializer.deserializeFromStream(inputStream);
            }
        });
    }

    public Future<Boolean> postQuestionError(final long testID, final int questionIndex, final String problemDescription, final String possibleSolution) {
        if (!this.logged) {
            throw new IllegalStateException("User must be logged in.");
        }
        return this.threadPool.submit(new Callable<Boolean>() {

            @Override
            public Boolean call() throws Exception {
                clientSemaphore.acquire();
                WebTarget errorTarget = getTestTarget(testID).path("error");
                errorTarget.queryParam("questionIndex", questionIndex).queryParam("possibleSolution", possibleSolution);
                errorTarget.request(MediaType.APPLICATION_OCTET_STREAM).post(Entity.entity(problemDescription, MediaType.TEXT_PLAIN_TYPE));
                clientSemaphore.release();
                return true;
            }
        });
    }

    public Future<List<QuestionError>> getQuestionErrors(final long testID) {
        if (!this.logged) {
            throw new IllegalStateException("User must be logged in.");
        }
        return this.threadPool.submit(new Callable<List<QuestionError>>() {

            @Override
            public List<QuestionError> call() throws Exception {
                clientSemaphore.acquire();
                WebTarget errorTarget = getTestTarget(testID).path("error");
                InputStream inputStream = (InputStream) errorTarget.request(MediaType.APPLICATION_OCTET_STREAM).get().getEntity();
                clientSemaphore.release();
                return (List<QuestionError>) Serializer.deserializeFromStream(inputStream);
            }
        });
    }

    public static ServerConnection getInstance() {
        return ServerConnectionHolder.INSTANCE;
    }

    private static class ServerConnectionHolder {

        private static final ServerConnection INSTANCE = new ServerConnection();
    }
}

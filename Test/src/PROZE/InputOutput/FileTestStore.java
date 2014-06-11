/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.InputOutput;

import EntitiesModels.TestEntity;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Krzysztof
 */
public class FileTestStore implements TestEntityStore {

    private final ExecutorService threadPool = Executors.newWorkStealingPool(Runtime.getRuntime().availableProcessors());
    private final Semaphore temporaryPathSemaphore = new Semaphore(1, true);

    private static final Path pathToCatalogue = Paths.get("store");

    private Path temporaryPath;

    private FileTestStore() {
    }

    public Iterator<TestEntity> getTests() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Future<Boolean> storeTest(final TestEntity testEntity) {
        return this.threadPool.submit(new Callable<Boolean>() {

            @Override
            public Boolean call() throws Exception {
                Path pathToGroup = getPathToGroup(testEntity.getGroupName());
                Path pathToTest = pathToGroup.resolve(testEntity.getID() + ".dat");
                writeTestToFile(pathToTest, testEntity);
                return true;
            }
        });
    }

    @Override
    public Future<TestEntity> getTest(final long testID, final String groupName) {
        return this.threadPool.submit(new Callable<TestEntity>() {

            @Override
            public TestEntity call() throws Exception {
                return getTestFromPath(pathToCatalogue.resolve(groupName).resolve(testID + ".dat"));
            }
        });
    }

    @Override
    public Future<TestEntity> getTest(final long testID) {
        return this.threadPool.submit(new Callable<TestEntity>() {

            @Override
            public TestEntity call() throws Exception {
                return getTestFromPath(getPathToTest(testID));
            }
        });
    }

    private Path getPathToTest(final long testID) throws IOException {
        try {
            this.temporaryPathSemaphore.acquire();
        } catch (InterruptedException ex) {
        }
        this.temporaryPath = null;
        Files.walkFileTree(pathToCatalogue, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.endsWith(testID + ".dat")) {
                    temporaryPath = file;
                    return FileVisitResult.TERMINATE;
                } else {
                    return super.visitFile(file, attrs); //To change body of generated methods, choose Tools | Templates.
                }
            }
        });
        this.temporaryPathSemaphore.release();
        if (this.temporaryPath != null) {
            return temporaryPath;
        } else {
            throw new FileNotFoundException("File with test not found");
        }

    }

    private TestEntity getTestFromPath(Path path) throws IOException, ClassNotFoundException {
        byte[] byteArray;
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE)) {
            FileLock lock = fileChannel.lock();
            ByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());
            byteArray = new byte[(int) fileChannel.size()];
            buffer.get(byteArray);
            lock.release();
        }
        return (TestEntity) Serializer.deserializeObject(byteArray);
    }

    private Path getPathToGroup(String groupName) throws IOException {
        Path pathToGroup = pathToCatalogue.resolve(groupName);
        if (!Files.exists(pathToGroup, LinkOption.NOFOLLOW_LINKS)) {
            Files.createDirectory(pathToGroup);
        }
        return pathToGroup;
    }

    private void writeTestToFile(Path pathToTest, TestEntity testEntity) throws IOException {
        if (!Files.exists(pathToTest, LinkOption.NOFOLLOW_LINKS)) {
            Files.createFile(pathToTest);
        }
        byte[] byteArray = Serializer.serializeObject(testEntity);
        try (FileChannel fileChannel = FileChannel.open(pathToTest, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE, StandardOpenOption.READ)) {
            FileLock lock = fileChannel.lock();
            ByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, byteArray.length);
            buffer.put(byteArray);
            lock.release();
        }
    }

    public static synchronized FileTestStore getInstance() {
        if (InstanceHolder.instance == null) {
            InstanceHolder.instance = new FileTestStore();
        }
        return InstanceHolder.instance;
    }

    private static class InstanceHolder {

        private static FileTestStore instance = null;
    }

}

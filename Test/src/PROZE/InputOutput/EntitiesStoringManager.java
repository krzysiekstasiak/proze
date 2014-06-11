/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.InputOutput;

import EntitiesModels.TestEntity;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Krzysztof
 */
class EntitiesStoringManager {

    private final ExecutorService threadPool = Executors.newWorkStealingPool(Runtime.getRuntime().availableProcessors());
    private final Semaphore directoryCreateSemaphore = new Semaphore(1, true);
    private final Semaphore fileCreateSemaphore = new Semaphore(1, true);

    private static final Path storingDirectoryPath = Paths.get("store");

    private EntitiesStoringManager() throws IOException {
        this.initStoringDirectory();
    }

    private void initStoringDirectory() throws IOException {
        if (!Files.exists(storingDirectoryPath, LinkOption.NOFOLLOW_LINKS)) {
            Files.createDirectories(storingDirectoryPath);
        }
    }

    public Future<Boolean> saveTestEntity(final TestEntity testEntity) throws IOException {
        return this.threadPool.submit(new Callable<Boolean>() {

            @Override
            public Boolean call() throws Exception {
                Path pathToGroup = getPathToGroup(testEntity.getGroupName(), true);
                Path pathToTest = pathToGroup.resolve(testEntity.getID() + ".dat");
                writeTestEntityToFile(pathToTest, testEntity);
                return true;
            }
        });
    }

    //TODO: Sensowna obsługa wyjątków
    private void writeTestEntityToFile(Path pathToTest, TestEntity testEntity) throws IOException {
        if (!Files.exists(pathToTest, LinkOption.NOFOLLOW_LINKS)) {
            try {
                this.fileCreateSemaphore.acquire();
            } catch (InterruptedException ex) {
            }
            Files.createFile(pathToTest);
            this.fileCreateSemaphore.release();
        }
        byte[] byteArray;
        try (ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream)) {
            objectOutputStream.writeObject(new Date());
            objectOutputStream.writeObject(testEntity);
            byteArray = byteOutputStream.toByteArray();
        }
        try (FileChannel fileChannel = FileChannel.open(pathToTest, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE, StandardOpenOption.READ)) {
            FileLock lock = fileChannel.lock();
            ByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, byteArray.length);
            buffer.put(byteArray);
            lock.release();
        }
    }

    public Future<TestEntity> loadTestEntity(final long testID, final String groupName) throws FileNotFoundException, IOException {
        return this.threadPool.submit(new Callable<TestEntity>() {

            @Override
            public TestEntity call() throws Exception {
                Path pathToGroup = getPathToGroup(groupName, false);
                Path pathToTest = pathToGroup.resolve(testID + ".dat");
                return readTestEntityFromFile(pathToTest);
            }

        });
    }

    private TestEntity readTestEntityFromFile(Path pathToTest) throws IOException, ClassNotFoundException {
        byte[] byteArray;
        try (FileChannel fileChannel = FileChannel.open(pathToTest, StandardOpenOption.READ, StandardOpenOption.WRITE)) {
            FileLock lock = fileChannel.lock();
            ByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());
            byteArray = new byte[(int) fileChannel.size()];
            buffer.get(byteArray);
            lock.release();
        }
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            objectInputStream.readObject();
            return (TestEntity) objectInputStream.readObject();
        }
    }

    private Path getPathToGroup(String groupName, boolean create) throws FileNotFoundException, IOException {
        Path pathToGroup = storingDirectoryPath.resolve(groupName);
        if (!Files.exists(pathToGroup)) {
            if (create) {
                try {
                    this.directoryCreateSemaphore.acquire();
                } catch (InterruptedException ex) {
                    //Coś się wymyśli
                }
                Files.createDirectory(pathToGroup);
                this.directoryCreateSemaphore.release();
            } else {
                throw new FileNotFoundException("Couldn't find a file");
            }
        }
        return pathToGroup;
    }

    //TODO: Jak starczy czasu
    public void maintainCataloguesOrder() throws IOException {
        Files.walkFileTree(storingDirectoryPath, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                return super.visitFile(file, attrs); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }

    public static synchronized EntitiesStoringManager getInstance() throws IOException {
        if (EntitiesStoringManagerHolder.INSTANCE == null) {
            EntitiesStoringManagerHolder.INSTANCE = new EntitiesStoringManager();
        }
        return EntitiesStoringManagerHolder.INSTANCE;
    }

    private static class EntitiesStoringManagerHolder {

        private static EntitiesStoringManager INSTANCE = null;
    }
}

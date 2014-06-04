/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.InputOutput;

import EntitiesModels.TestEntity;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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

    public Future<Boolean> storeTestEntity(final TestEntity testEntity) throws IOException {
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

    //Do poprawienia jak storeTestEntity()
    public Future<TestEntity> readTestEntity(long testID, String groupName) throws FileNotFoundException, IOException {

        Path pathToGroup = getPathToGroup(groupName, false);
        Path pathToTest = pathToGroup.resolve(testID + ".dat");
        final ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(pathToTest));
        return this.threadPool.submit(new Callable<TestEntity>() {

            @Override
            public TestEntity call() throws Exception {
                inputStream.readObject();
                return (TestEntity) inputStream.readObject();
            }
        });

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

    public static EntitiesStoringManager getInstance() throws IOException {
        if (EntitiesStoringManagerHolder.INSTANCE == null) {
            EntitiesStoringManagerHolder.INSTANCE = new EntitiesStoringManager();
        }
        return EntitiesStoringManagerHolder.INSTANCE;
    }

    private static class EntitiesStoringManagerHolder {

        private static EntitiesStoringManager INSTANCE = null;
    }
}

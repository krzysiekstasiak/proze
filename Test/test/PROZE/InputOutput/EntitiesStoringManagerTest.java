/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.InputOutput;

import EntitiesModels.TestEntity;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Krzysztof
 */
public class EntitiesStoringManagerTest {

    public EntitiesStoringManagerTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void test1() throws IOException, InterruptedException, ExecutionException {
        TestEntity test = new TestEntity(1, "test", "grupa1", new Date(), "loginautora", true);
        Future<Boolean> future = EntitiesStoringManager.getInstance().storeTestEntity(test);
        future.get();
        TestEntity gotTest = EntitiesStoringManager.getInstance().readTestEntity(1, "grupa1").get();
        assert (gotTest.getAuthorLogin() == null ? test.getAuthorLogin() == null : gotTest.getAuthorLogin().equals(test.getAuthorLogin()));
    }
}

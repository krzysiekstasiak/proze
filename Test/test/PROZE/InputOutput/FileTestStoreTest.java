/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.InputOutput;

import EntitiesModels.TestEntity;
import java.util.Date;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Krzysztof
 */
public class FileTestStoreTest {

    FileTestStore testedInstance;

    public FileTestStoreTest() {
    }

    @Before
    public void setUp() {
        this.testedInstance = FileTestStore.getInstance();
    }

    /**
     * Test of getTests method, of class FileTestStore.
     */
    @Test
    public void testStoreGet() {
        try {
            TestEntity storedTest = new TestEntity(100, "Name", "GroupName", new Date(), "AuthorLogin", true);
            Future<Boolean> storeResult = this.testedInstance.storeTest(storedTest);
            assert storeResult.get(5, TimeUnit.SECONDS);
            Future<TestEntity> getResult = this.testedInstance.getTest(storedTest.getID());
            TestEntity gotTest = getResult.get(5, TimeUnit.SECONDS);
            assert gotTest.getID() == storedTest.getID();
            assert (gotTest.getAuthorLogin() == null ? storedTest.getAuthorLogin() == null : gotTest.getAuthorLogin().equals(storedTest.getAuthorLogin()));
            assert (gotTest.getCategory() == null ? storedTest.getCategory() == null : gotTest.getCategory().equals(storedTest.getCategory()));
            assert (gotTest.getDescription() == null ? storedTest.getDescription() == null : gotTest.getDescription().equals(storedTest.getDescription()));
            assert (gotTest.getGroupName() == null ? storedTest.getGroupName() == null : gotTest.getGroupName().equals(storedTest.getGroupName()));
        } catch (Exception ex) {
            fail("Exception thrown");
        }

    }

}

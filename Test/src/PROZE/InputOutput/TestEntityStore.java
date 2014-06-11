/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.InputOutput;

import EntitiesModels.TestEntity;
import java.util.concurrent.Future;

/**
 *
 * @author Krzysztof
 */
public interface TestEntityStore {

    public Future<Boolean> storeTest(TestEntity testEntity);

    public Future<TestEntity> getTest(long testID, String groupName);

    public Future<TestEntity> getTest(long testID);

}

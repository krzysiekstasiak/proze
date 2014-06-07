/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.GUI.EventListeners;

import EntitiesModels.GroupEntity;
import EntitiesModels.TestDescription;
import EntitiesModels.UserEntity;

/**
 *
 * @author Krzysztof
 */
public interface GroupManagerListener {

    public void groupCreated(String name);

    public void groupUpdated(GroupEntity group);

    public void userAdded(UserEntity user);

    public void userRemoved(UserEntity user);

    public void testRemoved(TestDescription test);
}

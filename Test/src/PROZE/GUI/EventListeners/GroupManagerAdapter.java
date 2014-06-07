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
public class GroupManagerAdapter implements GroupManagerListener {

    @Override
    public void groupCreated(String name) {
    }

    @Override
    public void groupUpdated(GroupEntity group) {
    }

    @Override
    public void userAdded(UserEntity user) {
    }

    @Override
    public void userRemoved(UserEntity user) {
    }

    @Override
    public void testRemoved(TestDescription test) {
    }

}

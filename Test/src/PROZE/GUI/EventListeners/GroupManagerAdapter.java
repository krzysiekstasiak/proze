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

    /**
     * Metoda zaślepka która nic nie robi.
     * 
     * @param name nie istotny
     */
    @Override
    public void groupCreated(String name) {
    }

    /**
     * Metoda zaślepka która nic nie robi
     * 
     * @param group nie istotny
     */
    @Override
    public void groupUpdated(GroupEntity group) {
    }

    /**
     * Metoda zaślepka która nic nie robi.
     * 
     * @param user nie istotny
     */
    @Override
    public void userAdded(UserEntity user) {
    }

    /**
     * Metoda zaślepka która nic nie robi.
     * 
     * @param user nie istotny
     */
    @Override
    public void userRemoved(UserEntity user) {
    }

    /**
     * Metoda zaślepka która nic nie robi.
     * 
     * @param test nie istotny
     */
    @Override
    public void testRemoved(TestDescription test) {
    }

}

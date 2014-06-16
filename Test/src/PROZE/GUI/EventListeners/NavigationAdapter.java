/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.GUI.EventListeners;

import EntitiesModels.GroupEntity;
import EntitiesModels.TestDescription;

/**
 *
 * @author Krzysztof
 */
public class NavigationAdapter implements NavigationListener {

    /**
     * Metoda zaślepka która nic nie robi.
     * 
     */
    @Override
    public void navigatedToViewProfile() {
    }

    /**
     * Metoda zaślepka która nic nie robi.
     * 
     */
    @Override
    public void navigatedToMyGroups() {
    }

    /**
     * Metoda zaślepka która nic nie robi.
     * 
     */
    @Override
    public void navigatedToMyTests() {
    }

    /**
     * Metoda zaślepka która nic nie robi.
     * 
     */
    @Override
    public void navigatedToSearch() {
    }

    /**
     * Metoda zaślepka która nic nie robi.
     * 
     */
    @Override
    public void navigatedToNotifications() {
    }

    /**
     * Metoda zaślepka która nic nie robi
     * 
     * @param editedTest nie istotny
     * @param createNewTest nie istotny
     */
    @Override
    public void navigatedToTestManager(TestDescription editedTest, boolean createNewTest) {
    }

    /**
     * Metoda zaślepka która nic nie robi.
     * 
     * @param group nie istotny
     * @param createNewGroup nie istotny
     */
    @Override
    public void navigatedToGroupManager(GroupEntity group, boolean createNewGroup) {
    }

    /**
     * Metoda zaślepka która nic nie robi.
     * 
     */
    @Override
    public void navigatedToLogout() {
    }

}

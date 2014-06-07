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
public interface NavigationListener {

    public void navigatedToViewProfile();

    public void navigatedToMyGroups();

    public void navigatedToMyTests();

    public void navigatedToSearch();

    public void navigatedToNotifications();

    public void navigatedToTestEditor(TestDescription editedTest, boolean createNewTest);

    public void navigatedToManageGroup(GroupEntity group);

    public void navigatedToLogout();
}

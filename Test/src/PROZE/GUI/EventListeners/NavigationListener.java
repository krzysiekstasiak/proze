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

    /**
     * Przechodzi do panelu podgląd profilu
     * 
     */
    public void navigatedToViewProfile();

    /**
     * Przechodzi do panelu moje grupy
     * 
     */
    public void navigatedToMyGroups();

    /**
     * Przechodzi do panelu moje testy
     * 
     */
    public void navigatedToMyTests();

    /**
     * Przechodzi do panelu wyszukiwania
     * 
     */
    public void navigatedToSearch();

    /**
     * Przechodzi do panelu powiadomień
     * 
     */
    public void navigatedToNotifications();

    /**
     * Przechodzi do panelu zarządzania testem
     * 
     * @param editedTest test którzy bedzie modyfikowany
     * @param createNewTest czy modyfikowany test jest nowo tworzonym testem
     */
    public void navigatedToTestManager(TestDescription editedTest, boolean createNewTest);

    /**
     * Przechodzi do panelu zarządzania grupą
     * 
     * @param group grupa która będzie modyfikowana 
     * @param createNewGroup czy modyfikowana grupa jest nowo tworzoną grupą
     */
    public void navigatedToGroupManager(GroupEntity group, boolean createNewGroup);

    /**
     * Przechodzi do wylogowania
     * 
     */
    public void navigatedToLogout();
}

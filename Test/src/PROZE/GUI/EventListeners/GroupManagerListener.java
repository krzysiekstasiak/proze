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
    /**
     * Tworzy nową grupę
     * 
     * @param name nazwa tworzonej grupy
     */
    public void groupCreated(String name);
   
    /**
     * Dokonyje aktualizacji grupy
     * 
     * @param group aktualizowana grupa
     */
    public void groupUpdated(GroupEntity group);
    
    /**
     * Dodaje nowego użytkownika do grupy
     * 
     * @param user dodawany użytkownik
     */
    public void userAdded(UserEntity user);
    
    /**
     * Usuwa użytkownika z grupy
     * 
     * @param user usuwany użytkownik
     */
    public void userRemoved(UserEntity user);
    
    /**
     * Usuwa test z grupy
     * 
     * @param test usuwany test
     */
    public void testRemoved(TestDescription test);
}

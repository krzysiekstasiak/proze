/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.GUI.EventListeners;


import EntitiesModels.UserEntity;

/**
 *
 * @author Krzysztof
 */
public class RegisterUserAdapter implements RegisterUserListener {

 
    /**
     * Metoda zaślepka która nic nie robi.
     * 
     * @param firstName nie istotny
     * @param lastName nie istotny
     * @param login nie istotny
     * @param mail nie istotny
     * @param password nie istotny
     */
    @Override
    public void userRegistered(String firstName, String lastName, String login, String mail, String password) {
       
    }

   
}
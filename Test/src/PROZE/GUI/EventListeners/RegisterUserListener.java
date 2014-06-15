/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.GUI.EventListeners;

/**
 *
 * @author Krzysztof
 */
public interface RegisterUserListener {

    /**
     * Rejestruje nowego użytkownika
     * 
     * @param firstName imie użytkownika
     * @param lastName nazwisko użytkownika
     * @param login login użytkownika
     * @param mail mail użytkownika
     * @param password hasło użytkownika
     */
    public void userRegistered(String firstName, String lastName, String login, String mail, String password);
}

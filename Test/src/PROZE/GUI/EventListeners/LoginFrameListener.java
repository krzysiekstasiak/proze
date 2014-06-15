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
public interface LoginFrameListener {

    /**
     * Loguje do systemu
     * 
     * @param login login użytkownika
     * @param password hasło użutkownika
     */
    public void loggedIn(String login, String password);

    /**
     * Rozpoczyna rejestrację
     * 
     */
    public void registerOptionChosen();

    /**
     * Włącza tryb offline
     * 
     */
    public void offlineOptionChosen();
}

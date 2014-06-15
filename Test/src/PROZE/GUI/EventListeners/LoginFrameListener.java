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

    public void loggedIn(String login, String password);

    public void registerOptionChosen();

    public void offlineOptionChosen();
}

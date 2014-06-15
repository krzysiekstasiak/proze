/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE;

import PROZE.GUI.LoginFrame;
import PROZE.InputOutput.AccountSettingsManager;

/**
 *
 * @author Krzysztof
 */
public class Application {

    private final AccountSettingsManager accountSettingsManager = new AccountSettingsManager("settings.xml");

    public Application() {

    }

    public void run() {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Application applicationInstance = new Application();
        applicationInstance.run();
    }
}

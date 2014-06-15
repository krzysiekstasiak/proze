/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE;

import EntitiesModels.GroupEntity;
import EntitiesModels.TestDescription;
import EntitiesModels.UserEntity;
import PROZE.GUI.EventListeners.GroupManagerListener;
import PROZE.GUI.EventListeners.LoginFrameListener;
import PROZE.GUI.EventListeners.NavigationListener;
import PROZE.GUI.LoginFrame;
import PROZE.GUI.MainFrame;
import PROZE.InputOutput.AccountSettingsManager;
import PROZE.InputOutput.ServerConnection;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.swing.JOptionPane;

/**
 *
 * @author Krzysztof
 */
public class Application {

    private final AccountSettingsManager accountSettingsManager = new AccountSettingsManager("settings.xml");
    private String login;
    private String password;
    private String serverURL;
    private ServerConnection serverConnection = ServerConnection.getInstance();

    private LoginFrame loginFrame = new LoginFrame();
    private MainFrame onlineFrame = new MainFrame();

    public Application() {
        try {
            this.login = (!"".equals(this.accountSettingsManager.getLogin())) ? this.accountSettingsManager.getLogin() : null;
            this.password = (!"".equals(this.accountSettingsManager.getPassword())) ? this.accountSettingsManager.getPassword() : null;
            this.serverURL = (!"".equals(this.accountSettingsManager.getServerURL())) ? this.accountSettingsManager.getServerURL() : null;
        } catch (IOException ex) {
            String warningMessage;
            warningMessage = (ex.getCause() instanceof SecurityException)
                    ? "Niestety z powodu braku uprawnień, aplikacja nie może przechowywać Twoich danych na dysku."
                    : "Wystąpił nieznany problem z odczytaniem pliku konfiguracyjnego. Pomimo tego można kontynuować pracę z aplikacją";
            JOptionPane.showMessageDialog(null, warningMessage, "Ostrzeżenie", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void run() {
        showLoginFrame();
    }

    private void showLoginFrame() {
        this.loginFrame.addLoginFrameListener(new LoginFrameListener() {

            @Override
            public void loggedIn(String login, String password) {
                if (getValidServerURL()) {
                    Future<Boolean> result = serverConnection.login(login, password);
                    try {
                        if (result.get(10, TimeUnit.SECONDS)) {
                            loginFrame.setVisible(false);
                            showOnlineFrame();
                        } else {
                            JOptionPane.showMessageDialog(null, "Niepoprawna nazwa użytkownika, lub hasło", "Błąd logowania", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (InterruptedException ex) {
                    } catch (ExecutionException ex) {
                        JOptionPane.showMessageDialog(null, "Wystąpił nieznany błąd podczas logowania: " + ex.getMessage(), "Błąd", JOptionPane.ERROR);
                    } catch (TimeoutException ex) {
                        JOptionPane.showMessageDialog(null, "Przekroczono czas oczekiwania.", "Błąd", JOptionPane.ERROR);
                    }
                }
            }

            @Override
            public void registerOptionChosen() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void offlineOptionChosen() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        this.loginFrame.setVisible(true);
    }

    private boolean getValidServerURL() {
        while (this.serverURL == null || !this.testConnection()) {
            String input = JOptionPane.showInputDialog("Adres URL serwera:");
            if (input == null) {
                return false;
            } else {
                this.serverURL = input;
            }
        }
        return true;
    }

    private boolean testConnection() {
        try {
            this.serverConnection.setServerURL(this.serverURL);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Wpisany adres nie jest poprawnym adresem URL", "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            this.serverConnection.testConnection().get(5, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException ex) {
            return false;
        } catch (ExecutionException ex) {
            JOptionPane.showMessageDialog(null, "Nie można połączyć się z serwerem. Odrzucono połączenie", "Ostrzeżenie", JOptionPane.WARNING_MESSAGE);
            return false;
        } catch (TimeoutException ex) {
            JOptionPane.showMessageDialog(null, "Nie można połączyć się z serwerem. Przekroczono czas oczekiwania.", "Ostrzeżenie", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private void showOnlineFrame() {
        this.onlineFrame.getLeftPanel().addNavigationListener(new NavigationListener() {

            @Override
            public void navigatedToViewProfile() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void navigatedToMyGroups() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void navigatedToMyTests() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void navigatedToSearch() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void navigatedToNotifications() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void navigatedToTestManager(TestDescription editedTest, boolean createNewTest) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void navigatedToGroupManager(GroupEntity group, boolean createNewGroup) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void navigatedToLogout() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        this.onlineFrame.getManageGroupPanel().addGroupManagerListener(new GroupManagerListener() {

            @Override
            public void groupCreated(String name) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void groupUpdated(GroupEntity group) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void userAdded(UserEntity user) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void userRemoved(UserEntity user) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void testRemoved(TestDescription test) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        this.onlineFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Application applicationInstance = new Application();
        applicationInstance.run();
    }
}

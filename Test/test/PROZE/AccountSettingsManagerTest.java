/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE;

import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.Test;

/**
 *
 * @author Krzysztof
 */
public class AccountSettingsManagerTest {

    AccountSettingsManager testedObject;

    public AccountSettingsManagerTest() {
        this.testedObject = new AccountSettingsManager("test.xml");
    }

    @After
    public void tearDown() {
        new File("test.xml").delete();
    }

    /**
     * Test of parseXmlFile method, of class AccountSettingsManager.
     */
    @Test
    public void testLoadingStoring() throws IOException {
        String login = "login";
        String password = "password";
        String server = "server";
        this.testedObject.setLogin(login);
        this.testedObject.setPasswordHash(password);
        this.testedObject.setServerURL(server);
        this.testedObject = new AccountSettingsManager("test.xml");
        assert login.equals(this.testedObject.getLogin());
        assert password.equals(this.testedObject.getPasswordHash());
        assert server.equals(this.testedObject.getServerURL());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Krzysztof
 */
public class AccountSettingsManager {

    private String xmlFileName;
    private Properties properties;

    public AccountSettingsManager(String xmlFileName) {
        this.xmlFileName = xmlFileName;
        this.properties = new Properties();
    }

    public String getServerURL() {
        this.updateProperties();
        return this.properties.getProperty("serverURL", "");
    }

    public String getLogin() {
        this.updateProperties();
        return this.properties.getProperty("login", "");
    }

    public String getPasswordHash() {
        this.updateProperties();
        return this.properties.getProperty("passwordHash", "");
    }

    public void setServerURL(String value) {
        this.properties.setProperty("serverURL", value);
        this.updateXML();
    }

    public void setLogin(String value) {
        this.properties.setProperty("login", value);
        this.updateXML();
    }

    public void setPasswordHash(String value) {
        this.properties.setProperty("passwordHash", value);
        this.updateXML();
    }

    private boolean updateXML() {
        boolean updateSuccessful;
        try (FileOutputStream fileStream = new FileOutputStream(this.xmlFileName)) {
            this.properties.storeToXML(fileStream, null);
            updateSuccessful = true;
        } catch (IOException exc) {
            updateSuccessful = false;
        }
        return updateSuccessful;
    }

    private boolean updateProperties() {
        boolean readSuccessful;
        try (FileInputStream fileStream = new FileInputStream(this.xmlFileName)) {
            this.properties.loadFromXML(fileStream);
            readSuccessful = true;
        } catch (IOException exc) {
            readSuccessful = false;
        }
        return readSuccessful;
    }

}

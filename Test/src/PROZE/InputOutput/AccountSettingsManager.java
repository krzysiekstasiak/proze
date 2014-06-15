/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.InputOutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Klasa zarządzająca ustawieniami dotyczącymi konta użytkownika. Zapewnia
 * dostęp do loginu, hasza hasła użytkownika i adresu serwera aplikacji. Pozwala
 * również przechowywać te dane w pliku XML.
 *
 * @author Krzysztof
 */
public class AccountSettingsManager {

    private final String xmlFileName;
    private final Properties properties;

    /**
     * Konstruktor klasy ustawiający nazwę pliku przechowującego ustawienia.
     *
     * @param xmlFileName nazwa pliku XML przechowującego trwałą kopię ustawień
     */
    public AccountSettingsManager(String xmlFileName) {
        this.xmlFileName = xmlFileName;
        this.properties = new Properties();
    }

    /**
     * Odczytuje adres URL serwera z pliku XML. W przypadku braku pliku, lub
     * jeśli jest on pusty, albo wartość nie została zapisana zwraca pusty
     * łańcuch.
     *
     * @return Pobrany adres URL
     * @throws java.io.IOException W przypadku błędu odczytu pliku. Jeśli
     * powodem jest wyjątek SecurityException, jest on oznaczony jako przyczyna
     * rzuconego wyjątku.
     */
    public String getServerURL() throws IOException {
        this.updateProperties();
        return this.properties.getProperty("serverURL", "");
    }

    /**
     * Odczytuje nazwę użytkownika z pliku XML. W przypadku braku pliku, lub
     * jeśli jest on pusty, albo wartość nie została zapisana zwraca pusty
     * łańcuch.
     *
     * @return Odczytana nazwa użytkownika.
     * @throws java.io.IOException W przypadku błędu odczytu pliku. Jeśli
     * powodem jest wyjątek SecurityException, jest on oznaczony jako przyczyna
     * rzuconego wyjątku.
     */
    public String getLogin() throws IOException {
        this.updateProperties();
        return this.properties.getProperty("login", "");
    }

    /**
     * Odczytuje hasło z pliku XML. W przypadku braku pliku, lub jeśli jest on
     * pusty, albo wartość nie została zapisana zwraca pusty łańcuch.
     *
     * @return Odczytane hasło.
     * @throws java.io.IOException W przypadku błędu odczytu pliku. Jeśli
     * powodem jest wyjątek SecurityException, jest on oznaczony jako przyczyna
     * rzuconego wyjątku.
     */
    public String getPassword() throws IOException {
        this.updateProperties();
        return this.properties.getProperty("password", "");
    }

    /**
     * Zapisuje adres URL serwera do pliku XML.
     *
     * @param value Zapisywany adres serwera.
     * @throws java.io.IOException W przypadku niepowodzenia zapisu. Jesli
     * przyczyną jest wyjątek SecurityException, jest on dołączany jako
     * przyczyna rzuconego wyjatku.
     */
    public void setServerURL(String value) throws IOException {
        this.updateProperties();
        this.properties.setProperty("serverURL", value);
        this.updateXML();
    }

    /**
     * Zapisuje nazwę użytkownika do pliku XML.
     *
     * @param value Zapisywana nazwa użytkownika.
     * @throws java.io.IOException W przypadku niepowodzenia zapisu. Jesli
     * przyczyną jest wyjątek SecurityException, jest on dołączany jako
     * przyczyna rzuconego wyjatku.
     */
    public void setLogin(String value) throws IOException {
        this.updateProperties();
        this.properties.setProperty("login", value);
        this.updateXML();
    }

    /**
     * Zapisuje hasło do pliku XML.
     *
     * @param value Zapisywane hasło.
     * @throws java.io.IOException W przypadku niepowodzenia zapisu. Jesli
     * przyczyną jest wyjątek SecurityException, jest on dołączany jako
     * przyczyna rzuconego wyjatku.
     */
    public void setPassword(String value) throws IOException {
        this.updateProperties();
        this.properties.setProperty("passwordHash", value);
        this.updateXML();
    }

    private void updateXML() throws IOException {
        try (FileOutputStream fileStream = new FileOutputStream(this.xmlFileName)) {
            this.properties.storeToXML(fileStream, null);
        } catch (FileNotFoundException exc) {
        } catch (SecurityException | IOException exc) {
            IOException newException = new IOException("Reading file failed");
            newException.initCause(exc);
            throw newException;
        }
    }

    private void updateProperties() throws IOException {
        try (FileInputStream fileStream = new FileInputStream(this.xmlFileName)) {
            this.properties.loadFromXML(fileStream);
        } catch (FileNotFoundException exc) {
        } catch (SecurityException | IOException exc) {
            IOException newException = new IOException("Writing to file failed");
            newException.initCause(exc);
            throw newException;
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Krzysztof
 */
public class AccountSettingsParser {

    public static Properties parseXmlFile(String fileName) {
        Properties settings = new Properties();
        try (FileInputStream fileStream = new FileInputStream(fileName)) {
                settings.loadFromXML(fileStream);
                settings.setProperty("ReadSuccesful", "True");
        } catch (IOException ex) {
            settings.setProperty("ReadSuccesful", "False");
        }
        return settings;
    }
}

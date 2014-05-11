/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PROZE;

import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Krzysztof
 */
public class AccountSettingsParserTest {
    
    public AccountSettingsParserTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of parseXmlFile method, of class AccountSettingsParser.
     */
    @Test
    public void testParseXmlFile() {
        System.out.println("parseXmlFile");
        String fileName = "";
        Properties expResult = null;
        Properties result = AccountSettingsParser.parseXmlFile(fileName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

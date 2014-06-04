/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.GUI;

import ServerAccess.ServerAccessBeanRemote;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Krzysztof
 */
public class TestClass {

    public static void main(String[] args) throws NamingException {
        InitialContext ic = new InitialContext();
        ServerAccessBeanRemote server = (ServerAccessBeanRemote) ic.lookup(ServerAccessBeanRemote.class.getCanonicalName());

    }

}

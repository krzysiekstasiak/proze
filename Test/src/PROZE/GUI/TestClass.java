/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.GUI;

import javax.naming.NamingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Krzysztof
 */
public class TestClass {

    public static void main(String[] args) throws NamingException {
        Client client = ClientBuilder.newClient();

        System.out.println(client.target("http://localhost:8080/services/webresources/session/").request(MediaType.TEXT_PLAIN).get(String.class));
    }

}

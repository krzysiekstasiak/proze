/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.GUI;

import java.io.IOException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Krzysztof
 */
public class TestClass {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Client client = ClientBuilder.newClient();

//        WebTarget target = client.target("http://localhost:8080/WebService/webresources/session/");
//        target = target.queryParam("login", "Użytkownik");
//        target = target.queryParam("password", "Hasło");
//        Invocation.Builder request = target.request(MediaType.TEXT_PLAIN);
//        Invocation buildGet = request.buildGet();
//        String get = buildGet.invoke(String.class);
//        System.out.println(get);
        String login = "test";
        String password = "test";
        System.out.println("SELECT * FROM USERS WHERE login = \'" + login + "\' AND password = \'" + password + "\';");
        WebTarget target = client.target("http://localhost:8080/WebService/webresources/");
        WebTarget sessionTarget = target.path("session");
        String response = sessionTarget.queryParam("login", "test").queryParam("password", "test").request(MediaType.TEXT_PLAIN).get(String.class);
        System.out.println(response);
        client.close();
    }

}

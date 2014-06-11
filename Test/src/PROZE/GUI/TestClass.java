/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.GUI;

import EntitiesModels.UserEntity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOut = new ObjectOutputStream(outStream);
        objectOut.writeObject(new UserEntity("login2", true));
        WebTarget target = client.target("http://localhost:8080/WebService/webresources/account/");
        Response resp = target.request(MediaType.APPLICATION_OCTET_STREAM_TYPE).put(Entity.entity(outStream.toByteArray(), MediaType.APPLICATION_OCTET_STREAM));
        ObjectInputStream objInstream = new ObjectInputStream((InputStream) resp.getEntity());
        UserEntity user = (UserEntity) objInstream.readObject();
        System.out.println(user.getLogin());
    }

}

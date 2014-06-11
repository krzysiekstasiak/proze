/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.InputOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Krzysztof
 */
public class Serializer {

    public static Object deserializeObject(byte[] byteArray) throws IOException, ClassNotFoundException {
        try (InputStream byteInput = new ByteArrayInputStream(byteArray);
                ObjectInputStream objectInput = new ObjectInputStream(byteInput)) {
            return objectInput.readObject();
        }
    }

    public static byte[] serializeObject(Object serializedObject) throws IOException {
        try (ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
                ObjectOutputStream objectOutput = new ObjectOutputStream(byteOutput)) {
            objectOutput.writeObject(serializedObject);
            return byteOutput.toByteArray();
        }
    }
}

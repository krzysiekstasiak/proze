/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliary;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJBException;
import javax.ejb.Stateless;

/**
 *
 * @author Krzysztof
 */
@Stateless
public class SerializerBean implements SerializerBeanLocal {

    ByteArrayInputStream byteInput;
    ByteArrayOutputStream byteOutput;
    ObjectInputStream objectInput;
    ObjectOutputStream objectOutput;

    @PostConstruct
    public void createStreams() {
        try {
            this.byteOutput = new ByteArrayOutputStream();
            this.objectOutput = new ObjectOutputStream(this.byteOutput);
        } catch (IOException ex) {
            throw new EJBException(ex);
        }
    }

    @Override
    public byte[] serializeObject(Object serializedObject) {
        try {
            this.byteOutput.reset();
            this.objectOutput.writeObject(serializedObject);
            return this.byteOutput.toByteArray();
        } catch (IOException ex) {
            throw new EJBException(ex);
        }
    }

    @Override
    public Object deserializeObject(byte[] byteArray) {
        try {
            this.byteInput = new ByteArrayInputStream(byteArray);
            this.objectInput = new ObjectInputStream(this.byteInput);
            return this.objectInput.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            throw new EJBException(ex);
        }
    }

    @PreDestroy
    public void closeStreams() {
        try {
            this.byteOutput.close();
            this.objectOutput.close();
            if (this.byteInput != null) {
                this.byteInput.close();
            }
            if (this.objectInput != null) {
                this.objectInput.close();
            }
        } catch (IOException ex) {
            throw new EJBException(ex);
        }
    }

}

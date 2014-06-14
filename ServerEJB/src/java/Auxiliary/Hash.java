package Auxiliary;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Krzysztof
 */
public class Hash {

    public static String generateHash(String input) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return new String(messageDigest.digest(input.getBytes()), "UTF-8");
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new Error(ex);
        }
    }
}

package com.example.demo;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.MessageDigest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Test2 {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update("123436789".getBytes());
        System.out.println(Base64.getEncoder().encodeToString(messageDigest.digest()));

        var s = aesEncrypt("2345678901234567", "123456789");
        System.out.println(s);
    }


    public static String aesEncrypt(String encryptionKey, String valueToEncrypt) {
        try {
            Key key = generateKey(encryptionKey);
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encValue = c.doFinal(valueToEncrypt.getBytes());
            return Base64.getEncoder().encodeToString(encValue);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    private static Key generateKey(String encryptionKey) {
        byte[] keyAsBytes;
        keyAsBytes = encryptionKey.getBytes();
        return new SecretKeySpec(keyAsBytes, "AES");
    }


}

package com.example.demo;

import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

public class HashCreator {

   public String createMD5Hash(final String input)
           throws NoSuchAlgorithmException {

      String hashtext = null;
      MessageDigest md = MessageDigest.getInstance("MD5");

      // Compute message digest of the input
      byte[] messageDigest = md.digest(input.getBytes());

      hashtext = convertToHex(messageDigest);

      return hashtext;
   }

   private String convertToHex(final byte[] messageDigest) {
      BigInteger bigint = new BigInteger(1, messageDigest);
      String hexText = bigint.toString(16);
      while (hexText.length() < 32) {
         hexText = "0".concat(hexText);
      }
      return hexText;
   }

   public static void main(String[] args) throws NoSuchAlgorithmException {
      var md5Hash = new HashCreator().createMD5Hash("MyPassword");
      var abc = Arrays.stream(StringUtils.commaDelimitedListToStringArray("ABC,DBCD")).toList()
              .contains("ABC");


   }
}
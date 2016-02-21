package it.peruvianit.commons.cryptography;

import org.jasypt.util.password.BasicPasswordEncryptor;

public class EncryptorAdapter {
   private BasicPasswordEncryptor encryptor;
   
   public EncryptorAdapter() {
      encryptor = new BasicPasswordEncryptor();
   }

   public String encrypt(String message) {
      return encryptor.encryptPassword(message);
   }

   public boolean decrypt(String plainPassword, String encryptedPassword) {
      return encryptor.checkPassword(plainPassword, encryptedPassword);
   }
}
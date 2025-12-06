package fernandez.max.dam.mp09.uf01.pr2.seguretat.model.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Encryptor {
    
    public static String encrypt(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(text.getBytes());
            
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error en l'encriptació SHA-256", e);
        }
    }
}

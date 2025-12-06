package fernandez.max.dam.mp09.uf01.pr2.seguretat.model.service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESEncryptor {
    
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    
    // Clau per defecte (en un projecte real, aquesta clau s'hauria de gestionar de forma segura)
    private static final String DEFAULT_KEY = "ClauSegura123456"; // 16 bytes per AES-128
    
    public static String encrypt(String text) {
        return encrypt(text, DEFAULT_KEY);
    }
    
    public static String encrypt(String text, String key) {
        try {
            // Assegurar que la clau tingui 16 bytes
            byte[] keyBytes = key.getBytes();
            if (keyBytes.length < 16) {
                byte[] newKey = new byte[16];
                System.arraycopy(keyBytes, 0, newKey, 0, keyBytes.length);
                keyBytes = newKey;
            } else if (keyBytes.length > 16) {
                byte[] newKey = new byte[16];
                System.arraycopy(keyBytes, 0, newKey, 0, 16);
                keyBytes = newKey;
            }
            
            SecretKeySpec secretKey = new SecretKeySpec(keyBytes, ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            
            byte[] encryptedBytes = cipher.doFinal(text.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error en l'encriptació AES", e);
        }
    }
    
    public static String decrypt(String encryptedText) {
        return decrypt(encryptedText, DEFAULT_KEY);
    }
    
    public static String decrypt(String encryptedText, String key) {
        try {
            // Assegurar que la clau tingui 16 bytes
            byte[] keyBytes = key.getBytes();
            if (keyBytes.length < 16) {
                byte[] newKey = new byte[16];
                System.arraycopy(keyBytes, 0, newKey, 0, keyBytes.length);
                keyBytes = newKey;
            } else if (keyBytes.length > 16) {
                byte[] newKey = new byte[16];
                System.arraycopy(keyBytes, 0, newKey, 0, 16);
                keyBytes = newKey;
            }
            
            SecretKeySpec secretKey = new SecretKeySpec(keyBytes, ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error en la desencriptació AES", e);
        }
    }
}

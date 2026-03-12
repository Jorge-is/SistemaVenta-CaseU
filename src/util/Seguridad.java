package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Seguridad {

    public static String hashearClave(String clave) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(clave.getBytes());
            StringBuilder hexString = new StringBuilder();
            
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar la contraseña", e);
        }
    }
}

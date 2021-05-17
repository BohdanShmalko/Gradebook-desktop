package bogdaxios.gradebook.desktop.security;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crypto {
    private static String md5(final String input) throws NoSuchAlgorithmException {
        final MessageDigest md = MessageDigest.getInstance("MD5");
        final byte[] messageDigest = md.digest(input.getBytes());
        final BigInteger number = new BigInteger(1, messageDigest);
        return String.format("%032x", number);
    }

    private Cipher initCipher(final int mode, final String initialVectorString, final String secretKey)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        final SecretKeySpec skeySpec = new SecretKeySpec(md5(secretKey).getBytes(), "AES");
        final IvParameterSpec initialVector = new IvParameterSpec(initialVectorString.getBytes());
        final Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
        cipher.init(mode, skeySpec, initialVector);
        return cipher;
    }

    public String encrypt(final String dataToEncrypt, final String secretKey) {
        String encryptedData = null;
        try {
            // Initialize the cipher
            final Cipher cipher = initCipher(Cipher.ENCRYPT_MODE, complexity(16), secretKey);
            // Encrypt the data
            final byte[] encryptedByteArray = cipher.doFinal(dataToEncrypt.getBytes());
            // Encode using Base64
            encryptedData = new Base64().encode(encryptedByteArray).toString();
        } catch (Exception e) {
            System.err.println("Problem encrypting the data");
            e.printStackTrace();
        }
        return encryptedData;
    }

    public String decrypt(final String encryptedData, final String secretKey) {
        String decryptedData = null;
        try {
            // Initialize the cipher
            final Cipher cipher = initCipher(Cipher.DECRYPT_MODE, complexity(16), secretKey);
            // Decode using Base64
            final byte[] encryptedByteArray = new Base64().decode(encryptedData);
            // Decrypt the data
            final byte[] decryptedByteArray = cipher.doFinal(encryptedByteArray);
            decryptedData = new String(decryptedByteArray, "UTF8");
        } catch (Exception e) {
            System.err.println("Problem decrypting the data");
            e.printStackTrace();
        }
        return decryptedData;
    }

    private String complexity(int howMany) {
        String result = "";
        String numbers = "0123456789";
        for (int i = 0; i < howMany; i++){
            result += numbers.charAt(i % 10);
        }
        return result;
    }

    public String coderEncrypt(String name){
        return new Base64().encode(name.getBytes(StandardCharsets.UTF_8));
    }

    public String coderDecrypt(String hash) throws UnsupportedEncodingException {
        byte decode[] = new Base64().decode(hash);
        return new String(decode, "UTF8");
    }
}
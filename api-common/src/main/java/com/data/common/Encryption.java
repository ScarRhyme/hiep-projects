package com.data.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

public class Encryption {

    private static final Logger LOGGER = Logger.getLogger(Encryption.class);
    private final static byte key[] = {
            -95, -29, -62, 25, 25, -83, -18, -85
    };
    private final static String algorithm = "DES";
    private static final SecretKeySpec keySpec = new SecretKeySpec(key, algorithm);

    public static byte[] encrypt(byte arrByte[]) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(1, keySpec);
        return cipher.doFinal(arrByte);
    }

    public static byte[] decrypt(byte arrByte[]) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(2, keySpec);
        return cipher.doFinal(arrByte);
    }

    public static String decryptToString() throws Exception {
        String input = "";
        String arrTemp[] = input.split("#");
        byte c[] = new byte[arrTemp.length];
        int i = 0;
        String arr[] = arrTemp;
        int len = arr.length;
        for (int j = 0; j < len; j++) {
            String a = arr[j];
            byte b = (new Byte(a));
            LOGGER.debug(b);
            c[i] = b;
            i++;
        }
        return new String(decrypt(c));
    }

    public static void encryptFile(String originalFilePath, String encryptedFilePath)
            throws Exception {
        FileInputStream stream = new FileInputStream(originalFilePath);
        OutputStream out = new FileOutputStream(encryptedFilePath);
        int bytesRead;
        byte buffer[] = new byte[8192];
        byte cloneBuffer[];
        for (; (bytesRead = stream.read(buffer, 0, 8192)) != -1; out.write(encrypt(cloneBuffer))) {
            cloneBuffer = new byte[bytesRead];
            if (bytesRead >= buffer.length) {
                continue;
            }
            System.arraycopy(buffer, 0, cloneBuffer, 0, bytesRead);
        }

        stream.close();
        out.close();
    }

    public static void decryptFile(String encryptedFilePath, String decryptedFilePath) throws Exception {
        FileInputStream stream = new FileInputStream(encryptedFilePath);
        OutputStream out = new FileOutputStream(decryptedFilePath);
        int bytesRead;
        byte buffer[] = new byte[8192];
        byte cloneBuffer[];
        for (; (bytesRead = stream.read(buffer, 0, 8192)) != -1; out.write(decrypt(cloneBuffer))) {
            LOGGER.debug(bytesRead);
            cloneBuffer = new byte[bytesRead];
            if (bytesRead >= buffer.length) {
                continue;
            }
            System.arraycopy(buffer, 0, cloneBuffer, 0, bytesRead);
        }
        stream.close();
        out.close();
    }

    public static String decryptFile(String encryptedFilePath) throws Exception {
        String returnValue = "";
        FileInputStream stream = new FileInputStream(encryptedFilePath);
        int bytesRead;
        byte buffer[] = new byte[8192];
        byte cloneBuffer[];
        while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
            cloneBuffer = new byte[bytesRead];
            if (bytesRead >= buffer.length) {
                continue;
            }
            System.arraycopy(buffer, 0, cloneBuffer, 0, bytesRead);
            returnValue = (new StringBuilder()).append(returnValue).append(new String(decrypt(cloneBuffer))).toString();
        }
        stream.close();
        return returnValue;
    }

}

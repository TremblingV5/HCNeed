package org.hcneed.server.utils;

public class PasswordUtil extends EncryptUtil {

    public static String encrypt(String password, String salt) {
        return encryptWithMD5(password + salt);
    }

    public static boolean checkPassword(String password, String salt, String encrypted) {
        return encrypted == encryptWithMD5(password + salt);
    }

}

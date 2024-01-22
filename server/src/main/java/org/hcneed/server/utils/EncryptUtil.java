package org.hcneed.server.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class EncryptUtil {
    /**
     * 将字节数组转化为 16 进制字符串
     * @param bytes 字节数组
     * @return 16 进制字符串
     */
    public static String byteArrayToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    /**
     * 将 16 进制字符串转化为字节数组
     * @param hexString 16 进制字符串
     * @return 字节数组
     */
    public static byte[] hexStringToByteArray(String hexString) {
        int len = hexString.length();
        byte[] bytes = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            bytes[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i+1), 16));
        }
        return bytes;
    }

    /**
     * 对字符串进行 Base64 编码
     * @param str 需要进行编码的字符串
     * @return Base64 编码后的字符串
     */
    public static String encodeWithBase64(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        byte[] encoded = Base64.getEncoder().encode(bytes);
        return new String(encoded, StandardCharsets.UTF_8);
    }

    /**
     * 对 Base64 编码的字符串进行解码
     * @param encodedStr 需要进行解码的 Base64 编码后的字符串
     * @return 解码后的字符串
     */
    public static String decodeWithBase64(String encodedStr) {
        byte[] encoded = encodedStr.getBytes(StandardCharsets.UTF_8);
        byte[] bytes = Base64.getDecoder().decode(encoded);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    /**
     * 使用 MD5 算法加密字符串
     * @param str 待加密的字符串
     * @return 加密后的字符串
     */
    public static String encryptWithMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(str.getBytes());
            return byteArrayToHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用 SHA-1 算法加密字符串
     * @param str 待加密的字符串
     * @return 加密后的字符串
     */
    public static String encryptWithSHA1(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hash = md.digest(str.getBytes(StandardCharsets.ISO_8859_1));
            return byteArrayToHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用 SHA-256 算法加密字符串
     * @param str 待加密的字符串
     * @return 加密后的字符串
     */
    public static String encryptWithSHA256(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(str.getBytes(StandardCharsets.UTF_8));
            return byteArrayToHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用 SHA-512 算法加密字符串
     * @param str 待加密的字符串
     * @return 加密后的字符串
     */
    public static String encryptWithSHA512(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] hash = md.digest(str.getBytes(StandardCharsets.UTF_8));
            return byteArrayToHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用 SHA3-256 算法加密字符串
     * @param str 待加密的字符串
     * @return 加密后的字符串
     */
    public static String encryptWithSHA3_256(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA3-256");
            byte[] hash = md.digest(str.getBytes(StandardCharsets.UTF_8));
            return byteArrayToHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用 SHA3-512 算法加密字符串
     * @param str 待加密的字符串
     * @return 加密后的字符串
     */
    public static String encryptWithSHA3_512(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA3-512");
            byte[] hash = md.digest(str.getBytes(StandardCharsets.UTF_8));
            return byteArrayToHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用 AES 算法加密字符串
     * @param key 密钥
     * @param str 需要加密的数据
     * @return 加密后的字符串
     */
    public static String encryptWithAES(String str, String key) {
        try {
            byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encrypted = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用 AES 算法解密字符串
     * @param key 密钥
     * @param str 需要加密的数据
     * @return 解密后的字符串
     */
    public static String decryptWithAES(String str, String key) {
        try {
            byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(str));
            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用 DES 算法加密字符串
     * @param key 密钥
     * @param str 需要加密的字符串
     * @return 加密后的字符串
     */

    public static String encryptWithDES(String str, String key) {
        try {
            byte[] iv = new byte[8];
            new SecureRandom().nextBytes(iv);

            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

            byte[] encrypted = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
            byte[] combined = Arrays.copyOf(iv, iv.length + encrypted.length);
            System.arraycopy(encrypted, 0, combined, iv.length, encrypted.length);

            return Base64.getEncoder().encodeToString(combined);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用 DES 算法解密字符串
     * @param key 密钥
     * @param str 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String decryptWithDES(String str, String key) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decoded = Base64.getDecoder().decode(str);
            byte[] decrypted = cipher.doFinal(decoded);
            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取字符串的加密值
     * @param plainText 明文字符串
     * @param encryptType 加密算法
     * @return 加密值
     */
    public static String encrypt(String plainText, String encryptType) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(encryptType);
            messageDigest.update(plainText.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = messageDigest.digest();
            return byteArrayToHexString(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
}


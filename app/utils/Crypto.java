package utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Formatter;
import java.util.List;

public class Crypto {
	private final static String HEX = "0123456789ABCDEF";
	private final static String key = "sd@#flkh#$34324!hksdfhkshf@eggd==$FJKLi%&WQrs";

	/**
	 * Append hex string
	 * 
	 * @param sb
	 * @param b
	 */
	private static void appendHex(StringBuffer sb, byte b) {
		sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
	}

	/**
	 * Get hex string from byte array
	 * 
	 * @param buf
	 * @return
	 */
	public static String toHex(byte[] buf) {
		if (buf == null)
			return "";
		StringBuffer result = new StringBuffer(2 * buf.length);
		for (int i = 0; i < buf.length; i++) {
			appendHex(result, buf[i]);
		}
		return result.toString();
	}

	/**
	 * Encrypt string content with fixed data encryption key
	 * 
	 * @param content
	 * @return
	 */
	public static String encryptData(String content) {
		if (content == null || content.trim().length() == 0)
			return null;
		try {
			byte[] rawKey = generateKey(key.getBytes());
			byte[] result = encrypt(rawKey, content.getBytes());
			return toHex(result);
		} catch (Exception e) {
			// Logger.error(Messages.getInstance().getPasswordRecoveryInvalidUrl(),e);
		}

		return null;
	}

	/**
	 * Get byte array of encrypted
	 * 
	 * @param raw
	 * @param clear
	 * @return
	 * @throws Exception
	 */
	private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(clear);
		return encrypted;
	}

	/**
	 * Generate byte array key from byte array keyvalue
	 * 
	 * @param keyValue
	 * @return
	 * @throws Exception
	 */
	private static byte[] generateKey(byte[] keyValue) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		sr.setSeed(keyValue);
		kgen.init(256, sr); // 256 bits aes
		SecretKey skey = kgen.generateKey();
		byte[] raw = skey.getEncoded();
		return raw;
	}

	/*
	 * Get byte array from hex string
	 * 
	 * @param hexString
	 * 
	 * @return
	 */
	public static byte[] toByte(String hexString) {
		int len = hexString.length() / 2;
		byte[] result = new byte[len];
		for (int i = 0; i < len; i++)
			result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
		return result;
	}

	/*
	 * Get byte array of decrypt
	 * 
	 * @param raw
	 * 
	 * @param encrypted
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] decrypted = cipher.doFinal(encrypted);
		return decrypted;
	}

	/**
	 * Decrypt encrypted content with fixed data encryption key
	 * 
	 * @param content
	 * @return
	 */
	public static String decryptData(String content) {
		if (content == null || content.trim().length() == 0)
			return null;
		try {
			byte[] rawKey = generateKey(key.getBytes());
			byte[] result = decrypt(rawKey, toByte(content));
			return new String(result);
		} catch (Exception e) {
			// Logger.error(Messages.getInstance().getPasswordRecoveryInvalidUrl(),e);
		}

		return null;
	}
}

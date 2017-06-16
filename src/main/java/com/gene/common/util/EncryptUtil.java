package com.gene.common.util;

import com.alibaba.druid.util.Base64;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class EncryptUtil {
	public static final String MD5 = "MD5";
	public static final String SHA1 = "SHA-1";
	private static Key key;

	private static String encrypt(String type, String str) {
		try {
			String result = "";
			MessageDigest md = MessageDigest.getInstance(type);
			byte[] bytes = md.digest(str.getBytes("UTF-8"));
			for (byte b : bytes) {
				String hex = Integer.toHexString(b & 0xFF).toUpperCase();
				result = result + (hex.length() == 1 ? "0" : "") + hex;
			}
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String getMd5(String str) {
		return encrypt("MD5", str);
	}

	public static String getSha1(String str) {
		return encrypt("SHA-1", str);
	}

	public static String getSM32(String str) {
		return getSha1(getMd5(str)).substring(0, 32);
	}

	private static void setkey(String keyStr) {
		try {
			DESKeySpec objDesKeySpec = new DESKeySpec(keyStr.getBytes("UTF-8"));
			SecretKeyFactory objKeyFactory = SecretKeyFactory
					.getInstance("DES");
			key = objKeyFactory.generateSecret(objDesKeySpec);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String encryptString(String str) {
		setkey("11111111111111111111111111111111111111111111111111111111");
		byte[] bytes = str.getBytes();
		try {
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(1, key);
			byte[] encryptStrBytes = cipher.doFinal(bytes);
			return Base64.byteArrayToAltBase64(encryptStrBytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String decryptString(String str) {
		setkey("11111111111111111111111111111111111111111111111111111111");
		try {
			byte[] bytes = Base64.base64ToByteArray(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(2, key);
			bytes = cipher.doFinal(bytes);
			return new String(bytes);
		} catch (Exception e) {
			throw new RuntimeException();
		}

	}

	public static void main(String[] args) {
		String s1 = "adsgfsdfgsdgfd";
		String s2 = getMd5(s1);
		System.out.println("md5密文："+s2);
		System.out.println("md5密文："+s2.equals(getMd5(s1)));
	}
}
package com.ashish.apps.urlshortener.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class UrlShortenerUtils {
	private static final String HASH_ALGORITHM = "MD5";
	
	public static String getTheShortenedURLKey(String longURL) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
		messageDigest.update(longURL.getBytes());
		byte[] hashBytes = messageDigest.digest();
		String base64EncodedStr = Base64.getEncoder().encodeToString(hashBytes);
		return  base64EncodedStr.substring(0, 6);
	}

	public static String getHashAlgorithm() {
		return HASH_ALGORITHM;
	}
	

}

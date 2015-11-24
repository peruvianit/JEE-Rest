package it.peruvianit.commons.util.token;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.springframework.security.crypto.codec.Hex;

public class TokenUtils {
	public static final String MAGIC_KEY = "obfuscate";


	public static String createToken(UserDetails userDetails)
	{
		StringBuilder tokenBuilder = new StringBuilder();		
		tokenBuilder.append(TokenUtils.computeSignature(userDetails));

		return tokenBuilder.toString();
	}

	public static String computeSignature(UserDetails userDetails)	
	{	
		StringBuilder signatureBuilder = new StringBuilder();
		signatureBuilder.append(userDetails.getUsername());		
		signatureBuilder.append(":");		
		signatureBuilder.append(userDetails.getIpAddress());
		signatureBuilder.append(":");
		signatureBuilder.append(UUID.randomUUID().toString());		
		signatureBuilder.append(":");
		signatureBuilder.append(TokenUtils.MAGIC_KEY);

		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("No MD5 algorithm available!");
		}

		return new String(Hex.encode(digest.digest(signatureBuilder.toString().getBytes())));
	}
}

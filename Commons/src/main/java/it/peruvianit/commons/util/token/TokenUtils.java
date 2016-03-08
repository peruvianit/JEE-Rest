package it.peruvianit.commons.util.token;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;

import it.peruvianit.commons.exception.CommonsException;
import it.peruvianit.commons.util.DateUtils;

public class TokenUtils {
	public static String createTokenJWT(UserDetails userDetails, byte[] secret, int expirationSeconds)
	{ 	
		JWTSigner signer = new JWTSigner(secret);
		
		HashMap<String, Object> claims = new HashMap<String, Object>();
		// claims.put("iss", ""); PUBLIC API KEY - DA IMPLEMENTARE
		claims.put("sub", userDetails.getUsername());
		claims.put("iat", DateUtils.getCurrentTimeUTC());
		claims.put("exp", DateUtils.getCurrentTimeUTC() + expirationSeconds);
		claims.put("aud", userDetails.getIpAddress());
		
		return signer.sign(claims);		
	}
	
	public static Map<String, Object> verifyTokenJWT(String token, byte[] secret) throws CommonsException
	{ 	
		JWTVerifier verifier = new JWTVerifier(secret);
		Map<String, Object> decoded = null;
		
		try {
			decoded = verifier.verify(token);
			System.out.println(decoded);
		} catch (InvalidKeyException | NoSuchAlgorithmException | IllegalStateException | SignatureException
				| IOException | JWTVerifyException e) {
			throw new CommonsException(e.getMessage());
		}
		
		return decoded;
	}
}

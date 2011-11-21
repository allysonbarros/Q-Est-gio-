package helpers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SessionsHelper {
	public static String criptografarSenha(String senha) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
	    digest.update(senha.getBytes(), 0, senha.length());
	    return new BigInteger(1, digest.digest()).toString(16);
	}
}

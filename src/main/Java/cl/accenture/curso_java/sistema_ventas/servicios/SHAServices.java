/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.servicios;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/**
 * @author Juan Mendoza
 *
 */
public class SHAServices {

	
	
	public String servicio(String texto) throws NoSuchAlgorithmException{
	
	MessageDigest md = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
	md.update(texto.getBytes());
	byte [] digest = md.digest();
	byte [] encoded = Base64.encodeBase64(digest);
	return new String(encoded);
	}
}

/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.excepciones;

/**
 * @author Martin Cuevas
 *
 */
public class NoSeEncuentraPerfilException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9036125005384135064L;

	public NoSeEncuentraPerfilException(String mensaje) {
		super(mensaje);
	}
}

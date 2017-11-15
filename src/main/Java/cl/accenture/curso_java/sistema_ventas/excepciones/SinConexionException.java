/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.excepciones;

/**
 * @author Martin Cuevas
 *
 */
public class SinConexionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5212029369340209293L;

	public SinConexionException(String mensaje) {
		super(mensaje);
	}
	
	public SinConexionException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}
}

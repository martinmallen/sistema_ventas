/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

import cl.accenture.curso_java.sistema_ventas.excepciones.SinConexionException;

/**
 * @author Martin Cuevas
 *
 */
public class Conexion {
	private String host, baseDeDatos, nombre, password;
	private int puerto;
	private static final String VAR_HOST_MYSQL = "MYSQL_SISINVENTARIO_PORT_3306_TCP_ADDR";

	/**
	 * 
	 */
	public Conexion() {
		this.host = "127.0.0.1"; // o "localhost"
		this.baseDeDatos = "sisinventario";
		this.nombre = "root";
		this.password = "m4l3np1wk3";
		this.puerto = 3306;
		
		Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                              envName,
                              env.get(envName));
        }
		
		String hostOpenShift = System.getenv(VAR_HOST_MYSQL);
		if( hostOpenShift != null ){
			this.host = hostOpenShift;
		}
	}

	/**
	 * @param host
	 * @param baseDeDatos
	 * @param nombre
	 * @param password
	 * @param puerto
	 */
	public Conexion(String host, String baseDeDatos, String nombre, String password, int puerto) {
		this.host = host;
		this.baseDeDatos = baseDeDatos;
		this.nombre = nombre;
		this.password = password;
		this.puerto = puerto;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host
	 *            the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the baseDeDatos
	 */
	public String getBaseDeDatos() {
		return baseDeDatos;
	}

	/**
	 * @param baseDeDatos
	 *            the baseDeDatos to set
	 */
	public void setBaseDeDatos(String baseDeDatos) {
		this.baseDeDatos = baseDeDatos;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the puerto
	 */
	public int getPuerto() {
		return puerto;
	}

	/**
	 * @param puerto
	 *            the puerto to set
	 */
	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	public Connection obtenerConexion() throws SinConexionException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.puerto + "/" + this.baseDeDatos, this.nombre, this.password);
			return conexion;
		} catch (Exception e) {
			throw new SinConexionException("No se ha podido establecer la conexion con la base de datos" + e.getMessage(), e);
		}
	}
}

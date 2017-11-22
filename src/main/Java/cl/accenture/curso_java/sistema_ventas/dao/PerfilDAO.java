/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.dao;

import cl.accenture.curso_java.sistema_ventas.modelo.Conexion;

/**
 * @author Usuario
 *
 */
public class PerfilDAO {
	
	private Conexion conexion;

	/**
	 * 
	 */
	public PerfilDAO() {
	}

	/**
	 * @param conexion
	 */
	public PerfilDAO(Conexion conexion) {
		this.conexion = conexion;
	}

	/**
	 * @return the conexion
	 */
	public Conexion getConexion() {
		return conexion;
	}

	/**
	 * @param conexion the conexion to set
	 */
	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
	
	
		
	

}

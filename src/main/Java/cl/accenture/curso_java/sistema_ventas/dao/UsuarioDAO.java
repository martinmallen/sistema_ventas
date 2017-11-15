/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import cl.accenture.curso_java.sistema_ventas.excepciones.SinConexionException;
import cl.accenture.curso_java.sistema_ventas.modelo.Conexion;
import cl.accenture.curso_java.sistema_ventas.modelo.Usuario;

/**
 * @author Juan Mendoza
 *
 */
public class UsuarioDAO {
	
	private Conexion conexion;

	/**
	 * 
	 */
	public UsuarioDAO() {
		
		conexion = new Conexion();
	}

	/**
	 * @param conexion
	 */
	public UsuarioDAO(Conexion conexion) {
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
	
	public void ingresarUsuario(Usuario usuario) throws SQLException, SinConexionException{
		
		PreparedStatement ps = conexion.obtenerConexion().prepareStatement("INSERT INTO Usuario(?,?,?,?,?,?)");
		
				
	}

}

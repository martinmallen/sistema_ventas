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
 * @author Martin Cuevas
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
		
		PreparedStatement psInsert = conexion.obtenerConexion().prepareStatement("INSERT INTO Usuario (nombre, apellido, password, email, rut, estado, perfil_nombre, Sucursal_idSucursal)" 
				+ "VALUES (?,?,?,?,?,?,?,?);");
		psInsert.setString(1, usuario.getNombre());
		psInsert.setString(2, usuario.getApellido());
		psInsert.setString(3, usuario.getPassword());
		psInsert.setString(4, usuario.getEmail());
		psInsert.setString(5, usuario.getRut());
		psInsert.setBoolean(6, usuario.isEstado());
		psInsert.setString(7, usuario.getPerfil().getNombre());
		psInsert.setInt(8, usuario.getIdSucursal());
		psInsert.executeUpdate();
		
		
		
				
	}

}

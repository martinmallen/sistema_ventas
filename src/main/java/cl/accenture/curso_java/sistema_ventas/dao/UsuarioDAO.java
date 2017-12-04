/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cl.accenture.curso_java.sistema_ventas.excepciones.NoSeEncuentraPerfilException;
import cl.accenture.curso_java.sistema_ventas.excepciones.SinConexionException;
import cl.accenture.curso_java.sistema_ventas.modelo.Conexion;
import cl.accenture.curso_java.sistema_ventas.modelo.Perfil;
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
	 * @param conexion
	 *            the conexion to set
	 */
	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	public void ingresarUsuario(Usuario usuario) throws SQLException, SinConexionException {

		PreparedStatement psInsert = conexion.obtenerConexion().prepareStatement(
				"INSERT INTO Usuario (nombre, apellido, password, email, rut, estado, perfil_nombre, Sucursal_idSucursal)"
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

	public boolean ingresar(Usuario usuario) throws SQLException, SinConexionException, NoSeEncuentraPerfilException {

		PreparedStatement psSelect = conexion.obtenerConexion()
				.prepareStatement("SELECT * FROM usuario Where rut = ? AND password = ?;");
		psSelect.setString(1, usuario.getRut());
		psSelect.setString(2, usuario.getPassword());
		ResultSet rs = psSelect.executeQuery();
		PerfilDAO pfdao = new PerfilDAO();
		if (rs.next()) {
			usuario.setNombre(rs.getString("nombre"));
			usuario.setApellido(rs.getString("apellido"));
			usuario.setIdSucursal(rs.getInt("Sucursal_idSucursal"));
			Perfil perfil = pfdao.obtenerPerfil(rs.getString("perfil_nombre"));
			usuario.setPerfil(perfil);
			return true;
		}
		return false;
	}

	public void datosUsuario(Usuario usuario) throws SQLException, SinConexionException {

		PreparedStatement psSelect = conexion.obtenerConexion()
				.prepareStatement("SELECT nombre, apellido, Sucursal_idSucursal FROM usuario Where rut = ?;");
		psSelect.setString(1, usuario.getRut());
		ResultSet rs = psSelect.executeQuery();
		while (rs.next()) {
			usuario.setNombre(rs.getString("nombre"));
			usuario.setApellido(rs.getString("apellido"));
			usuario.setIdSucursal(rs.getInt("Sucursal_idSucursal"));
			Perfil perfil = new Perfil(rs.getString("perfil_nombre"));
			usuario.setPerfil(perfil);
		}

	}

}
/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.accenture.curso_java.sistema_ventas.excepciones.SinConexionException;
import cl.accenture.curso_java.sistema_ventas.modelo.Conexion;
import cl.accenture.curso_java.sistema_ventas.modelo.Perfil;
import cl.accenture.curso_java.sistema_ventas.modelo.Sucursal;
import cl.accenture.curso_java.sistema_ventas.modelo.Usuario;

/**
 * @author Martin Cuevas
 *
 */
public class SucursalDAO {
	private Conexion conexion;

	/**
	 * 
	 */
	public SucursalDAO() {
		this.conexion = new Conexion();
	}

	/**
	 * @param conexion
	 */
	public SucursalDAO(Conexion conexion) {
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

	public void insertarSucursal(Sucursal sucursal) throws SQLException, SinConexionException {
		PreparedStatement psInsert = conexion.obtenerConexion()
				.prepareStatement("INSERT INTO Sucursal(idSucursal,nombre,direccion)" + "VALUES (?, ?, ?);");
		psInsert.setInt(1, sucursal.getIdSucursal());
		psInsert.setString(2, sucursal.getNombre());
		psInsert.setString(3, sucursal.getDireccion());
		psInsert.executeUpdate();
	}

	public List<Usuario> buscarUsuarioSucursal(Sucursal sucursal) throws SQLException, SinConexionException {

		List<Usuario> usuarios = new ArrayList<Usuario>();
		PreparedStatement ps = conexion.obtenerConexion()
				.prepareStatement("Select * into Usuario where Sucursal_idSucursal =" + sucursal.getIdSucursal() + ";");
		ResultSet rs = ps.executeQuery();


		while (rs.next()) {
			Perfil perfil = new Perfil(rs.getString("Perfil_nombre"));
			usuarios.add(new Usuario(rs.getString("rut"), rs.getString("nombre"), rs.getString("password"),
					rs.getString("email"), perfil, rs.getString("apellido"), rs.getBoolean("estado"),
					rs.getInt("Sucursal_idSucursal")));


		}

		return usuarios;
	}

	public void blockear(Sucursal sucursal) throws SQLException, SinConexionException {
		PreparedStatement ps = conexion.obtenerConexion()
				.prepareStatement("Update Sucursal SET estado = false WHERE idSucursal =" + sucursal.getIdSucursal()+";");
		
		ps.executeUpdate();
		
		
	}
	public void listarSucursales() {
		
	}

}

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
import cl.accenture.curso_java.sistema_ventas.modelo.Permiso;

/**
 * @author Martin Cuevas
 *
 */
public class PermisoDAO {
	private Conexion conexion;

	/**
	 * 
	 */
	public PermisoDAO() {
		this.conexion = new Conexion();
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

	public List<Permiso> obtenerPermisos(Perfil perfil) throws SQLException, SinConexionException {
		List<Permiso> permisos = new ArrayList<Permiso>();
		PreparedStatement psSelect = conexion.obtenerConexion().prepareStatement("SELECT * FROM sisinventario.perfil_has_permiso fp, sisinventario.permiso p where fp.Perfil_nombre = ? and fp.Permiso_idPermiso = p.idPermiso;");
		psSelect.setString(1, perfil.getNombre());
		ResultSet rs = psSelect.executeQuery();
		while (rs.next()) {
			Permiso permiso = new Permiso();
			permiso.setTipo(rs.getString("tipo"));
			permisos.add(permiso);
		}
		return permisos;
	}

}

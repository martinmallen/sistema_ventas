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

/**
 * @author Martin Cuevas
 *
 */
public class PerfilDAO {

	private Conexion conexion;

	/**
	 * 
	 */
	public PerfilDAO() {
		this.conexion = new Conexion();
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
	
	public Perfil obtenerPerfil(String nombrePerfil) throws SQLException, SinConexionException, NoSeEncuentraPerfilException {
		PreparedStatement psSelect = conexion.obtenerConexion().prepareStatement("SELECT * FROM perfil WHERE nombre =? ;");
		psSelect.setString(1, nombrePerfil );
		ResultSet rs = psSelect.executeQuery();
		PermisoDAO pdao = new PermisoDAO();
		if( rs.next() ){
			Perfil perfil = new Perfil();
			perfil.setNombre( rs.getString("nombre") );
			perfil.setPermisos( pdao.obtenerPermisos(perfil) );
			return perfil;
		}
		throw new NoSeEncuentraPerfilException("Perfil de usuario No Encontrado");
	}
}

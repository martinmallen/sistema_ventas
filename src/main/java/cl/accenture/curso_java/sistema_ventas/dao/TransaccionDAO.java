/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import cl.accenture.curso_java.sistema_ventas.excepciones.SinConexionException;
import cl.accenture.curso_java.sistema_ventas.modelo.Conexion;
import cl.accenture.curso_java.sistema_ventas.modelo.Transaccion;
import cl.accenture.curso_java.sistema_ventas.modelo.Usuario;

/**
 * @author Mauricio
 *
 */
public class TransaccionDAO {

	private Conexion conexion;
	private List<Transaccion> transacciones;

	public TransaccionDAO() {

		this.conexion = new Conexion();
		this.transacciones = new ArrayList<Transaccion>();
	}

	public TransaccionDAO(Conexion conexion, List<Transaccion> transacciones) {
		this.conexion = conexion;
		this.transacciones = transacciones;
	}

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	public List<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	public void guardarTransaccion(Transaccion transaccion) throws SQLException, SinConexionException {
		Connection conec = conexion.obtenerConexion();
		Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		PreparedStatement psInsert = conec.prepareStatement(
				"INSERT INTO transaccion(valor, fecha, usuario_rut)" + "VALUES (?, ?, ?);");

		// psInsert.setInt(1, transaccion.getIdTransaccion());
		psInsert.setInt(1, transaccion.getValor());
		psInsert.setDate(2, new java.sql.Date(transaccion.getFecha().getTime()));
		psInsert.setString(3, user.getRut());
		

		psInsert.executeUpdate();

	}

	public List<Transaccion> obtenerTransacciones() throws SQLException, SinConexionException {
		List<Transaccion> transacciones = new ArrayList<Transaccion>();

		PreparedStatement st = conexion.obtenerConexion().prepareStatement("select * from transaccion;");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Transaccion transaccion = new Transaccion();
			transaccion.setIdTransaccion(rs.getInt("idTransaccion"));
			transaccion.setValor(rs.getInt("valor"));
			transaccion.setFecha(rs.getDate("fecha"));

			transacciones.add(transaccion);
		}
		return transacciones;
	}

	public List<Transaccion> obtenerTransaccionesFecha(Date fecha1, Date fecha2)
			throws SQLException, SinConexionException {
		List<Transaccion> tran = new ArrayList<Transaccion>();
		PreparedStatement ps = conexion.obtenerConexion()
				.prepareStatement("SELECT * FROM transaccion WHERE fecha BETWEEN " + fecha1 + " AND " + fecha2 + ";");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Transaccion transaccion = new Transaccion();
			transaccion.setIdTransaccion(rs.getInt("idTransaccion"));
			transaccion.setValor(rs.getInt("valor"));
			transaccion.setFecha(rs.getDate("fecha"));

			tran.add(transaccion);

		}

		return tran;
	}

	public Transaccion ultimaTransaccion() throws SQLException, SinConexionException {
		Transaccion t = new Transaccion();
		PreparedStatement ps = conexion.obtenerConexion()
				.prepareStatement("SELECT * FROM transaccion ORDER BY idTransaccion DESC LIMIT 1", Statement.RETURN_GENERATED_KEYS);

		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
		
		t.setIdTransaccion(rs.getInt("idTransaccion"));
		//t.setValor(rs.getInt("valor"));
		//t.setFecha(rs.getDate("fecha"));
		}
		return t;
	}
		
		
}

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
import cl.accenture.curso_java.sistema_ventas.modelo.DetalleTransaccion;
import cl.accenture.curso_java.sistema_ventas.modelo.Producto;
import cl.accenture.curso_java.sistema_ventas.modelo.Transaccion;

/**
 * @author Administrador
 *
 */
public class DetalleDAO {

	private Conexion conexion;

	public DetalleDAO() {
		this.conexion = new Conexion();
	}

	public DetalleDAO(Conexion conexion) {
		
		this.conexion = conexion;
	}

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
	
	
	public List<DetalleTransaccion> obtenerDetalle(Transaccion transaccion) throws SQLException, SinConexionException{
		List<DetalleTransaccion> tran = new ArrayList<DetalleTransaccion>();
		PreparedStatement ps = conexion.obtenerConexion().prepareStatement("select * from detalletransaccion where Transaccion_idTransaccion = "+transaccion.getIdTransaccion()+";");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Producto pro = new ProductoDAO().obtenerProducto(rs.getInt("Producto_idProducto"));
			tran.add(new DetalleTransaccion(rs.getInt("idDetalleTransaccion"), rs.getInt("unidades"), rs.getInt("subtotal"), pro));
			
		}
		
		return tran;
		
	}
	public void guardarDetalle(DetalleTransaccion det) throws SQLException, SinConexionException{
		PreparedStatement psInsert = conexion.obtenerConexion()
				.prepareStatement("INSERT INTO detalletransaccion(idDetalleTransaccion,unidades,subtotal,Producto_idProducto" + "VALUES (?, ?, ?,?);");
		psInsert.setInt(1, det.getIdDetalleTransaccion());
		psInsert.setInt(2, det.getUnidades());
		psInsert.setInt(3, det.getSubtotal());
		psInsert.setInt(4,  det.getProducto().getIdProducto());
		psInsert.executeUpdate();
	}
}

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
import cl.accenture.curso_java.sistema_ventas.modelo.Producto;

/**
 * @author Mauricio
 *
 */
public class ProductoDAO {

	private Conexion conexion;

	public ProductoDAO() {

		conexion = new Conexion();
	}

	public ProductoDAO(Conexion conexion) {
		this.conexion = conexion;
	}

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

//	public void ingresarProductoTEST(Producto producto) throws SQLException, SinConexionException {
//
//		PreparedStatement psInsert = conexion.obtenerConexion()
//				.prepareStatement("INSERT INTO Producto(idProducto, nombre, precio, marca, stock, categoria, minstock)"
//						+ "VALUES (?,?,?,?,?,?,?);");
//		psInsert.setInt(1, producto.getIdProducto());
//		psInsert.setString(2, producto.getNombre());
//		psInsert.setInt(3, producto.getPrecio());
//		psInsert.setString(4, producto.getMarca());
//		psInsert.setInt(5, producto.getStock());
//		psInsert.setString(6, producto.getCategoria());
//		psInsert.setInt(7, producto.getMinstock());
//		psInsert.executeUpdate();
//
//	}

	public List<Producto> obtenerProductos() throws SQLException, SinConexionException {
		List<Producto> productos = new ArrayList<Producto>();
		
		PreparedStatement st = conexion.obtenerConexion().prepareStatement("select * from producto;");
		ResultSet rs = st.executeQuery();
		while( rs.next() ){
			Producto producto = new Producto();
			producto.setIdProducto( rs.getInt("idProducto") );
			producto.setNombre( rs.getString("nombre") );
			producto.setPrecio( rs.getInt("precio") );
			producto.setMarca( rs.getString("marca") );
			producto.setStock( rs.getInt("stock") );
			producto.setCategoria( rs.getString("categoria") );
			producto.setMinstock( rs.getInt("minstock") );
			productos.add(producto);
		}
		return productos;
	}
}

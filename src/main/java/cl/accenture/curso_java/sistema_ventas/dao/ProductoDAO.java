/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import cl.accenture.curso_java.sistema_ventas.excepciones.SinConexionException;
import cl.accenture.curso_java.sistema_ventas.modelo.Conexion;
import cl.accenture.curso_java.sistema_ventas.modelo.Producto;
import cl.accenture.curso_java.sistema_ventas.modelo.Usuario;

/**
 * @author Mauricio
 *
 */
public class ProductoDAO {

	private Conexion conexion;

	private List<Producto> productos;

	/**
	 * 
	 */
	public ProductoDAO() {
		this.conexion = new Conexion();
		this.productos = new ArrayList<Producto>();
	}

	/**
	 * @param conexion
	 * @param productos
	 */
	public ProductoDAO(Conexion conexion, List<Producto> productos) {
		this.conexion = conexion;
		this.productos = productos;
	}

	/**
	 * @return the conexion
	 */

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	/**
	 * @return the productos
	 */
	public List<Producto> getProductos() {
		return productos;
	}

	/**
	 * @param productos
	 *            the productos to set
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	/**
	 * @return the idSucursal
	 */

	public void guardarProductos(List<Producto> productos) throws SQLException, SinConexionException {
		Connection conec = conexion.obtenerConexion();
		for (Producto producto : productos) {
			PreparedStatement psInsert = conec.prepareStatement(
					"INSERT INTO producto(idProducto, nombre, precio, marca, stock, categoria, minstock, sucursal_idSucursal)"
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);");

			psInsert.setInt(1, producto.getIdProducto());
			psInsert.setString(2, producto.getNombre());
			psInsert.setInt(3, producto.getPrecio());
			psInsert.setString(4, producto.getMarca());
			psInsert.setInt(5, producto.getStock());
			psInsert.setString(6, producto.getCategoria());
			psInsert.setInt(7, producto.getMinstock());
			psInsert.setInt(8, producto.getSucursal_idSucursal());

			psInsert.executeUpdate();
		}

	}

	public List<Producto> obtenerProductos() throws SQLException, SinConexionException {
		List<Producto> productos = new ArrayList<Producto>();

		PreparedStatement st = conexion.obtenerConexion().prepareStatement("select * from producto;");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Producto producto = new Producto();
			producto.setIdProducto(rs.getInt("idProducto"));
			producto.setNombre(rs.getString("nombre"));
			producto.setPrecio(rs.getInt("precio"));
			producto.setMarca(rs.getString("marca"));
			producto.setStock(rs.getInt("stock"));
			producto.setCategoria(rs.getString("categoria"));
			producto.setMinstock(rs.getInt("minstock"));
			producto.setSucursal_idSucursal(rs.getInt("sucursal_idSucursal"));
			productos.add(producto);
		}
		return productos;
	}

	public List<Producto> buscarProductosNombre(String nombre) throws SQLException, SinConexionException {
		List<Producto> productos = new ArrayList<Producto>();
		PreparedStatement pst = conexion.obtenerConexion().prepareStatement("select * from producto WHERE nombre = ?;");
		pst.setString(1, nombre);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Producto producto = new Producto();
			producto.setIdProducto(rs.getInt("idProducto"));
			producto.setNombre(rs.getString("nombre"));
			producto.setPrecio(rs.getInt("precio"));
			producto.setMarca(rs.getString("marca"));
			producto.setStock(rs.getInt("stock"));
			producto.setCategoria(rs.getString("categoria"));
			producto.setMinstock(rs.getInt("minstock"));
			producto.setSucursal_idSucursal(rs.getInt("sucursal_idSucursal"));
			productos.add(producto);
		}
		return productos;
	}

	public List<Producto> obtenerProductosSucursal(int idSucursal) throws SQLException, SinConexionException {
		List<Producto> productos = new ArrayList<Producto>();
		PreparedStatement psSelect = conexion.obtenerConexion()
				.prepareStatement("SELECT * FROM producto WHERE sucursal_idSucursal = ?;");
		psSelect.setInt(1, idSucursal);
		ResultSet rs = psSelect.executeQuery();
		while (rs.next()) {
			Producto producto = new Producto();
			producto.setIdProducto(rs.getInt("idProducto"));
			producto.setNombre(rs.getString("nombre"));
			producto.setPrecio(rs.getInt("precio"));
			producto.setMarca(rs.getString("marca"));
			producto.setStock(rs.getInt("stock"));
			producto.setCategoria(rs.getString("categoria"));
			producto.setMinstock(rs.getInt("minstock"));
			productos.add(producto);
		}
		return productos;
	}

	public Producto obtenerProducto(int id) throws SQLException, SinConexionException {

		PreparedStatement ps = conexion.obtenerConexion()
				.prepareStatement("Select * from producto where idProducto =" + id + ";");
		ResultSet rs = ps.executeQuery();

		Producto producto = new Producto();
		producto.setIdProducto(rs.getInt("idProducto"));
		producto.setNombre(rs.getString("nombre"));
		producto.setPrecio(rs.getInt("precio"));
		producto.setMarca(rs.getString("marca"));
		producto.setStock(rs.getInt("stock"));
		producto.setCategoria(rs.getString("categoria"));
		producto.setMinstock(rs.getInt("minstock"));

		return producto;

	}

	public Producto buscarProducto(int idSucursal, String nombreP) throws SQLException, SinConexionException {
		Producto producto = new Producto();
		PreparedStatement psSelect = conexion.obtenerConexion()
				.prepareStatement("SELECT * FROM producto WHERE sucursal_idSucursal = ? AND nombre = ? ;");
		psSelect.setInt(1, idSucursal);
		psSelect.setString(2, nombreP);
		ResultSet rs = psSelect.executeQuery();
		if (rs.next()) {
			producto.setIdProducto(rs.getInt("idProducto"));
			producto.setNombre(rs.getString("nombre"));
			producto.setPrecio(rs.getInt("precio"));
			producto.setMarca(rs.getString("marca"));
			producto.setStock(rs.getInt("stock"));
			producto.setCategoria(rs.getString("categoria"));
			producto.setMinstock(rs.getInt("minstock"));
			producto.setSucursal_idSucursal(rs.getInt("sucursal_idSucursal"));
		}
		return producto;
	}

	public void modificarProducto(Producto producto) throws SQLException, SinConexionException {
		PreparedStatement psUpdate = conexion.obtenerConexion()
				.prepareStatement("UPDATE producto SET precio = ?, stock = ?, minstock = ? WHERE idProducto = ? ;");
		psUpdate.setInt(1, producto.getPrecio());
		psUpdate.setInt(2, producto.getStock());
		psUpdate.setInt(3, producto.getMinstock());
		psUpdate.setInt(4, producto.getIdProducto());
		psUpdate.executeUpdate();
	}

	public void modificarStock(int stock, int id) throws SQLException, SinConexionException {
		int stockfinal = 0;
		Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		PreparedStatement psSelect = conexion.obtenerConexion()
				.prepareStatement("SELECT * FROM producto WHERE sucursal_idSucursal = ? AND idProducto = ? ;");

		psSelect.setInt(1, user.getIdSucursal());
		psSelect.setInt(2, id);
		ResultSet rs = psSelect.executeQuery();
		Producto pro = new Producto();
		if (rs.next()) {

			pro.setStock(rs.getInt("stock"));

		}
		stockfinal = pro.getStock() - stock;
		PreparedStatement psUpdate = conexion.obtenerConexion()
				.prepareStatement("UPDATE producto SET  stock = ? WHERE idProducto = ? ;");
		psUpdate.setInt(1, stockfinal);
		psUpdate.setInt(2, id);
		psUpdate.executeUpdate();

	}

	public List<Producto> buscarPrecio(int min, int max) throws SQLException, SinConexionException {
		
		Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		
		
		
		List<Producto> pro = new ArrayList<Producto>();
		
		PreparedStatement ps = conexion.obtenerConexion()
				.prepareStatement("SELECT * FROM producto WHERE precio BETWEEN ? AND ? ;");
		ps.setInt(1, min);
		ps.setInt(2, max);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Producto producto = new Producto();
			producto.setIdProducto(rs.getInt("idProducto"));
			producto.setNombre(rs.getString("nombre"));
			producto.setPrecio(rs.getInt("precio"));
			producto.setMarca(rs.getString("marca"));
			producto.setStock(rs.getInt("stock"));
			producto.setCategoria(rs.getString("categoria"));
			producto.setMinstock(rs.getInt("minstock"));
			producto.setSucursal_idSucursal(rs.getInt("sucursal_idSucursal"));

			pro.add(producto);
		}
		return pro;
	}
}

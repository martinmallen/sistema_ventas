/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.modelo;

/**
 * @author Usuario
 *
 */
public class Producto {

	private int idProducto;
	private String nombre;
	private int precio;
	private String marca;
	private int stock;
	private String categoria;
	private int minstock;
	private int Sucursal_idSucursal;

	/**
	 * 
	 */
	/**
	 * 
	 */
	public Producto() {
	}

	/**
	 * @param idProducto
	 * @param nombre
	 * @param precio
	 * @param marca
	 * @param stock
	 * @param categoria
	 * @param minstock
	 */
	public Producto(int idProducto, String nombre, int precio, String marca, int stock, String categoria,
			int minstock, int Sucursal_idSucursal) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
		this.categoria = categoria;
		this.minstock = minstock;
		this.Sucursal_idSucursal = Sucursal_idSucursal;
	}

	/**
	 * @return the idProducto
	 */
	public int getIdProducto() {
		return idProducto;
	}

	/**
	 * @param idProducto
	 *            the idProducto to set
	 */
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * @param precio
	 *            the precio to set
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca
	 *            the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock
	 *            the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria
	 *            the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the minstock
	 */
	public int getMinstock() {
		return minstock;
	}

	/**
	 * @param minstock
	 *            the minstock to set
	 */
	public void setMinstock(int minstock) {
		this.minstock = minstock;
	}

	/**
	 * @return the sucursal_idSucursal
	 */
	public int getSucursal_idSucursal() {
		return Sucursal_idSucursal;
	}

	/**
	 * @param sucursal_idSucursal the sucursal_idSucursal to set
	 */
	public void setSucursal_idSucursal(int sucursal_idSucursal) {
		Sucursal_idSucursal = sucursal_idSucursal;
	}
	
	

}

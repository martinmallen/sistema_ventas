/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.controlador;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



/**
 * @author Usuario
 *
 */
@ManagedBean
@SessionScoped
public class ProductoControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8573637518672737991L;
	private int idProducto;
	private String nombre;
	private int precio;
	private String marca;
	private int stock;
	private String categoria;
	/**
	 * 
	 */
	public ProductoControlador() {
	}
	/**
	 * @param idProducto
	 * @param nombre
	 * @param precio
	 * @param marca
	 * @param stock
	 * @param categoria
	 */
	public ProductoControlador(int idProducto, String nombre, int precio, String marca, int stock, String categoria) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
		this.categoria = categoria;
	}
	/**
	 * @return the idProducto
	 */
	public int getIdProducto() {
		return idProducto;
	}
	/**
	 * @param idProducto the idProducto to set
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
	 * @param nombre the nombre to set
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
	 * @param precio the precio to set
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
	 * @param marca the marca to set
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
	 * @param stock the stock to set
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
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
}

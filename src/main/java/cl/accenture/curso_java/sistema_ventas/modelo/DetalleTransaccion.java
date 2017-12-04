/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.modelo;


/**
 * @author Usuario
 *
 */
public class DetalleTransaccion {

	private int idDetalleTransaccion;
	private int unidades;
	private int subtotal;
	private Producto producto;
	/**
	 * @param producto2 
	 * @param subtotal2 
	 * @param precioP 
	 * 
	 */
	public DetalleTransaccion(int unidades, int subtotal, Producto producto) {
	
		  this.unidades = unidades;
		  this.subtotal = subtotal;
		  this.producto = producto;
	}
	/**
	 * @param idDetalleTransaccion
	 * @param unidades
	 * @param subtotal
	 * @param productos
	 */
	public DetalleTransaccion(int idDetalleTransaccion, int unidades, int subtotal, Producto producto) {
		this.idDetalleTransaccion = idDetalleTransaccion;
		this.unidades = unidades;
		this.subtotal = subtotal;
		this.producto = producto;
	}
	/**
	 * @return the idDetalleTransaccion
	 */
	public int getIdDetalleTransaccion() {
		return idDetalleTransaccion;
	}
	/**
	 * @param idDetalleTransaccion the idDetalleTransaccion to set
	 */
	public void setIdDetalleTransaccion(int idDetalleTransaccion) {
		this.idDetalleTransaccion = idDetalleTransaccion;
	}
	/**
	 * @return the unidades
	 */
	public int getUnidades() {
		return unidades;
	}
	/**
	 * @param unidades the unidades to set
	 */
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	/**
	 * @return the subtotal
	 */
	public int getSubtotal() {
		return subtotal;
	}
	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	/**
	 * @return the productos
	 */
	public Producto getProducto() {
		return producto;
	}
	/**
	 * @param productos the productos to set
	 */
	public void setProductos(Producto producto) {
		this.producto = producto;
	}
	
	
}

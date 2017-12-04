/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.modelo;

/**
 * @author Usuario
 *
 */
public class Unidades {

	private Producto producto;
	private int unidad;

	/**
	 * 
	 */
	public Unidades() {
	}

	/**
	 * @param producto
	 * @param unidad
	 */
	public Unidades(Producto producto, int unidad) {
		this.producto = producto;
		this.unidad = unidad;
	}

	/**
	 * @param unidad
	 */
	public Unidades(int unidad) {
		this.unidad = unidad;
	}

	/**
	 * @return the unidad
	 */
	public int getUnidad() {
		return unidad;
	}

	/**
	 * @param unidad the unidad to set
	 */
	public void setUnidad(int unidad) {
		this.unidad = unidad;
	}


	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}


	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	/**
	 * @return the producto
	 */
	
	
	 
}

/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Usuario
 *
 */
@ManagedBean
@SessionScoped
public final class ListaProductoControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5609055437466574198L;
	private List<ProductoControlador> productos;

	/**
	 * 
	 */
	public ListaProductoControlador() {
		listar();
	}

	/**
	 * @param productos
	 */
	public ListaProductoControlador(List<ProductoControlador> productos) {
		this.productos = productos;
	}

	/**
	 * @return the productos
	 */
	public List<ProductoControlador> getProductos() {
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(List<ProductoControlador> productos) {
		this.productos = productos;
	}
	
	public void listar(){
		ProductoControlador p1 = new ProductoControlador(1, "telefono", 1000, "fono", 10, "caca");
		List<ProductoControlador> list1 = new ArrayList<ProductoControlador>();
		list1.add(p1);
		this.setProductos(list1);
	}
	
}

package cl.accenture.curso_java.sistema_ventas.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import cl.accenture.curso_java.sistema_ventas.dao.ProductoDAO;
import cl.accenture.curso_java.sistema_ventas.modelo.Producto;
import cl.accenture.curso_java.sistema_ventas.modelo.Usuario;

/**
 * @author Mauricio
 *
 */

@ManagedBean
@SessionScoped

public class ListarProductosControlador implements Serializable {

	private static final long serialVersionUID = -4669809923772737328L;
	private static final Logger LOGGER = Logger.getLogger(ListarProductosControlador.class);
	private List<Producto> productos;
	private List<Producto> productosSucursal;
	private String mensaje;
	private String nombreP;

	public ListarProductosControlador() {

	}

	public String getNombreP() {
		return nombreP;
	}

	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
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
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the productosSucursal
	 */
	public List<Producto> getProductosSucursal() {
		return productosSucursal;
	}

	/**
	 * @param productosSucursal
	 *            the productosSucursal to set
	 */
	public void setProductosSucursal(List<Producto> productosSucursal) {
		this.productosSucursal = productosSucursal;
	}

	public void limpiar(){
		this.productos= new ArrayList<Producto>();
	}
	public void buscarPorNombre() {

		try {
			ProductoDAO dao = new ProductoDAO();
			this.setProductos(dao.buscarProductos(this.nombreP));
			this.setMensaje("");

		} catch (Exception e) {
			this.setMensaje("Ocurrio un error al obtener los productos.");
			this.setProductos(new ArrayList<Producto>());
			LOGGER.error("Error al obtener los productos", e);
		}

	}

	public void obtenerProductos() {

		try {
			ProductoDAO dao = new ProductoDAO();
			this.setProductos(dao.obtenerProductos());
			this.setMensaje("");

		} catch (Exception e) {
			this.setMensaje("Ocurrio un error al obtener los productos.");
			this.setProductos(new ArrayList<Producto>());
			LOGGER.error("Error al obtener los productos", e);
		}

	}

	public void obtenerProductosSucursal() {

		try {
			Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("usuario");
			ProductoDAO dao = new ProductoDAO();
			this.setProductosSucursal(dao.obtenerProductosSucursal(user.getIdSucursal()));

			this.setMensaje("");

		} catch (Exception e) {
			this.setMensaje("Ocurrio un error al obtener los productos.");
			this.setProductosSucursal(new ArrayList<Producto>());
			LOGGER.error("Error al obtener los productos por sucursal", e);
		}

	}

	public void ordenarPorIdProducto() {

		Collections.sort(this.productos, new Comparator<Producto>() {

			public int compare(Producto p1, Producto p2) {
				if (p1.getIdProducto() > p2.getIdProducto())
					return 1;
				if (p1.getIdProducto() < p2.getIdProducto())
					return -1;
				return 0;
			}

		});
	}

	public void ordenarPorNombre() {
		Collections.sort(this.productos, new Comparator<Producto>() {

			public int compare(Producto p1, Producto p2) {
				return p1.getNombre().toLowerCase().compareTo(p2.getNombre().toLowerCase());
			}

		});
	}

	public void ordenarPorCategoria() {
		Collections.sort(this.productos, new Comparator<Producto>() {

			public int compare(Producto p1, Producto p2) {
				return p1.getCategoria().toLowerCase().compareTo(p2.getCategoria().toLowerCase());
			}

		});
	}

	public void ordenarPorMarca() {
		Collections.sort(this.productos, new Comparator<Producto>() {

			public int compare(Producto p1, Producto p2) {
				return p1.getMarca().toLowerCase().compareTo(p2.getMarca().toLowerCase());
			}

		});
	}

	public void ordenarPorPrecio() {
		Collections.sort(this.productos, new Comparator<Producto>() {

			public int compare(Producto p1, Producto p2) {
				if (p1.getPrecio() > p2.getPrecio())
					return 1;
				if (p1.getPrecio() < p2.getPrecio())
					return -1;
				return 0;
			}

		});
	}

	public void ordenarPorStock() {
		Collections.sort(this.productos, new Comparator<Producto>() {

			public int compare(Producto p1, Producto p2) {
				if (p1.getStock() > p2.getStock())
					return 1;
				if (p1.getStock() < p2.getStock())
					return -1;
				return 0;
			}

		});

	}

	public void ordenarPorSucursal() {
		Collections.sort(this.productos, new Comparator<Producto>() {

			public int compare(Producto p1, Producto p2) {
				if (p1.getSucursal_idSucursal() > p2.getSucursal_idSucursal())
					return 1;
				if (p1.getSucursal_idSucursal() < p2.getSucursal_idSucursal())
					return -1;
				return 0;
			}

		});

	}

	public String volver() {
		return "principal.xhtml";
	}

}

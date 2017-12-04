package cl.accenture.curso_java.sistema_ventas.controlador;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import cl.accenture.curso_java.sistema_ventas.dao.DetalleDAO;
import cl.accenture.curso_java.sistema_ventas.dao.ProductoDAO;
import cl.accenture.curso_java.sistema_ventas.dao.TransaccionDAO;
import cl.accenture.curso_java.sistema_ventas.excepciones.SinConexionException;
import cl.accenture.curso_java.sistema_ventas.modelo.DetalleTransaccion;
import cl.accenture.curso_java.sistema_ventas.modelo.Producto;
import cl.accenture.curso_java.sistema_ventas.modelo.Transaccion;
import cl.accenture.curso_java.sistema_ventas.modelo.Unidades;
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
	private List<Producto> carroDeCompra;
	private String mensaje;
	private String nombreP;
	private String marcaP;
	private int precioP;
	private int subtotal;
	private List<DetalleTransaccion> detalle;
	private List<Unidades> unidad;
	private int preciomin;
	private int preciomax;

	/**
	 * 
	 */

	public ListarProductosControlador() {
		this.carroDeCompra = new ArrayList<Producto>();
		this.detalle = new ArrayList<DetalleTransaccion>();
		this.unidad = new ArrayList<Unidades>();
	}
	
	

	/**
	 * @return the preciomin
	 */
	public int getPreciomin() {
		return preciomin;
	}



	/**
	 * @param preciomin the preciomin to set
	 */
	public void setPreciomin(int preciomin) {
		this.preciomin = preciomin;
	}



	/**
	 * @return the preciomax
	 */
	public int getPreciomax() {
		return preciomax;
	}



	/**
	 * @param preciomax the preciomax to set
	 */
	public void setPreciomax(int preciomax) {
		this.preciomax = preciomax;
	}



	/**
	 * @return the unidad
	 */
	public List<Unidades> getUnidad() {
		return unidad;
	}

	/**
	 * @param unidad
	 *            the unidad to set
	 */
	public void setUnidad(List<Unidades> unidad) {
		this.unidad = unidad;
	}

	/**
	 * @return the detalle
	 */
	public List<DetalleTransaccion> getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle
	 *            the detalle to set
	 */
	public void setDetalle(List<DetalleTransaccion> detalle) {
		this.detalle = detalle;
	}

	public List<Producto> getCarroDeCompra() {
		return carroDeCompra;
	}

	public void setCarroDeCompra(List<Producto> carroDeCompra) {
		this.carroDeCompra = carroDeCompra;
	}

	public String getNombreP() {
		return nombreP;
	}

	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}

	public String getMarcaP() {
		return marcaP;
	}

	public void setMarcaP(String marcaP) {
		this.marcaP = marcaP;
	}

	public int getPrecioP() {
		return precioP;
	}

	public void setPrecioP(int precioP) {
		this.precioP = precioP;
	}

	/**
	 * @return the subtotal
	 */
	public int getSubtotal() {
		return subtotal;
	}

	/**
	 * @param subtotal
	 *            the subtotal to set
	 */
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
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

	/**
	 * @return the unidades
	 */

	public void limpiar() {
		this.productos = new ArrayList<Producto>();
	}

	public void buscarPorNombre() {

		try {
			ProductoDAO dao = new ProductoDAO();
			this.setProductos(dao.buscarProductosNombre(this.nombreP));
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

	public void agregarProducto(Producto producto) {
		this.carroDeCompra.add(producto);
	}

	public void eliminarProducto(Producto producto) {
		this.carroDeCompra.remove(producto);
	}

	public String volver() {
		return "principal.xhtml";
	}

	public void addUni(int id) {
		Producto remove = new Producto();
		
		for (Producto producto2 : carroDeCompra) {

			if (producto2.getIdProducto() == id) {
				int precio = precioP;
				int subtotal2 = producto2.getPrecio() * precio;
				this.detalle.add(new DetalleTransaccion(id, precio, subtotal2, producto2));

				this.unidad.add(new Unidades(producto2, precio));

				this.subtotal += subtotal2;

				precio = 0;
			
				remove = producto2;
				
			}
			
			
		}
	
		

	}

	public void confirmar(){
		Transaccion transaccion = new Transaccion( this.subtotal, new Date() , this.detalle);
		Transaccion t = new Transaccion();
		
		try {
		
		
		TransaccionDAO dao = new TransaccionDAO();
		
		dao.guardarTransaccion(transaccion);
		
		t = dao.ultimaTransaccion();
		
		
		
		for (DetalleTransaccion det : this.detalle) {
			
			DetalleDAO ddao = new DetalleDAO();
			
			ddao.guardarDetalle(det, t);
			
			
			
		}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	}
	
	public void limpiarCarro(){
		
		this.unidad = new ArrayList<Unidades>();

		
	}
	
	public void buscarPrecio(){
		
		ProductoDAO dao = new ProductoDAO();
		
		try {
			this.setProductos(dao.buscarPrecio(preciomin, preciomax));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

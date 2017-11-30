/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.controlador;

import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import cl.accenture.curso_java.sistema_ventas.dao.ProductoDAO;
import cl.accenture.curso_java.sistema_ventas.excepciones.SinConexionException;
import cl.accenture.curso_java.sistema_ventas.modelo.Producto;
import cl.accenture.curso_java.sistema_ventas.modelo.Usuario;

/**
 * @author Martin Cuevas
 *
 */
@ManagedBean
@RequestScoped
public class ModificarProductoCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5376057639440208911L;
	private static final Logger LOGGER = Logger.getLogger(ModificarProductoCtrl.class);
	private String mensaje;
	private Producto producto;
	/**
	 * 
	 */
	public ModificarProductoCtrl() {
		this.mensaje = "";
		this.producto = new Producto();
	}
	/**
	 * @param mensaje
	 * @param producto
	 */
	public ModificarProductoCtrl(String mensaje, Producto producto) {
		this.mensaje = mensaje;
		this.producto = producto;
	}
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
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
	
	public void buscarPorNombre() {

		try {
			ProductoDAO dao = new ProductoDAO();
			Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("usuario");
			this.setProducto(dao.buscarProducto(user.getIdSucursal(), this.producto.getNombre()));
			this.setMensaje("Producto Encontrado");

		} catch (Exception e) {
			this.setMensaje("Ocurrio un error al obtener los productos.");
			
			LOGGER.error("Error al obtener los productos", e);
		}

	}
	
	public void modificarProducto() {
		ProductoDAO dao = new ProductoDAO();
		try {
			dao.modificarPrecio(this.producto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

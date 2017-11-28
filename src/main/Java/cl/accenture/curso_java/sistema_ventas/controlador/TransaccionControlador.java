
package cl.accenture.curso_java.sistema_ventas.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import cl.accenture.curso_java.sistema_ventas.dao.ProductoDAO;
import cl.accenture.curso_java.sistema_ventas.dao.TransaccionDAO;
import cl.accenture.curso_java.sistema_ventas.modelo.DetalleTransaccion;
import cl.accenture.curso_java.sistema_ventas.modelo.Producto;
import cl.accenture.curso_java.sistema_ventas.modelo.Transaccion;
import cl.accenture.curso_java.sistema_ventas.modelo.Usuario;

/**
 * @author Mauricio
 *
 */

@ManagedBean
@SessionScoped

public class TransaccionControlador implements Serializable{

	private static final long serialVersionUID = 8473957408103867560L;
	private static final Logger LOGGER = Logger.getLogger(TransaccionControlador.class);
	private List<Producto> productos;
	private List<DetalleTransaccion> detalles;
	private List<Transaccion> transacciones;
	private String mensaje;
	
	
	public TransaccionControlador() {
	}


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}


	public List<DetalleTransaccion> getDetalles() {
		return detalles;
	}


	public void setDetalles(List<DetalleTransaccion> detalles) {
		this.detalles = detalles;
	}


	public List<Transaccion> getTransacciones() {
		return transacciones;
	}


	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
	public void nuevaTransaccion(){
		
			
		
	}
	public void confirmarTransaccion(){
		
		try {
			TransaccionDAO dao = new TransaccionDAO();
			this.setTransacciones(dao.getTransacciones());
			this.setMensaje("");

		} catch (Exception e) {
			this.setMensaje("Ocurrio un error al guardar la transaccion.");
			this.setTransacciones(new ArrayList<Transaccion>());
			LOGGER.error("Error al confirmar la transaccion", e);
		}
	}
}

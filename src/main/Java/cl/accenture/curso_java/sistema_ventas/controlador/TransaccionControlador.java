
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
	private Producto producto;
	private DetalleTransaccion detalle;
	private Transaccion transaccion;
	private String mensaje;
	
	
	public TransaccionControlador() {
	
		this.producto = new Producto();
		this.detalle = new DetalleTransaccion();
		this.transaccion = new Transaccion();
	
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public DetalleTransaccion getDetalle() {
		return detalle;
	}

	public void setDetalle(DetalleTransaccion detalle) {
		this.detalle = detalle;
	}

	public Transaccion getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
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
			dao.guardarTransaccion(transaccion);
		} catch (Exception e) {
			this.setMensaje("Ocurrio un error al guardar la transaccion.");
			
			LOGGER.error("Error al confirmar la transaccion", e);
		}
	}
}

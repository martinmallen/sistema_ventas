/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.controlador;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import cl.accenture.curso_java.sistema_ventas.dao.DetalleDAO;
import cl.accenture.curso_java.sistema_ventas.dao.TransaccionDAO;
import cl.accenture.curso_java.sistema_ventas.excepciones.SinConexionException;
import cl.accenture.curso_java.sistema_ventas.modelo.DetalleTransaccion;
import cl.accenture.curso_java.sistema_ventas.modelo.Producto;
import cl.accenture.curso_java.sistema_ventas.modelo.Transaccion;

/**
 * @author Usuario
 *
 */
@ManagedBean
@RequestScoped
public class ReporteControlador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -947383428088157806L;
	private Date fecha1;
	private Date fecha2;
	private List<Transaccion> transacciones;
	private List<Producto> productos;
	private int total;
	private List<DetalleTransaccion> detalle;
	/**
	 * all attributes null
	 */
	public ReporteControlador() {
	}
	/**
	 * @param fecha1
	 * @param fecha2
	 * @param transacciones
	 * @param productos
	 * @param total
	 * @param detalle
	 */
	public ReporteControlador(Date fecha1, Date fecha2, List<Transaccion> transacciones, List<Producto> productos, int total, List<DetalleTransaccion> detalle) {
		this.fecha1 = fecha1;
		this.fecha2 = fecha2;
		this.transacciones = transacciones;
		this.productos = productos;
		this.total = total;
		this.detalle = detalle;
	}
	/**
	 * @return the fecha1
	 */
	public Date getFecha1() {
		return fecha1;
	}
	/**
	 * @param fecha1 the fecha1 to set
	 */
	public void setFecha1(Date fecha1) {
		this.fecha1 = fecha1;
	}
	/**
	 * @return the fecha2
	 */
	public Date getFecha2() {
		return fecha2;
	}
	/**
	 * @param fecha2 the fecha2 to set
	 */
	public void setFecha2(Date fecha2) {
		this.fecha2 = fecha2;
	}
	/**
	 * @return the transacciones
	 */
	public List<Transaccion> getTransacciones() {
		return transacciones;
	}
	/**
	 * @param transacciones the transacciones to set
	 */
	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}
	/**
	 * @return the productos
	 */
	public List<Producto> getProductos() {
		return productos;
	}
	/**
	 * @param productos the productos to set
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
	
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	/**
	 * @return the detalle
	 */
	public List<DetalleTransaccion> getDetalle() {
		return detalle;
	}
	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(List<DetalleTransaccion> detalle) {
		this.detalle = detalle;
	}
	public void reporteGanancia(){
		
		int suma = 0;
		try {
			this.transacciones = new TransaccionDAO().obtenerTransaccionesFecha(this.fecha1, this.fecha2);
			
			for (Transaccion transaccion : this.transacciones) {
				
				suma += transaccion.getValor();
				
			}
		 
		this.total = suma;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void reporteProductos(){
		
		List<DetalleTransaccion> det = new ArrayList<DetalleTransaccion>();
		
		try {
			
			this.transacciones = new TransaccionDAO().obtenerTransaccionesFecha(this.fecha1, this.fecha2);
			
			for (Transaccion transaccion : this.transacciones) {
				
				det = new DetalleDAO().obtenerDetalle(transaccion);
				
				for (DetalleTransaccion detalleTransaccion : det) {
					
					this.detalle.add(detalleTransaccion);
				}
				
			}
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}

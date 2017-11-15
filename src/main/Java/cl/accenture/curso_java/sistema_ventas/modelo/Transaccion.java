/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.modelo;

import java.util.Date;
import java.util.List;

/**
 * @author Usuario
 *
 */
public class Transaccion {

	private int idTransaccion;
	private int valor;
	private Date fecha;
	private List<DetalleTransaccion> detalle;
	/**
	 * 
	 */
	public Transaccion() {
	}
	/**
	 * @param idTransaccion
	 * @param valor
	 * @param fecha
	 * @param detalle
	 */
	public Transaccion(int idTransaccion, int valor, Date fecha, List<DetalleTransaccion> detalle) {
		this.idTransaccion = idTransaccion;
		this.valor = valor;
		this.fecha = fecha;
		this.detalle = detalle;
	}
	/**
	 * @return the idTransaccion
	 */
	public int getIdTransaccion() {
		return idTransaccion;
	}
	/**
	 * @param idTransaccion the idTransaccion to set
	 */
	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	/**
	 * @return the valor
	 */
	public int getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Transaccion){
			Transaccion transaccion = (Transaccion)obj;
			return transaccion.getIdTransaccion() == this.idTransaccion;
		}
		return false;
	}
}

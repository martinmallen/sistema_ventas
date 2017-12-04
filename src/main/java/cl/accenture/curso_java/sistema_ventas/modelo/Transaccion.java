/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.modelo;

import java.util.Date;
import java.util.List;

/**
 * @author Mauricio
 *
 */
public class Transaccion {

	private int idTransaccion;
	private int valor;
	private Date fecha;
	private List<DetalleTransaccion> detalle;
	private int Sucursal_idSucursal;
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
	public Transaccion( int valor, Date fecha, List<DetalleTransaccion> detalle) {
		
		this.valor = valor;
		this.fecha = fecha;
		this.detalle = detalle;
	}
	public Transaccion(int int1, int int2, java.sql.Date date) {
		// TODO Auto-generated constructor stub
		this.idTransaccion = int1;
		this.valor = int2;
		this.fecha = date;
		
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
	public int getSucursal_idSucursal() {
		return Sucursal_idSucursal;
	}
	public void setSucursal_idSucursal(int sucursal_idSucursal) {
		Sucursal_idSucursal = sucursal_idSucursal;
	}
}

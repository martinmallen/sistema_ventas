/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.modelo;

import java.util.List;

/**
 * @author Juan Mendoza
 *
 */
public class Sucursal {

	private int idSucursal;
	private String nombre;
	private String direccion;
	private List<Usuario> usuarios;
	
	
	
	/**
	 * 
	 */
	public Sucursal() {
	}

	

	/**
	 * @param idSucursal
	 * @param nombre
	 * @param direccion
	 * @param usuarios
	 */
	public Sucursal(int idSucursal, String nombre, String direccion, List<Usuario> usuarios) {
		this.idSucursal = idSucursal;
		this.nombre = nombre;
		this.direccion = direccion;
		this.usuarios = usuarios;
	}

	

	/**
	 * @return the idSucursal
	 */
	public int getIdSucursal() {
		return idSucursal;
	}



	/**
	 * @param idSucursal the idSucursal to set
	 */
	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}



	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}



	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}



	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	/**
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}



	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}



	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Sucursal){
			Sucursal sucursal = (Sucursal)obj;
			return sucursal.getIdSucursal() == this.idSucursal;
		}
		return false;
	}
	
}

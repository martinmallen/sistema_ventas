/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Juan Mendoza
 *
 */
public class Perfil {
	
	private String nombre;
	private List<Permiso> permisos;

	/**
	 * 
	 */
	public Perfil() {
	}

	/**
	 * @param nombre
	 */
	public Perfil(String nombre) {
		this.nombre = nombre;
		this.permisos = new ArrayList<Permiso>();
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
	 * @return the permisos
	 */
	public List<Permiso> getPermisos() {
		return permisos;
	}

	/**
	 * @param permisos the permisos to set
	 */
	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Perfil){
			Perfil perfil = (Perfil)obj;
			return perfil.getNombre().equals(this.nombre);
			
		}
		return false;
	}

}

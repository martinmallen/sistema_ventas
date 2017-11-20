/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



/**
 * @author Usuario
 *
 */
@ManagedBean
@SessionScoped
public final class BlockearUsuarioControlador {
	
	private String rut;

	/**
	 * 
	 */
	public BlockearUsuarioControlador() {
	}

	/**
	 * @param rut
	 */
	public BlockearUsuarioControlador(String rut) {
		this.rut = rut;
	}

	/**
	 * @return the rut
	 */
	public String getRut() {
		return rut;
	}

	/**
	 * @param rut the rut to set
	 */
	public void setRut(String rut) {
		this.rut = rut;
	}

	public void blockear(){
		
		
		
		
	}
	
	public String link (){
		return "Blockeado.xhtml";
	}
}

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
public class BlockearSucursalControlador {
	
	private int id;

	/**
	 * 
	 */
	public BlockearSucursalControlador() {
	}

	/**
	 * @param id
	 */
	public BlockearSucursalControlador(int id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	public String link (){
		return "Blockeado.xhtml";
	}

}

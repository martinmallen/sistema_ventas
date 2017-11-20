/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.controlador;

import javax.faces.bean.ManagedBean;

/**
 * @author Usuario
 *
 */
@ManagedBean
public class BlockearProductoControlador {

	private int id;

	/**
	 * 
	 */
	public BlockearProductoControlador() {
	}

	/**
	 * @param id
	 */
	public BlockearProductoControlador(int id) {
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
	
	public String link(){
		return "Blockeado.xhtml";
	}
}

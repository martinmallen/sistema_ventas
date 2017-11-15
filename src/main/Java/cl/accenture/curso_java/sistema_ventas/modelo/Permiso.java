/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.modelo;

/**
 * @author Usuario
 *
 */
public class Permiso {
	
	private int idPermiso;
	private String tipo;
	/**
	 * 
	 */
	public Permiso() {
	}
	/**
	 * @param idPermiso
	 * @param tipo
	 */
	public Permiso(int idPermiso, String tipo) {
		this.idPermiso = idPermiso;
		this.tipo = tipo;
	}
	/**
	 * @return the idPermiso
	 */
	public int getIdPermiso() {
		return idPermiso;
	}
	/**
	 * @param idPermiso the idPermiso to set
	 */
	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Permiso) {
			Permiso permiso = (Permiso)obj;
			return permiso.getIdPermiso()== this.idPermiso;
			
		}
		return false;
	}
}

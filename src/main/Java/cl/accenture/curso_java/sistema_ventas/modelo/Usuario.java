/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.modelo;

import java.util.Date;

/**
 * @author Juan Mendoza
 *
 */
public class Usuario {
	
	private String rut;
	private String nombre;
	private String apellido;
	private String password;
	private String email;
	private Perfil perfil;
	private boolean estado;
	private int idSucursal;
	/**
	 * 
	 */
	public Usuario() {
	}
	/**
	 * @param rut
	 * @param nombre
	 * @param password
	 * @param email
	 * @param perfil
	 */
	public Usuario(String rut, String nombre, String password, String email, Perfil perfil, String apellido, boolean estado, int idsucursal) {
		this.rut = rut;
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.perfil = perfil;
		this.apellido = apellido;
		this.estado = true;
		this.idSucursal = idsucursal;
	}

	public Usuario(String rut2, String nombre2, String password2, String email2, Perfil perfil2, String apellido2,
			int idSucursal2) {
		this.rut = rut2;
		this.nombre = nombre2;
		this.password = password2;
		this.email = email2;
		this.perfil = perfil2;
		this.apellido = apellido2;
		this.idSucursal = idSucursal2;
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
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the perfil
	 */
	public Perfil getPerfil() {
		return perfil;
	}
	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Usuario){
			Usuario usuario = (Usuario)obj;
			return usuario.getRut().equals(this.rut);
		}
		return super.equals(obj);
	}

}

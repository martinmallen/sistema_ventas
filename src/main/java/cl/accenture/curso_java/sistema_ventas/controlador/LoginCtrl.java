/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.controlador;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cl.accenture.curso_java.sistema_ventas.dao.UsuarioDAO;
import cl.accenture.curso_java.sistema_ventas.modelo.Permiso;
import cl.accenture.curso_java.sistema_ventas.modelo.Usuario;
import cl.accenture.curso_java.sistema_ventas.servicios.SHAServices;

/**
 * @author Martin Cuevas
 *
 */
@ManagedBean
@SessionScoped
public class LoginCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8167310269289072882L;
	private String password;
	private String rut;
	private boolean estado;
	private String mensaje;
	private Usuario usuario;
	

	/**
	 * 
	 */
	public LoginCtrl() {
		this.password = "";
		this.rut = "";
		this.estado = true;
		this.mensaje = "";
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}




	/**
	 * @return the rut
	 */
	public String getRut() {
		return rut;
	}

	/**
	 * @param rut
	 *            the rut to set
	 */
	public void setRut(String rut) {
		this.rut = rut;
	}

	/**
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public String ingresar() {
		try {
			String encriptado =SHAServices.encriptacion(password);
			Usuario user = new Usuario(this.rut, encriptado);
			UsuarioDAO dao = new UsuarioDAO();
			if(dao.ingresar(user)){
//				dao.datosUsuario(user);
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", user);
				this.usuario = user;
				return "principal.xhtml";
			}
			else {
				this.mensaje = "ACCESO DENEGADO, rut o password Incorrectos.";
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.mensaje = "Ocurrio un error desconocido";
			return "";
		}
	}
	
	
	public boolean tienePermiso( String tipo ) {
		return this.usuario.getPerfil().getPermisos().contains( new Permiso( tipo ) );
	}

	public String cerrarSesion() {
		this.setRut("");
		this.setMensaje("");
		this.usuario.setRut("");
		this.usuario.setPassword("");
		return "login_.xhtml";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}

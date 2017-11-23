/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.controlador;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import cl.accenture.curso_java.sistema_ventas.dao.SucursalDAO;
import cl.accenture.curso_java.sistema_ventas.excepciones.SinConexionException;
import cl.accenture.curso_java.sistema_ventas.modelo.Usuario;

/**
 * @author Martin Cuevas
 *
 */
@ManagedBean
@RequestScoped
public class ListaUsuariosCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6148243717367529921L;

	private List<Usuario> usuarios;
	private String mensaje;
	/**
	 * 
	 */
	public ListaUsuariosCtrl() {
		this.usuarios = new ArrayList<Usuario>();
		
	}
	/**
	 * @param usuarios
	 * @param mensaje
	 */
	public ListaUsuariosCtrl(List<Usuario> usuarios, String mensaje) {
		this.usuarios = usuarios;
		this.mensaje = mensaje;
	}
	/**
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	/**
	 * @param sucursales the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public void obtenerUsuarios() {
		
		SucursalDAO dao = new SucursalDAO();
		Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuario");
		try {
			this.setUsuarios(dao.buscarUsuarioSucursal(user.getIdSucursal()));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.mensaje = "Error al obtener Sucursales";
		
	}
}

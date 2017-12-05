/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.controlador;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import cl.accenture.curso_java.sistema_ventas.dao.SucursalDAO;
import cl.accenture.curso_java.sistema_ventas.dao.UsuarioDAO;
import cl.accenture.curso_java.sistema_ventas.excepciones.SinConexionException;
import cl.accenture.curso_java.sistema_ventas.modelo.Perfil;
import cl.accenture.curso_java.sistema_ventas.modelo.Sucursal;
import cl.accenture.curso_java.sistema_ventas.modelo.Usuario;
import cl.accenture.curso_java.sistema_ventas.servicios.SHAServices;

/**
 * @author Martin Cuevas
 *
 */
@ManagedBean
@RequestScoped
public class CrearUsuarioCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2570733654212148470L;
	private String nombre;
	private String apellido;
	private String password;
	private String email;
	private String rut;
	private boolean estado;
	private String perfil_nombre;
	private int idSucursal;
	private String mensaje;
	private List<Sucursal> sucursales;
	private String confMail;
	private String confPass;

	/**
	 * 
	 */
	public CrearUsuarioCtrl() {
		this.nombre = "";
		this.apellido = "";
		this.password = "";
		this.email = "";
		this.rut = "";
		this.estado = true;
		this.perfil_nombre = "";
		this.idSucursal = 0;
		this.mensaje = "";
		obtenerSucursales();
	}

	/**
	 * @param nombre
	 * @param apellido
	 * @param password
	 * @param email
	 * @param rut
	 * @param estado
	 * @param perfil_nombre
	 * @param idSucursal
	 * @param mensaje
	 */
	public CrearUsuarioCtrl(String nombre, String apellido, String password, String email, String rut, boolean estado,
			String perfil_nombre, int idSucursal, String mensaje) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.email = email;
		this.rut = rut;
		this.estado = estado;
		this.perfil_nombre = perfil_nombre;
		this.idSucursal = idSucursal;
		this.mensaje = mensaje;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
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
	 * @param apellido
	 *            the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the perfil_nombre
	 */
	public String getPerfil_nombre() {
		return perfil_nombre;
	}

	/**
	 * @param perfil_nombre
	 *            the perfil_nombre to set
	 */
	public void setPerfil_nombre(String perfil_nombre) {
		this.perfil_nombre = perfil_nombre;
	}

	/**
	 * @return the idSucursal
	 */
	public int getIdSucursal() {
		return idSucursal;
	}

	/**
	 * @param idSucursal
	 *            the idSucursal to set
	 */
	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
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

	/**
	 * @return the sucursales
	 */
	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	/**
	 * @param sucursales
	 *            the sucursales to set
	 */
	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

	/**
	 * @return the confMail
	 */
	public String getConfMail() {
		return confMail;
	}

	/**
	 * @param confMail
	 *            the confMail to set
	 */
	public void setConfMail(String confMail) {
		this.confMail = confMail;
	}

	/**
	 * @return the confPass
	 */
	public String getConfPass() {
		return confPass;
	}

	/**
	 * @param confPass
	 *            the confPass to set
	 */
	public void setConfPass(String confPass) {
		this.confPass = confPass;
	}

	public void guardarUsuario() {
		if ((this.password.equals(this.confPass) && this.email.equals(this.confMail))) {
			String encriptado = "";
			try {
				encriptado = SHAServices.encriptacion(this.password);
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Usuario usuario = new Usuario(this.rut, this.nombre, encriptado, this.email, new Perfil(this.perfil_nombre),
					this.apellido, this.idSucursal);
			UsuarioDAO dao = new UsuarioDAO();

			try {
				dao.ingresarUsuario(usuario);
				limpiar();
				this.mensaje = "Usuario Creado Correctamente";
			} catch (SQLException e) {
				this.mensaje = "Error en la busqueda";
				e.printStackTrace();
			} catch (SinConexionException e) {
				this.mensaje = "Error en la conexion";
				e.printStackTrace();
			}

		}else {
			this.email = "";
			this.confMail = "";
			this.mensaje = "Email o Password no Coinciden";
		}
	}

	public void obtenerSucursales() {

		SucursalDAO sdao = new SucursalDAO();
		try {
			this.setSucursales(sdao.obtenerSucursales());
			this.mensaje = "";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String cancelar() {
		limpiar();
		return "principal.xhtml";
	}

	public void limpiar() {
		this.nombre = "";
		this.apellido = "";
		this.password = "";
		this.email = "";
		this.rut = "";
		this.estado = true;
		this.perfil_nombre = "";
		this.idSucursal = 0;
		this.mensaje = "";
	}

}

/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.controlador;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cl.accenture.curso_java.sistema_ventas.dao.SucursalDAO;
import cl.accenture.curso_java.sistema_ventas.dao.UsuarioDAO;
import cl.accenture.curso_java.sistema_ventas.excepciones.SinConexionException;
import cl.accenture.curso_java.sistema_ventas.modelo.Conexion;
import cl.accenture.curso_java.sistema_ventas.modelo.Usuario;

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
	private String nombre;
	private String apellido;
	private String password;
	private String email;
	private String rut;
	private boolean estado;
	private String perfil_nombre;
	private int idSucursal;
	private String mensaje;
	private Conexion conexion;

	/**
	 * 
	 */
	public LoginCtrl() {
		this.nombre = "";
		this.apellido = "";
		this.password = "";
		this.email = "";
		this.rut = "";
		this.estado = true;
		this.perfil_nombre = "";
		this.idSucursal = 0;
		this.mensaje = "";
		this.conexion = new Conexion();
	}

	/**
	 * @param nombre
	 * @param apellido
	 * @param password
	 * @param email
	 * @param rut
	 * @param estado
	 * @param perfil_nombre
	 * @param sucursal_idSucursal
	 * @param conexion
	 */
	public LoginCtrl(String nombre, String apellido, String password, String email, String rut, boolean estado,
			String perfil_nombre, int sucursal_idSucursal, String mensaje, Conexion conexion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.email = email;
		this.rut = rut;
		this.estado = estado;
		this.perfil_nombre = perfil_nombre;
		this.idSucursal = sucursal_idSucursal;
		this.mensaje = mensaje;
		this.conexion = conexion;
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
	 * @return the sucursal_idSucursal
	 */
	public int getidSucursal() {
		return idSucursal;
	}

	/**
	 * @param sucursal_idSucursal
	 *            the sucursal_idSucursal to set
	 */
	public void setidSucursal(int sucursal_idSucursal) {
		idSucursal = sucursal_idSucursal;
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
	 * @return the conexion
	 */
	public Conexion getConexion() {
		return conexion;
	}

	/**
	 * @param conexion
	 *            the conexion to set
	 */
	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	public String ingresar() {
		try {
			PreparedStatement psSelect = conexion.obtenerConexion()
					.prepareStatement("SELECT * FROM usuario Where rut = ?;");
			psSelect.setString(1, this.rut);
			ResultSet rs = psSelect.executeQuery();
			while (rs.next()) {
				if (rs.getString("password").equals(this.password)) {
					this.nombre = rs.getString("nombre");
					this.apellido = rs.getString("apellido");
					this.email = rs.getString("email");
					this.perfil_nombre = rs.getString("perfil_nombre");
					this.idSucursal = rs.getInt("Sucursal_idSucursal");
					return "principal.xhtml";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.mensaje = "ACCESO DENEGADO, rut o password Incorrectos.";
		return mensaje;
	}

	public String cerrarSesion() {
		this.nombre = "";
		this.apellido = "";
		this.password = "";
		this.email = "";
		this.rut = "";
		this.estado = true;
		this.perfil_nombre = "";
		this.idSucursal = 0;
		this.mensaje = "";
		this.conexion = new Conexion();
		return "login_.xhtml";
	}

	public void guardarUsuario() {
		Usuario usuario = new Usuario(this.rut, this.nombre, this.password, this.email, this.perfil_nombre,
				this.apellido, this.idSucursal);
		UsuarioDAO dao = new UsuarioDAO();

		try {
			dao.ingresarUsuario(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

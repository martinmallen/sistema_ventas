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

import cl.accenture.curso_java.sistema_ventas.dao.SucursalDAO;
import cl.accenture.curso_java.sistema_ventas.excepciones.SinConexionException;
import cl.accenture.curso_java.sistema_ventas.modelo.Sucursal;
import cl.accenture.curso_java.sistema_ventas.modelo.Usuario;

/**
 * @author Martin Cuevas
 *
 */
@ManagedBean
@RequestScoped
public class CrearSucursalCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9002980450052951138L;
	private int idSucursal;
	private String nombre;
	private String direccion;
	private List<Usuario> usuarios;

	/**
	 * 
	 */
	public CrearSucursalCtrl() {
		this.idSucursal = 0;
		this.nombre = "";
		this.direccion = "";
		this.usuarios = new ArrayList<Usuario>();
	}

	/**
	 * @param idSucursal
	 * @param nombre
	 * @param direccion
	 * @param usuarios
	 */
	public CrearSucursalCtrl(int idSucursal, String nombre, String direccion, List<Usuario> usuarios) {
		this.idSucursal = idSucursal;
		this.nombre = nombre;
		this.direccion = direccion;
		this.usuarios = usuarios;
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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios
	 *            the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void guardar() {
		Sucursal sucursal = new Sucursal(this.idSucursal, this.nombre, this.direccion);
		SucursalDAO dao = new SucursalDAO();
		try {
			dao.insertarSucursal(sucursal);
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
		this.idSucursal = 0;
		this.nombre = "";
		this.direccion = "";
	}

}

/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.controlador;

import java.io.FileReader;
import java.io.Serializable;
import java.sql.PreparedStatement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import cl.accenture.curso_java.sistema_ventas.modelo.Conexion;

/**
 * @author Martin Cuevas
 *
 */
@ManagedBean
@RequestScoped
public class CargarProductosCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4303635517281305238L;
	private Conexion conexion;
	

	/**
	 * 
	 */
	public CargarProductosCtrl() {
		this.conexion = new Conexion();
	}

	/**
	 * @param conexion
	 * @param archivo
	 */
	public CargarProductosCtrl(Conexion conexion, FileReader archivo) {
		this.conexion = conexion;
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


	public void cargarArchivoProductos() {

		try {

			PreparedStatement psLoad = conexion.obtenerConexion().prepareStatement("LOAD DATA INFILE  INTO TABLE producto FIELDS TERMINATED BY ','"
					+ " LINES TERMINATED BY '\n' (idProducto, nombre, precio, marca, stock, categoria, minstock); ");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String cancelar() {
		return "principal.xhtml";
	}
}

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
	private FileReader archivo;

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
		this.archivo = archivo;
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

	/**
	 * @return the archivo
	 */
	public FileReader getArchivo() {
		return archivo;
	}

	/**
	 * @param archivo
	 *            the archivo to set
	 */
	public void setArchivo(FileReader archivo) {
		this.archivo = archivo;
	}

	public void readCsvUsingLoad() {

		try {

			PreparedStatement psLoad = conexion.obtenerConexion().prepareStatement("LOAD DATA LOCAL INFILE '" + archivo
					+ "' INTO TABLE producto FIELDS TERMINATED BY ','"
					+ " LINES TERMINATED BY '\n' (idProducto, nombre, precio, marca, stock, categoria, minstock); ");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String cancelar() {
		return "principal.xhtml";
	}
}

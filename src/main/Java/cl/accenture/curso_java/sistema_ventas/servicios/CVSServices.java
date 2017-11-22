/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.servicios;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cl.accenture.curso_java.sistema_ventas.modelo.Conexion;
import cl.accenture.curso_java.sistema_ventas.modelo.Producto;

/**
 * @author Martin Cuevas
 *
 */
public class CVSServices {
	private Conexion conexion;

	/**
	 * 
	 */
	public CVSServices() {
		this.conexion = new Conexion();
	}

	/**
	 * @param conexion
	 */
	public CVSServices(Conexion conexion) {
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

	/**
	 * 
	 * @param fileContent
	 * @throws IOException
	 */
	public static List<Producto> cargarArchivo(InputStream fileContent) throws IOException {
		List<Producto> productos = new ArrayList<Producto>();
		int cont = 0;
		int data = fileContent.read();
		StringBuilder linea = new StringBuilder();
		while (data != -1) {
			if (((char) data) != '\n') {
				linea.append((char) data);
			} else {
				if (cont != 0) {
					System.out.println(linea);
					Producto prod = stringToProducto(linea.toString());
					productos.add(prod);
					linea = new StringBuilder();
				} else {
					linea = new StringBuilder();
				}
				cont++;
			}

			data = fileContent.read();
		}
		return productos;
	}

	/**
	 * 
	 * @param linea
	 * @return
	 */
	public static Producto stringToProducto(String linea) {
		Producto prod = new Producto();
		String[] columnas = linea.split(";");
		prod.setIdProducto(Integer.parseInt(columnas[0]));
		prod.setNombre(columnas[1]);
		prod.setPrecio(Integer.parseInt(columnas[2]));
		prod.setMarca(columnas[3]);
		prod.setStock(Integer.parseInt(columnas[4]));
		prod.setCategoria(columnas[5]);
		prod.setMinstock(Integer.parseInt(columnas[6]));
		prod.setSucursal_idSucursal(Integer.parseInt(columnas[7].contains("\r") ? columnas[7].split("\r")[0] :  columnas[7] ));
		return prod;
	}

}

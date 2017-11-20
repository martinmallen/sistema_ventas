/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.servicios;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cl.accenture.curso_java.sistema_ventas.modelo.Producto;

/**
 * @author Martin Cuevas
 *
 */
public class CVSServices {

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
			if( ((char) data ) != '\n' ) {
				linea.append( (char) data );
			}
			else {
				if( cont != 0 ) {
					System.out.println(linea);
					Producto prod = stringToProducto(linea.toString());
					productos.add(prod);
					linea = new StringBuilder();
				}else{
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
	public static Producto stringToProducto( String linea ) {
		Producto prod = new Producto();
		String[] columnas = linea.split(";");
		prod.setIdProducto( Integer.parseInt( columnas[0] ) );
		return prod;
	}

}

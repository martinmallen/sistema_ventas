package cl.accenture.curso_java.sistema_ventas.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import cl.accenture.curso_java.sistema_ventas.dao.ProductoDAO;
import cl.accenture.curso_java.sistema_ventas.modelo.Producto;


/**
 * @author Mauricio
 *
 */

@ManagedBean
@RequestScoped

public class ListarProductosControlador implements Serializable{



		private static final long serialVersionUID = -4669809923772737328L;
		private static final Logger LOGGER = Logger.getLogger(ListarProductosControlador.class);
		private List<Producto> productos;
		private String mensaje;
		
		
		public ListarProductosControlador() {
			obtenerProductos();
			ordenarPorIdProducto();
			ordenarPorNombre();
			ordenarPorPrecio();
			ordenarPorStock();
			ordenarPorMarca();
			ordenarPorCategoria();
		}
		
		
		
		public void obtenerProductos(){
			try{
				ProductoDAO dao = new ProductoDAO();
				this.setProductos(dao.obtenerProductos());
				this.setMensaje("");
			}catch (Exception e) {
				this.setMensaje("Ocurrio un error al obtener los productos.");
				this.setProductos(new ArrayList<Producto>());
				LOGGER.error("Error al obtener los productos",e);
			}
			
		}
		public void ordenarPorIdProducto(){
			Collections.sort(this.getProductos(), new Comparator<Producto>(){
				
				public int compare(Producto p1, Producto p2) {
					if( p1.getIdProducto() > p2.getIdProducto() )
							return 1;
					if( p1.getIdProducto() < p2.getIdProducto() )	
						return -1;
					return 0;
				}
			
			});
		}
		public void ordenarPorNombre(){
			Collections.sort(this.getProductos(), new Comparator<Producto>(){
				
				public int compare(Producto p1, Producto p2) {
					return p1.getNombre().toLowerCase().compareTo(p2.getNombre().toLowerCase());
				}
			
			});
		}

		public void ordenarPorCategoria(){
			Collections.sort(this.getProductos(), new Comparator<Producto>(){
				
				public int compare(Producto p1, Producto p2) {
					return p1.getCategoria().toLowerCase().compareTo(p2.getCategoria().toLowerCase());
				}
			
			});
		}
		public void ordenarPorMarca(){
			Collections.sort(this.getProductos(), new Comparator<Producto>(){
				
				public int compare(Producto p1, Producto p2) {
					return p1.getMarca().toLowerCase().compareTo(p2.getMarca().toLowerCase());
				}
			
			});
		}
		public void ordenarPorPrecio(){
			Collections.sort(this.getProductos(), new Comparator<Producto>(){
				
				public int compare(Producto p1, Producto p2) {
					if( p1.getPrecio() > p2.getPrecio() )
							return 1;
					if( p1.getPrecio() < p2.getPrecio() )
						return -1;
					return 0;
				}
			
			});
		}
		public void ordenarPorStock(){
			Collections.sort(this.getProductos(), new Comparator<Producto>(){
				
				public int compare(Producto p1, Producto p2) {
					if( p1.getStock() > p2.getStock() )
							return 1;
					if( p1.getStock() < p2.getStock() )
						return -1;
					return 0;
				}
			
			});
		}


		public String getMensaje() {
			return mensaje;
		}


		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}


		public List<Producto> getProductos() {
			return productos;
		}


		public void setProductos(List<Producto> productos) {
			this.productos = productos;
		}
}

		
	

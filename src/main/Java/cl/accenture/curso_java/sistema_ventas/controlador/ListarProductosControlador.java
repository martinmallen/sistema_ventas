package cl.accenture.curso_java.sistema_ventas.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
		private List<Producto> productos;
		private int idSucursal;
		private String mensaje;
		
		public ListarProductosControlador() {
			
		}
		
		
		/**
		 * @return the idProducto
		 */
		


		public List<Producto> getProductos() {
			return productos;
		}


		public void setProductos(List<Producto> productos) {
			this.productos = productos;
		}
		
		
		/**
		 * @return the idSucursal
		 */
		public int getIdSucursal() {
			return idSucursal;
		}


		/**
		 * @param idSucursal the idSucursal to set
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
		 * @param mensaje the mensaje to set
		 */
		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}


		public void obtenerProductosSucursal(){
			try{
				ProductoDAO dao = new ProductoDAO();
				this.setProductos(dao.obtenerProductosSucursal(this.idSucursal));
				
				this.setMensaje("");
			}catch (Exception e) {
				this.setMensaje("Ocurrio un error al obtener los productos.");
						this.setProductos(new ArrayList<Producto>());
			}
		}


}

		
	

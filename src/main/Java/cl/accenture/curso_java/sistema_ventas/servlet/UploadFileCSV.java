package cl.accenture.curso_java.sistema_ventas.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import cl.accenture.curso_java.sistema_ventas.dao.ProductoDAO;
import cl.accenture.curso_java.sistema_ventas.excepciones.SinConexionException;
import cl.accenture.curso_java.sistema_ventas.servicios.CVSServices;

/**
 * Servlet implementation class UploadFileCSV
 */
public class UploadFileCSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileCSV() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 try {
		        List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		        for (FileItem item : items) {
		            if (item.isFormField()) {
		                String fieldName = item.getFieldName();
		                String fieldValue = item.getString();
		                
		                System.out.println( fieldName );
		                System.out.println( fieldValue );
		            } else {
		                // Process form file field (input type="file").
		                String fieldName = item.getFieldName();
		                String fileName = FilenameUtils.getName(item.getName());
		                InputStream fileContent = item.getInputStream();
		                
		                
		                ProductoDAO dao = new ProductoDAO();
		    		 	dao.guardarProductos(CVSServices.cargarArchivo(fileContent));
		                
		                
		                System.out.println( fieldName );
		                System.out.println( fileName );
		            }
		        }
		        response.sendRedirect("../cargarProductos.xhtml");

		    } catch (FileUploadException e) {
		        throw new ServletException("Cannot parse multipart request.", e);
		    } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SinConexionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	
	}

}

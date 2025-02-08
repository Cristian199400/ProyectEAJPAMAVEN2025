package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImp.ClassProductoImp;
import model.TblProducto;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        super();
        // TODO Auto-generated constructor stub
    }// Fin del controlador producto

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//instanciamos la respectiva clase...
		ClassProductoImp crudimp=new ClassProductoImp();
		//recuperamos el listado de producto de la BD...
		List<TblProducto> listadoproductos=crudimp.ListadoProductos();
		//enviamos hacia la vista...
		//almacenamos en el respectivo metodo 
		request.setAttribute("listado",listadoproductos);
		request.getRequestDispatcher("/MenuPrincipal.jsp").forward(request,response);
	}// Fin del metodo doget

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}// Fin del metodo dopost

}// Fin del controlador


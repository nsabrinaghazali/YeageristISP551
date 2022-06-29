package admin.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.dao.adminDAO;

@WebServlet("/ViewAdminController")
public class ViewAdminController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private adminDAO dao;
	
	public ViewAdminController()
	{
		super();
		dao = new adminDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("a", adminDAO.getAdminById(id));
		RequestDispatcher view = request.getRequestDispatcher("viewAdmin.jsp");
		view.forward(request, response);
	}
}

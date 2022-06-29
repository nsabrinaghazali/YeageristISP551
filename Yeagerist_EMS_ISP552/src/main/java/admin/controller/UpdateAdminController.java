package admin.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.dao.adminDAO;
import admin.model.Admin;

@WebServlet("/UpdateAdminController")
public class UpdateAdminController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private adminDAO dao;
	public UpdateAdminController() {
		super();
		// TODO Auto-generated constructor stub
		dao= new adminDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("a", adminDAO.getAdminById(id));
		RequestDispatcher view = request.getRequestDispatcher("viewAdmin.jsp");
		view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Admin a = new Admin();
		a.setStaffName(request.getParameter("name"));
		a.setStaffPassword(request.getParameter("password"));
		
		dao.updateAdmin(a);
		
		request.setAttribute("admins", adminDAO.getAllAdmin());
		RequestDispatcher view = request.getRequestDispatcher("listAdmin.jsp");
		view.forward(request, response);
	}
}

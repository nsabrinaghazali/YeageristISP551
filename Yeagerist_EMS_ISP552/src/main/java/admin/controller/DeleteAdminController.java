package admin.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.dao.adminDAO;

@WebServlet("/DeleteAdminController")
public class DeleteAdminController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private adminDAO dao;
	public DeleteAdminController() {
		super();
		// TODO Auto-generated constructor stub
		dao = new adminDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteAdmin(id);
		request.setAttribute("admins", adminDAO.getAllAdmin());
		RequestDispatcher view = request.getRequestDispatcher("listAdmin.jsp");
		view.forward(request, response);
	}

}

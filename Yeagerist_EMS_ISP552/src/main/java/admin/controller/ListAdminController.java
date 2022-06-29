package admin.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.dao.adminDAO;

@WebServlet("/ListAdminController")
public class ListAdminController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private adminDAO dao;
	public ListAdminController() {
		super();
		// TODO Auto-generated constructor stub
		dao = new adminDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("admins", adminDAO.getAllAdmin());
		RequestDispatcher view = request.getRequestDispatcher("listAdmin.jsp");
		view.forward(request, response);
	}

}

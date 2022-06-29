package user.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.dao.userDAO;

@WebServlet("/ListUserController")
public class ListUserController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private userDAO dao;
	
	public ListUserController() {
		super();
		// TODO Auto-generated constructor stub
		dao = new userDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("users", userDAO.getAllUser());
		RequestDispatcher view = request.getRequestDispatcher("listUser.jsp");
		view.forward(request, response);
	}
	
	
}

package user.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.dao.userDAO;

@WebServlet("/ViewUserController")
public class ViewUserController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private userDAO dao;
	public ViewUserController() {
		super();
		// TODO Auto-generated constructor stub
		dao= new userDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("u", userDAO.getUserById(id));
		RequestDispatcher view = request.getRequestDispatcher("viewEvent.jsp");
		view.forward(request, response);
	}
	
}

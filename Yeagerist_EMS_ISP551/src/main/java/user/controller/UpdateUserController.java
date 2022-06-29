package user.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.dao.userDAO;
import user.model.User;

@WebServlet("/UpdateUserController")
public class UpdateUserController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private userDAO dao;
	public UpdateUserController() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		User u = new User();
		u.setUserName(request.getParameter("name"));
		u.setUserPassword(request.getParameter("password"));
		u.setUserEmail(request.getParameter("email"));
		dao.updateUser(u);
		
		request.setAttribute("users", userDAO.getAllUser());
		RequestDispatcher view = request.getRequestDispatcher("listUser.jsp");
		view.forward(request, response);
	}
}


package event.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import event.dao.eventDAO;

@WebServlet("/ListEventController")
public class ListEventController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private eventDAO dao;
	public ListEventController() {
		super();
		// TODO Auto-generated constructor stub
		dao = new eventDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("events", eventDAO.getAllEvent());
		RequestDispatcher view = request.getRequestDispatcher("listEvent.jsp");
		view.forward(request, response);
	}
	
	
}

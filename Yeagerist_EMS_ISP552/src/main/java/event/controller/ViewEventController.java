package event.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import event.dao.eventDAO;

@WebServlet("/ViewEventController")
public class ViewEventController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private eventDAO dao;
	public ViewEventController() {
		super();
		// TODO Auto-generated constructor stub
		dao = new eventDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("e", eventDAO.getEventById(id));
		RequestDispatcher view = request.getRequestDispatcher("viewEvent.jsp");
		view.forward(request, response);
	}
}

package event.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import event.dao.eventDAO;
import event.model.Event;

@WebServlet("/UpdateEventController")
public class UpdateEventController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private eventDAO dao;
	public UpdateEventController() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Event e = new Event();
		e.setEventId(Integer.parseInt(request.getParameter("id")));
		e.setEventName(request.getParameter("name"));
		e.setEventType(request.getParameter("type"));
		e.setNoParticipant(Integer.parseInt(request.getParameter("participant")));
		
		dao.updateEvent(e);
		
		request.setAttribute("events", eventDAO.getAllEvent());
		RequestDispatcher view = request.getRequestDispatcher("listEvent.jsp");
		view.forward(request, response);
	}
}

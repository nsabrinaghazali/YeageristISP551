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

@WebServlet("/AddEventController")

public class AddEventController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private eventDAO dao;
	public AddEventController() {
		super();
		dao = new eventDAO();
		// TODO Auto-generated constructor stub
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Event e = new Event();
		e.setEventName(request.getParameter("name"));
		e.setEventType(request.getParameter("type"));
		e.setNoParticipant(Integer.parseInt(request.getParameter("participant")));
		
		dao.addEvent(e);
		
		request.setAttribute("events", eventDAO.getAllEvent());
		RequestDispatcher view = request.getRequestDispatcher("listEvent.jsp");
		view.forward(request, response);

}}

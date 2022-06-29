package event.dao;

import java.sql.*;
import java.util.*;
import lab.db.ConnectionManager;
import event.model.Event;

public class eventDAO 
{
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	private int id, noPart;
	private String name, type;
	
	//add event
	public void addEvent(Event bean)
	{
		name = bean.getEventName();
		type = bean.getEventType();
		noPart = bean.getNoParticipant();
		
		try
		{
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO event(eventName,eventType, noPart) VALUES(?,?,?)");
			ps.setString(1, name);
			ps.setString(2, type);
			ps.setInt(3, noPart);
			
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			con.close();
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	
	//get all Event
	public static List<Event> getAllEvent()
	{
		List<Event> events = new ArrayList<Event>();
		
		try {
			con = ConnectionManager.getConnection();
			
			//create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM event ORDER BY id";
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Event e = new Event();
				e.setEventId(rs.getInt("eventId"));
				e.setEventName(rs.getString("eventName"));
				e.setEventType(rs.getString("eventType"));
				e.setNoParticipant(rs.getInt("noPart"));
				events.add(e);
			}
			//5. close connection
			con.close();
		}catch(Exception el) {el.printStackTrace();}
		return events;
	}
	
	//get event by id
	public static Event getEventById(int id)
	{
		Event e = new Event();
		try
		{
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("SELECT* FROM event WHERE id=?");
			ps.setInt(1, id);
			
			//execute query
			rs = ps.executeQuery();
			if(rs.next())
			{
				e.setEventId(rs.getInt("eventId"));
				e.setEventName(rs.getString("eventName"));
				e.setEventType(rs.getString("eventType"));
				e.setNoParticipant(rs.getInt("noPart"));
			}
			//close connection
			con.close();
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		return e;
	}
		//delete Event
	public void deleteEvent (int id)
	{
		try
		{
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM event WHERE id=?");
			ps.setInt(1, id);
			
			//execute update
			ps.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//update Event
	public void updateEvent(Event bean)
	{
		id = bean.getEventId();
		name = bean.getEventName();
		type= bean.getEventType();
		noPart = bean.getNoParticipant();
		
		try
		{
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("UPDATE event SET eventName=?, eventType=?, noPart=? WHERE id =?");
			ps.setString(1, name);
			ps.setString(2, type);
			ps.setInt(3, noPart);
			ps.setInt(4, id);
			
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully Updated");
			
			//close connection
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}}



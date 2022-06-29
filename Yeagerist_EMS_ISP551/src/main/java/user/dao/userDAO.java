package user.dao;

import java.sql.*;
import java.util.*;
import lab.db.ConnectionManager;
import user.model.User;

public class userDAO 
{
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	private int id;
	private String name, password,email;
	
	//add User
	public void addUser(User bean)
	{
		name = bean.getUserName();
		password = bean.getUserPassword();
		email=bean.getUserEmail();
		
		try
		{
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO user(userName,userPassword) VALUES(?,?,?)");
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			con.close();
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	
	//get all User
	public static List<User> getAllUser()
	{
		List<User> users = new ArrayList<User>();
		
		try {
			con = ConnectionManager.getConnection();
			
			//create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM user ORDER BY id";
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				User u = new User();
				u.setUserId(rs.getInt("userId"));
				u.setUserName(rs.getString("userName"));
				u.setUserPassword(rs.getString("userPassword"));
				u.setUserEmail("userEmail");
			
				users.add(u);
			}
			//5. close connection
			con.close();
		}catch(Exception e) {e.printStackTrace();}
		return users;
	}
	
	//get User by id
	public static User getUserById(int id)
	{
		User u = new User();
		try
		{
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("SELECT* FROM user WHERE id=?");
			ps.setInt(1, id);
			
			//execute query
			rs = ps.executeQuery();
			if(rs.next())
			{
				u.setUserId(rs.getInt("userId"));
				u.setUserName(rs.getString("userName"));
				u.setUserEmail(rs.getString("userEmail"));
			}
			//close connection
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;
	}
		//delete User
	public void deleteUser (int id)
	{
		try
		{
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM user WHERE id=?");
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
	//update user
	public void updateUser(User bean)
	{
		id = bean.getUserId();
		name = bean.getUserName();
		email = bean.getUserEmail();
		
		try
		{
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("UPDATE user SET userName=?, userEmail=? WHERE id =?");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3, id);
			
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



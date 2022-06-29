package admin.dao;

import java.sql.*;
import java.util.*;
import lab.db.ConnectionManager;
import admin.model.Admin;

public class adminDAO 
{
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	private int id;
	private String name, password;
	
	//add admin
	public void addAdmin(Admin bean)
	{
		name = bean.getStaffName();
		password = bean.getStaffPassword();
		
		try
		{
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO admin(staffName,staffPassword) VALUES(?,?)");
			ps.setString(1, name);
			ps.setString(2, password);
			
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			con.close();
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	
	//get all admin
	public static List<Admin> getAllAdmin()
	{
		List<Admin> admins = new ArrayList<Admin>();
		
		try {
			con = ConnectionManager.getConnection();
			
			//create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM admin ORDER BY id";
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Admin a = new Admin();
				a.setStaffId(rs.getInt("id"));
				a.setStaffName(rs.getString("name"));
				a.setStaffPassword(rs.getString("password"));
				admins.add(a);
			}
			//5. close connection
			con.close();
		}catch(Exception e) {e.printStackTrace();}
		return admins;
	}
	
	//get admin by id
	public static Admin getAdminById(int id)
	{
		Admin a = new Admin();
		try
		{
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("SELECT* FROM admin WHERE id=?");
			ps.setInt(1, id);
			
			//execute query
			rs = ps.executeQuery();
			if(rs.next())
			{
				a.setStaffId(rs.getInt("id"));
				a.setStaffName(rs.getString("name"));
				a.setStaffPassword(rs.getString("password"));
			}
			//close connection
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}
		//delete admin
	public void deleteAdmin (int id)
	{
		try
		{
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM admin WHERE id=?");
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
	//update shawl
	public void updateAdmin(Admin bean)
	{
		id = bean.getStaffId();
		name = bean.getStaffName();
		password = bean.getStaffPassword();
		
		try
		{
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("UPDATE admin SET staffName=?, staffPassword=? WHERE id =?");
			ps.setString(1, name);
			ps.setString(2, password);
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


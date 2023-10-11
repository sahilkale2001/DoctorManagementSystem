package com.demo.test.main;
import java.sql.*;

class MakeConnection2
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	MakeConnection2()
	{
		System.out.println("Inside Make Connection2");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver"); //registration 
			System.out.println("Inside try after class.forname");
			con=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:XE","system","Worldno11_@"); //connection

	System.out.println("after getConnection statement");
	stmt=con.createStatement();
	System.out.println("after createstatement");
	
	rs=stmt.executeQuery("Select ename, eid from emp");
	System.out.println("After select statement");

	while(rs.next())
		System.out.println(rs.getString(1)+" "+rs.getInt(2));		
		}
		catch(Exception e){e.printStackTrace();}
	}
}

public class TestConnection2
{
	public static void main(String args[])
	{
		System.out.println("Inside Test Connection2");	
		new MakeConnection2();
	}
}

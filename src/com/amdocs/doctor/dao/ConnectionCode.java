package com.amdocs.doctor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionCode {
	public Connection con;
	public Statement stmt;
	
	public ConnectionCode()
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver"); //registration 
			con=DriverManager.getConnection("Jdbc:Oracle:thin:@LAPTOP-V3AH0CSC:1521:XE","system","Worldno11_@"); //connection
			
		}
		catch(Exception e){e.printStackTrace();}
	}

}

package com.webService.dao;

import javax.naming.*;
import javax.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnection {

	
	public static Connection getConnection() throws Exception
	{
	try
	{
		System.out.println("*******database connectivity starts******");
	String connectionURL = "jdbc:mysql://localhost:3306/test";
	Connection connection = null;
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	connection = DriverManager.getConnection(connectionURL, "root", "admin");
	System.out.println("*******database connectivity DONE******");
	return connection;
	}
	catch (SQLException e)
	{
		System.out.println("<<<<<<<<<<<<<<<<<<<SQL exception occureed");
	throw e;
	}
	catch (Exception e)
	{
		System.out.println("<<<<<<unknown error");
	throw e;
	}
	}

}

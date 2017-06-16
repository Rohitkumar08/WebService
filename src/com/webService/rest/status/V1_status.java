package com.webService.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.*;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.webService.dao.*;


@Path("/V1/status")
public class V1_status {
	
	private static final String api_version="00.01.00";
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<p>Java Web Services Done!!!!!</p>";
	}
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion(){
		return "<p>Version: </p>" +api_version;
	}
	@POST
	 @Path("/login")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public String login(@FormParam("username") String username,
	 @FormParam("password") String password) {
		System.out.println("*******************loginservice**************");
		username=username+"Rohit";
		return username;
	 
	}
	 
	
	@GET
	@Path("/GetFeeds")
	//@Produces(MediaType.Application/json)
	@Produces(MediaType.APPLICATION_JSON)
	public String feed()
	{
		System.out.println("*this is now done**************");
	String feeds = null;
	try 
	{
	ArrayList<String> feedData = null;
	//ProjectManager projectManager= new ProjectManager();
	feedData = new ArrayList<String>();
	feedData.add("this");
	feedData.add("something");
	Gson gson = new Gson();
	System.out.println(gson.toJson(feedData));
	feeds = gson.toJson(feedData);
	}

	catch (Exception e)
	{
	System.out.println("Exception Error*************************"); //Console 
	}
	return feeds;
	}

	
	@Path("/database")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String returnDatabaseStatus() throws Exception {
	
	String myString=null;
	String myTime=null;
	String returnString=null;
	Connection conn=null;
	PreparedStatement ps = null;
	Gson g=new Gson();
		try {
			conn=DbConnection.getConnection();
			String sql="select * from user";
		ps = conn.prepareStatement(sql);
		System.out.println("*************entered to blue zone*****************");
		// ps.setString(1,uname);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		myString = rs.getString("username");
		myTime = rs.getString("DateTime");
		}
		
		returnString="This is :"+myString+ "current Time is:"+myTime;
		ps.close();
		} catch (Exception e) {
			System.out.println("*************entered to red zone*****************");
		throw e;
		}
		finally{
			
		}
		return g.toJson(returnString);
		}
	
	

}

package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// setup connection variables
		String user = "springstudent";
		String pass = "springstudent";
		
		// note: from stackoverflow: add &useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
		// String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&amp;serverTimezone=UTC";
		String driver = "com.mysql.jdbc.Driver";
		
		// get connection to database
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database: " + jdbcUrl);
			Class.forName(driver);  // loads database driver - not sure how this works
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("SUCCESS!!!");  // got here wo an exception
			
			myConn.close();
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
		
	}

}

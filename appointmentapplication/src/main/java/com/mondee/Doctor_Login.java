package com.mondee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DoctorLogin")
public class Doctor_Login extends HttpServlet {
	Connection connection=null;
	PreparedStatement ps=null;
	
	public void init(ServletConfig config){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/appointment";
		String username="root";
		String password="4009";
		try {
			connection=DriverManager.getConnection(url,username,password);	
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		PrintWriter pw=response.getWriter();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	String sql="select * from doctor where name=? and password=?";
		try {
			ps=connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				response.sendRedirect("./doctor_home.html");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	}

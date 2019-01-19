package com.accolite.servletapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(request.getMethod());
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = getServletContext().getInitParameter("url1");
				String username = getServletContext().getInitParameter("username");
				String password = getServletContext().getInitParameter("password");
				String nname = request.getParameter("nickName");
				String password1 = request.getParameter("password");
				String ucity = request.getParameter("city");
				if(nname!=null && password1!=null && ucity!=null) {
					Connection con = DriverManager.getConnection(url, username, password);
					Statement st = con.createStatement();
					String uname = (String)request.getAttribute("username");
					String sql = "update LoginTable set nickname='"+nname+"',city='"+ucity+"', password='"+password1+"' where name='"+uname+"'"; 
					st.executeUpdate(sql);
					String msg = "Update done Successfully";
					request.setAttribute("message", msg);
					RequestDispatcher rd = request.getRequestDispatcher("/Logout.jsp");
					rd.forward(request, response);
				}
				else {
					String msg = "Update cannot be done because some fields are empty";
					request.setAttribute("message", msg);
					RequestDispatcher rd = request.getRequestDispatcher("/Logout.jsp");
					rd.forward(request, response);
				}
			} 
			catch (Exception cnfe) {
				System.out.println("cnfe.getMessage():  " + cnfe.getMessage());
				cnfe.getStackTrace();
			}
	}

}

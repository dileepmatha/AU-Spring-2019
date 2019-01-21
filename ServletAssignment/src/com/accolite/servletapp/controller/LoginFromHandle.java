package com.accolite.servletapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginFromHandle")
public class LoginFromHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginFromHandle() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = getServletContext().getInitParameter("url1");
				String username = getServletContext().getInitParameter("username");
				String password = getServletContext().getInitParameter("password");
				String lname = request.getParameter("inputName");
				String lpass = request.getParameter("inputPassword");
				Connection con = DriverManager.getConnection(url, username, password);
				Statement st = con.createStatement();
				String sql = "select * from LoginTable";
				ResultSet rs = st.executeQuery(sql);
				int flag = 0;
				
				while (rs.next()) {
			        String Name = rs.getString("name");
			        String Pass = rs.getString("password");
			        if(Name.equals(lname) && Pass.equals(lpass)) {
			        	flag = 1;
			        	break;
			        }
			     }
				if(flag == 0) {
					String message = "Invalid Username/Password";
					request.setAttribute("message", message);
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
				else {
					HttpSession hs = request.getSession();
					hs.setAttribute("check", "done");
					String unamep = lname;
					request.setAttribute("username",lname);
					RequestDispatcher rd = request.getRequestDispatcher("/Success.jsp");
					rd.forward(request, response);
				}
			} 
			catch (Exception cnfe) {
				System.out.println("cnfe.getMessage():  " + cnfe.getMessage());
				cnfe.getStackTrace();
			}
	}
}

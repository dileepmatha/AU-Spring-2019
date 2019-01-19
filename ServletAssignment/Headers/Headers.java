

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletHome
 */
@WebServlet("/ServletHome")
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println("I am Initialized");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("I am doing Service");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("I am in Get");
		System.out.println(request.getParameter("name1"));
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().print("<br> Init: " + getServletConfig().getInitParameter("Name"));
		//HttpSession s = request.getSession();
		//System.out.println("Session id:" + s.getId());
		///System.out.println("isNew: " + s.isNew());
		 PrintWriter out = response.getWriter();
	     Enumeration<String> headerNames = request.getHeaderNames();
	     out.println("<table border=2><tr><th>Header Name</th><th>Header Value</th>");
	     while (headerNames.hasMoreElements()) {
	          String key = (String) headerNames.nextElement();
	          String value = request.getHeader(key);
	          out.println("<tr><td><b>" + key+"</b><td>" + value);
	     }
	     out.println("<table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("I am in Post");
		doGet(request, response);
		
	}

}

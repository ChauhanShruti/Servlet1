package com.assignment.ques3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(true);
		Date createTime=new Date(session.getCreationTime());
		Date lastAccessTime=new Date(session.getLastAccessedTime());
		
		String msg="Welcome back";
		int vcount=0;
		String vcountkey="vcount";
		String userIdKey="user ID";
		String userid="Shivani";
		
		if(session.isNew()){
			msg="Welcome to my page";
			session.setAttribute(userIdKey,userid);
		}
		else{
			vcount=(int)session.getAttribute(vcountkey);
			vcount+=1;
			userid=(String)session.getAttribute("userid");
		}
		
		session.setAttribute("vount",vcount);
		System.out.println("-----");
		
		PrintWriter out=response.getWriter();
		out.println("    Session ID: "+session.getId());
		out.println("    Message: "+msg);
		out.println("    Visit count: "+vcount);
		out.println("    Last Access Time: "+lastAccessTime);
		out.println("    UserID: "+userid);
		out.println("    Creation Time: "+createTime);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

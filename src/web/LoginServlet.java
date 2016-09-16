package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Admin;
import service.AdminService;
import service.impl.AdminServiceImpl;


public class LoginServlet extends HttpServlet {

	/**
	 *
	 */
	public LoginServlet() {
		super();
	}

	
	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		
	}

	/**
	 
	 * 
	 * @param request
	 *         
	 * @param response
	 *          
	 * @throws ServletException
	 *           
	 * @throws IOException
	 *            
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String username = request.getParameter("username").trim();
		 String password = request.getParameter("password").trim();
		 AdminService as=new AdminServiceImpl();
		 Admin admin;
		try {
			admin = as.login(username,password);
			System.out.println(admin.getPassword()+" "+admin.getUsername()+password+username);
			 HttpSession session = request.getSession();

			 if(username.equals(admin.getUsername())) {
			   String chk="true";
			   session.setAttribute("Enter",chk);
			   session.setAttribute("userName",username);
			   System.out.println("读取数据成功");
			    response.sendRedirect("index.jsp");
			 } else {
			  String errmsg="error1";
			  response.sendRedirect("error.jsp  ? errmsg="+errmsg);
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * T
	 * 
	 *
	 * 
	 * @param request
	 *           
	 *            
	 * @throws ServletException
	 *            
	 * @throws IOException
	 *             
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 *
	 * 
	 * @throws ServletException
	 *          
	 */
	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}

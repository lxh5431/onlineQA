package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AdminService;
import service.impl.AdminServiceImpl;
import util.MD5Util;
  public class CheckServlet extends HttpServlet{
		@Override
		public void destroy() {
			super.destroy();
		}

		
		@Override
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			doPost(request, response);
		}

		
		@Override
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			AdminService adminService=new AdminServiceImpl();
			HttpSession session=null;
			try{

				String oldpassword = request.getParameter("oldpassword");//‘≠√‹¬Î
			    String userName = (String)session.getAttribute("userName");
				String oldpsw = adminService.getOldPsw(userName);
				System.out.println("‘≠√‹¬Î£∫ "+oldpsw);
				String oldpsw2 = MD5Util.MD5Encrypt(oldpassword);
				System.out.println(oldpsw2);
				boolean isSame = oldpsw.equals(oldpsw2);
				request.setAttribute("isSame",isSame);
				if(!isSame)
					{System.out.println("‘≠√‹¬Î ‰»Î¥ÌŒÛ£°");}
				else{
				request.setAttribute("oldpassword",oldpassword);
				response.sendRedirect("./modifyPsw.jsp");
				}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	

		}
		
  }



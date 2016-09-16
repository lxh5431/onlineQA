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
import util.MD5Util;

public class ModifyPswServlet extends HttpServlet{
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
		String userName = request.getParameter("userName");//用户名
		String oldpassword = request.getParameter("oldpassword");//原密码
		String newpassword = request.getParameter("newpassword");//新密码
		AdminService adminService=new AdminServiceImpl();
		try {
		boolean flag=adminService.updatePassword(userName, newpassword);
			if(flag){
				System.out.println("修改密码成功！"+newpassword);
				response.sendRedirect("./modifyPsw.jsp");

		} 
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

}
}
	


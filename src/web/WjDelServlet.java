package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ObjectsService;
import service.impl.ObjectsServiceImpl;

@SuppressWarnings("serial")
public class WjDelServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectsService objectsService=new ObjectsServiceImpl();
		String getid = request.getParameter("oid");
		int oid = Integer.parseInt(getid.trim());
		System.out.println(oid);
		try {
			boolean flag = objectsService.delObjects(oid);
			System.out.println("É¾³ý³É¹¦£¬·µ»Ø"+flag); 
			response.sendRedirect("./wjList.jsp");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
}

package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Objects;
import service.ObjectsService;
import service.impl.ObjectsServiceImpl;

public class WjUpdateServlet extends HttpServlet {
	 
		@Override
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			doPost(request, response);
		
		}
		@Override
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ObjectsService obs=new ObjectsServiceImpl();
			Objects bean = new Objects();
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			String getid = request.getParameter("oid");
			int oid = Integer.parseInt(getid.trim());
			String title = request.getParameter("title");
			String discribe = request.getParameter("discribe");
			String anonymousFlag = request.getParameter("anonymousFlag");
			String remark = request.getParameter("remark");
			bean.setOid(oid);
			bean.setTitle(title);
			bean.setDiscribe(discribe);
			bean.setAnonymousFlag(anonymousFlag);
			bean.setRemark(remark);
			try{
			int i = obs.updateObjects(bean);
			if(i > 0){
				response.sendRedirect("wjList.jsp");
			}else{
				response.sendRedirect("wjUpdate.jsp");
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
}
			
			




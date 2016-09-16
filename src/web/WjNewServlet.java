package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Objects;
import service.ObjectsService;
import service.impl.ObjectsServiceImpl;
import util.FileUtil;

public class WjNewServlet extends HttpServlet {
	/**
	 *
	 */
	public WjNewServlet() {
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

		doPost(request, response);
	
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ObjectsService obs=new ObjectsServiceImpl();
		FileUtil fu=new FileUtil();
		Objects ob = new Objects();
		String title= request.getParameter("title");
		String discribe = request.getParameter("discribe");
		String anonymousFlag = request.getParameter("anonymousFlag");
		String remark  = request.getParameter("remark");
		ob.setTitle(title);
		ob.setDiscribe(discribe);
		ob.setAnonymousFlag(anonymousFlag);
		ob.setRemark(remark);
		try{
		int id = obs.intsertObjects(ob);
		String pathinfo=request.getRealPath("");
		String from=pathinfo+"/readme.txt";
		String to=pathinfo+"/readme_"+id+".jsp";
		String wj="<% String id=\""+id+"\";"+"%"+">";
		fu.copyFile(from,null,to,"UTF-8",wj);
		System.out.println(pathinfo);
		if(id >0){
			System.out.println("创建成功，返回wjList.jsp");
			response.sendRedirect("./wjList.jsp");
			
		}else{

		System.out.println("创建失败，返回wjnew.jsp");
	
			response.sendRedirect("./wjNew.jsp");
		}

	
	}catch(Exception e){
		e.printStackTrace();
	}
}
}
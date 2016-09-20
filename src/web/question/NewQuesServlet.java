package web.question;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ObjectsService;
import service.QuestionService;
import service.SelectorService;
import service.impl.ObjectsServiceImpl;
import service.impl.QuestionServiceImpl;
import service.impl.SelectorServiceImpl;

public class NewQuesServlet extends HttpServlet {
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
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("oid");
		System.out.println("id="+id);
		int oid = Integer.parseInt(id);
		QuestionService qs = new QuestionServiceImpl();
		SelectorService ss = new SelectorServiceImpl();
		ObjectsService objectsService=new ObjectsServiceImpl();
		int seq = 1;
		String content = request.getParameter("content");
		
		String selCount = request.getParameter("listCnt");
		int listCnt = Integer.parseInt(selCount);
		String type=request.getParameter("qtype");
		int qtype = Integer.parseInt(type);
		int insertQues=0;
		try{
		
		int count = objectsService.getCount(oid);
	
		if (count == 0) {
			//往题目表中插入题目
			 insertQues= qs.addQues(oid, content, qtype, seq);
			if (insertQues > 0) {
				//插入选项数据
				for (int i = 1; i <= listCnt; i++) {
					String name = String.valueOf("txt" + i);
					String value = request.getParameter(name);
					//value=new String(value.getBytes("iso8859-1"),"UTF-8");
					ss.addSelecter(oid, seq, value, i);
				}
			}
		} else {
			//往题目表中插入题目
			int addQues = qs.addQues(oid, content, qtype, (count + 1));
			if (addQues > 0) {
				//插入选项数据
				for (int i = 1; i <= listCnt; i++) {
			String name = String.valueOf("txt" + i);
			String value = request.getParameter(name);
			//value=new String(value.getBytes("iso8859-1"),"UTF-8");
			ss.addSelecter(oid, (count + 1), value, i);
				}
			}
		}
		response.sendRedirect("quesList.jsp?oid=" + oid);

}catch(Exception e){
	e.printStackTrace();
}
}
}

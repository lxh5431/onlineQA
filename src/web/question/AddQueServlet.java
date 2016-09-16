package web.question;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Objects;
import service.ObjectsService;
import service.QuestionService;
import service.SelectorService;
import service.impl.ObjectsServiceImpl;
import service.impl.QuestionServiceImpl;
import service.impl.SelectorServiceImpl;
import util.MyTool;

public class AddQueServlet extends HttpServlet {
	
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
		String id=request.getParameter("oid");
		int oid = Integer.parseInt(id);
		String seq=request.getParameter("seq");
		int qseq = Integer.parseInt(seq);
		MyTool tool = new MyTool();
		ObjectsService objectsService=new ObjectsServiceImpl();
		Objects ob;
		try {
			ob = objectsService.findObjectsByID(oid);
			System.out.println(ob.getTitle());
		
		
		int state = ob.getState();
		if (state == 1 || state == 2) {
	    //清空回复表中的数据
	   // ReplayService.delReplay(oid);
	    //修改问卷状态为草稿
	    tool.UpdateCol("object", "state", "0", "oid", id);
		String content=request.getParameter("content");
		String selCount = request.getParameter("listCnt");
		int listCnt = Integer.parseInt(selCount);
		String type=request.getParameter("qtype");
		int qtype = Integer.parseInt(type);
		QuestionService qs = new QuestionServiceImpl();
		SelectorService ss = new SelectorServiceImpl();
		 
		int count = objectsService.getCount(oid);
		//如果题目的最大顺序号小于所传进来的顺序号 则先修改顺序号再进行插入 否则直接插入
		if (count > qseq) {
			//修改问题表中题目的顺序
			int updateQuesOrder = qs.updateQuesOrder(oid, qseq);
			if (updateQuesOrder > 0) {
			//修改选项表中题目的顺序
			int updateSseq = ss.updateSelecterSeq(oid, qseq);
				if (updateSseq > 0) {
			//往题目表中插入题目
					int insertQues = qs.addQues(oid,content, qtype, (qseq+1));
					if (insertQues > 0) {
						
					//插入选项数据
						for (int i = 1; i <= listCnt; i++) {
							String name = String.valueOf("txt" + i);
							String value = request.getParameter(name);
							ss.addSelecter(oid, (qseq+1), value, i);
						}
					}
				}
			}
		} else {

			//往题目表中插入题目
			int addQues = qs.addQues(oid,content, qtype, (qseq+1));
			if (addQues > 0) {
		//插入选项数据
				for (int i = 1; i <= listCnt; i++) {
					String name = String.valueOf("txt" + i);
					String value = request.getParameter(name);
					ss.addSelecter(oid, (qseq+1), value, i);
					 response.sendRedirect("main.jsp");
				}
			}
		}
		response.sendRedirect("./quesList.jsp?oid="+ oid);

		
	}
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}



	
	
	


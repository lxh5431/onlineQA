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
		String content=request.getParameter("content");
		String selCount = request.getParameter("listCnt");
		int listCnt = Integer.parseInt(selCount);
		String type=request.getParameter("qtype");
		int qtype = Integer.parseInt(type);
		QuestionService qs = new QuestionServiceImpl();
		SelectorService ss = new SelectorServiceImpl();
		ObjectsService objectsService=new ObjectsServiceImpl(); 
		try{
		int count = objectsService.getCount(oid);
		//�����Ŀ�����˳���С������������˳��� �����޸�˳����ٽ��в��� ����ֱ�Ӳ���
		if (count > qseq) {
			//�޸����������Ŀ��˳��
			int updateQuesOrder = qs.updateQuesOrder(oid, qseq);
			if (updateQuesOrder > 0) {
			//�޸�ѡ�������Ŀ��˳��
			int updateSseq = ss.updateSelecterSeq(oid, qseq);
				if (updateSseq > 0) {
			//����Ŀ���в�����Ŀ
					int insertQues = qs.addQues(oid,content, qtype, (qseq+1));
					if (insertQues > 0) {
					//����ѡ������
						for (int i = 1; i <= listCnt; i++) {
							String name = String.valueOf("txt" + i);
							String value = request.getParameter(name);
							ss.addSelecter(oid, (qseq+1), value, i);
						}
					}
				}
			}
		} else {

			//����Ŀ���в�����Ŀ
			int addQues = qs.addQues(oid,content, qtype, (qseq+1));
			if (addQues > 0) {
		//����ѡ������
				for (int i = 1; i <= listCnt; i++) {
					String name = String.valueOf("txt" + i);
					String value = request.getParameter(name);
					ss.addSelecter(oid, (qseq+1), value, i);
				}
			}
		}
		response.sendRedirect("quesList.jsp?oid="+ oid);


}catch(Exception e){
	e.printStackTrace();
}
}
}


	
	
	


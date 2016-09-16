package service.impl;

import java.util.List;

import dao.QuestionDao;
import dao.impl.QuestionDaoImpl;
import entity.Question;
import service.QuestionService;

public class QuestionServiceImpl implements QuestionService {
 QuestionDao questionDao=new QuestionDaoImpl();
	@Override
	public List<Question> listQuesByOid(int oid) {
		// TODO Auto-generated method stub
		return questionDao.listQuesByOid(oid);
	}

	@Override
	public int addQues(int oid, String content, int qtype, int seq) {
		// TODO Auto-generated method stub
		return questionDao.addQues(oid, content, qtype, seq);
	}

	@Override
	public int updateQuesOrder(int oid, int seq) {
		// TODO Auto-generated method stub
		return questionDao.updateQuesOrder(oid, seq);
	}

	@Override
	public Question getQuesBySeq(int seq, int oid) {
		// TODO Auto-generated method stub
		return questionDao.getQuesBySeq(seq, oid);
	}

	@Override
	public int deleteQues(int seq, int oid) {
		// TODO Auto-generated method stub
		return questionDao.deleteQues(seq, oid);
	}

	@Override
	public int updateQseq(int seq, int oid) {
		// TODO Auto-generated method stub
		return questionDao.updateQseq(seq, oid);
	}

	@Override
	public int getQuesCount(int oid) {
		// TODO Auto-generated method stub
		return questionDao.getQuesCount(oid);
	}

}

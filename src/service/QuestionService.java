package service;

import java.util.List;

import entity.Question;

public interface QuestionService {
	public List<Question> listQuesByOid(int oid);
	public int addQues(int oid, String content, int qtype, int seq);
	public int updateQuesOrder(int oid, int seq);
	public Question getQuesBySeq(int seq, int oid);
	public int deleteQues(int seq, int oid);
	public int updateQseq(int seq, int oid);
	public int getQuesCount(int oid);

}

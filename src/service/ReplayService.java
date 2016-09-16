package service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import entity.Answer;
import entity.Replay;

public interface ReplayService {
	public  Map<Integer,List<Map<Integer,Integer>>> getAllAnswer(int oid);
	public  List<Answer> getAnswers(int oid,int qSeq);
	public  int getQuesCount(Connection con, int oid);
	public  int getSelCount(Connection con, int oid, int qSeq);
	public int getAnswerCount(int oid) ;
	public  int getAnswerCount(Connection con, int oid,int qSeq);
	public  boolean save(Replay r,List<Answer> answers);
	public  boolean exit(int oid,String replayIp,String replayCode);
	int getAnswerCount(Connection con, int oid, int qSeq, int seSeq);
	boolean delReplay(int oid) throws Exception;

}

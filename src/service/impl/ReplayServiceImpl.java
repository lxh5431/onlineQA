package service.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import dao.ReplayDao;
import dao.impl.ReplayDaoImpl;
import entity.Answer;
import entity.Replay;
import service.ReplayService;

public class ReplayServiceImpl implements ReplayService {
     ReplayDao replayDao=new ReplayDaoImpl();

	@Override
	public Map<Integer, List<Map<Integer, Integer>>> getAllAnswer(int oid) {
		// TODO Auto-generated method stub
		return  replayDao.getAllAnswer(oid);
	}

	@Override
	public List<Answer> getAnswers(int oid, int qSeq) {
		// TODO Auto-generated method stub
		return  replayDao.getAnswers(oid, qSeq);
	}

	@Override
	public int getQuesCount(Connection con, int oid) {
		// TODO Auto-generated method stub
		return  replayDao.getQuesCount(con, oid);
	}

	@Override
	public int getSelCount(Connection con, int oid, int qSeq) {
		// TODO Auto-generated method stub
		return  replayDao.getSelCount(con, oid, qSeq);
	}

	@Override
	public int getAnswerCount(int oid) {
		// TODO Auto-generated method stub
		return  replayDao.getAnswerCount(oid);
	}

	@Override
	public int getAnswerCount(Connection con, int oid, int qSeq) {
		// TODO Auto-generated method stub
		return  replayDao.getAnswerCount(con, oid, qSeq);
	}

	@Override
	public boolean save(Replay r, List<Answer> answers) {
		// TODO Auto-generated method stub
		return  replayDao.save(r, answers);
	}

	@Override
	public boolean exit(int oid, String replayIp, String replayCode) {
		// TODO Auto-generated method stub
		return  replayDao.exit(oid, replayIp, replayCode);
	}

	@Override
	public int getAnswerCount(Connection con, int oid, int qSeq, int seSeq) {
		// TODO Auto-generated method stub
		return  replayDao.getAnswerCount(con, oid, qSeq, seSeq);
	}

	@Override
	public boolean delReplay(int oid) throws Exception {
		// TODO Auto-generated method stub
		return  replayDao.delReplay(oid);
	}
}

	
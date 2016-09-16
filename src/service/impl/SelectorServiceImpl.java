package service.impl;

import java.util.List;

import dao.SelectorDao;
import dao.impl.SelectorDaoImpl;
import service.SelectorService;

public class SelectorServiceImpl implements SelectorService {
  SelectorDao selectorDao=new SelectorDaoImpl();
	@Override
	public List listSelecterBySeq(int seq, int oid) {
		// TODO Auto-generated method stub
		return selectorDao.listSelecterBySeq(seq, oid);
	}

	@Override
	public int addSelecter(int oid, int seq, String content, int seq_selecter) {
		// TODO Auto-generated method stub
		return selectorDao.addSelecter(oid, seq, content, seq_selecter);
	}

	@Override
	public int updateSelecterSeq(int oid, int qseq) {
		// TODO Auto-generated method stub
		return selectorDao.updateSelecterSeq(oid, qseq);
	}

	@Override
	public int deleteSelecter(int seq, int oid) {
		// TODO Auto-generated method stub
		return selectorDao.deleteSelecter(seq, oid);
	}

	@Override
	public int updateSseq(int seq, int oid) {
		// TODO Auto-generated method stub
		return selectorDao.updateSseq(seq, oid);
	}

}

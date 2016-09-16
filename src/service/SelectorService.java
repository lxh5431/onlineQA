package service;

import java.util.List;

public interface SelectorService {
//	 根据题目顺序查找选项的值 返回一个结果集

	public List listSelecterBySeq(int seq, int oid);
//	 插入选项
	public int addSelecter(int oid, int seq, String content, int seq_selecter);
//	 往选项表插入内容的时候先修改选项表中所属的题目的顺序号
	public int updateSelecterSeq(int oid, int qseq);
//	 传进来问卷编号和试题的顺序号 删除该题所对应的选项表中的数据
	public int deleteSelecter(int seq, int oid);
	// 根据传进来的问卷编号和题目的序号 修改选项表中题目的顺序
		public int updateSseq(int seq, int oid);

}

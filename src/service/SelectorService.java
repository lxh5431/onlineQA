package service;

import java.util.List;

public interface SelectorService {
//	 ������Ŀ˳�����ѡ���ֵ ����һ�������

	public List listSelecterBySeq(int seq, int oid);
//	 ����ѡ��
	public int addSelecter(int oid, int seq, String content, int seq_selecter);
//	 ��ѡ���������ݵ�ʱ�����޸�ѡ�������������Ŀ��˳���
	public int updateSelecterSeq(int oid, int qseq);
//	 �������ʾ��ź������˳��� ɾ����������Ӧ��ѡ����е�����
	public int deleteSelecter(int seq, int oid);
	// ���ݴ��������ʾ��ź���Ŀ����� �޸�ѡ�������Ŀ��˳��
		public int updateSseq(int seq, int oid);

}

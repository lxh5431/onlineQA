package dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import dao.ReplayDao;
import entity.Answer;
import entity.Replay;
import util.JdbcUtil;

public class ReplayDaoImpl implements ReplayDao{
	
	

	
	
		/**
		 * ��ȡ��������ش����
		 * @param oid ����ID
		 * @return
		 */
	@Override
		public  Map<Integer,List<Map<Integer,Integer>>> getAllAnswer(int oid) {
			JdbcUtil db = new JdbcUtil();
			Connection con=null;
			Statement stm=null;
			ResultSet rs=null;
			int qCount = 0;
			int sCount = 0;
			int qaCount = 0;
			int saCount = 0;
			Map<Integer,List<Map<Integer,Integer>>> map = new HashMap<Integer,List<Map<Integer,Integer>>>();
			try {
				con = db.getConnection();
				qCount = getQuesCount(con,oid);
				for(int i=1;i<=qCount;i++)
				{
					List<Map<Integer,Integer>> list = new ArrayList<Map<Integer,Integer>>();
					qaCount = getAnswerCount(con,oid,i);
					System.out.println(qaCount);
					sCount = getSelCount(con,oid,i);
					System.out.println(sCount);
					for(int j=0;j<=sCount;j++)
					{
						Map<Integer,Integer> m = new HashMap<Integer,Integer>();
						if(j==0){
							m.put(0, qaCount);
						}else{
							saCount = getAnswerCount(con,oid,i,j);
							m.put(j, saCount);
						}
						list.add(m);
					}
					map.put(i, list);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				db.closeAll(con, stm, rs);
			}
			return map;
		}
	@Override
		public  List<Answer> getAnswers(int oid,int qSeq)  {
			JdbcUtil dbcon = new JdbcUtil();
			Connection con=null;
			Statement stm=null;
			ResultSet rs=null;
			List<Answer> answers = new LinkedList<Answer>();
			String sql = "select * from answer where oid='"+ oid + "' and qSeq="+qSeq+" order by answerId asc";
			try {
				dbcon=new JdbcUtil();
				con=dbcon.getConnection();
				stm=con.createStatement();
				 rs = stm.executeQuery(sql);
				 while(rs.next()){
					 Answer answer = new Answer();
					 int answerId = rs.getInt("answerId");
					 int replayId = rs.getInt("replayId");
					 int oidd = rs.getInt("oid");
					 int qSeqq = rs.getInt("qSeq");
					 int seSeq = rs.getInt("seSeq");
					 String seValue = rs.getString("seValue");
					 String remark = rs.getString("remark");
					 
					 answer.setAnswerId(answerId);
					 answer.setReplayId(replayId);
					 answer.setOid(oidd);
					 answer.setqSeq(qSeqq);
					 answer.setSeSeq(seSeq);
					 answer.setSeValue(seValue);
					 answer.setRemark(remark);
					
					 answers.add(answer);
			 }
				return answers;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
				dbcon.closeAll(con, stm, rs);
			}
		}
		
		/**
		 * �õ���������
		 * @param con
		 * @param oid
		 * @return
		 */
	@Override
		public  int getQuesCount(Connection con, int oid) {
			
			JdbcUtil jdbcutil = new JdbcUtil();
			Statement stm = null;
			ResultSet rs = null;
			int qcount = 0;
			try {
				stm=con.createStatement();
				String sql = "select count(*) from question where oid=" + oid;
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					qcount = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				jdbcutil.free(stm, rs);
			}
//			System.out.println("���������" + qcount);
			return qcount;
		}
		
		/**
		 * �õ�ѡ������
		 * @param con
		 * @param oid
		 * @return
		 */
	@Override
		public  int getSelCount(Connection con, int oid, int qSeq) {
			JdbcUtil jdbcutil = new JdbcUtil();
			Statement stm = null;
			ResultSet rs = null;
			int qcount = 0;
			try {
				stm=con.createStatement();
				String sql = "select count(*) from selecter where oid=" + oid +" and qseq ="+qSeq;
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					qcount = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
			jdbcutil.free(stm, rs);
				
			}
//			System.out.println("ѡ�������" + qcount);
			return qcount;
		}
		
		/**
		 * ��������ID��ѯ�ظ�����
		 * @param oid ����ID
		 * @return
		 */
	@Override
		public int getAnswerCount(int oid) {
			JdbcUtil jdbcutil = new JdbcUtil();
			Connection con=null;
			Statement stm=null;
			ResultSet rs=null;
			String sql = "";
			int rcount = 0;
			try {
				con = jdbcutil.getConnection();
				stm = con.createStatement();
				sql = "select count(*) from replay where oid =" + oid;
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					rcount = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				jdbcutil.closeAll(con, stm, rs);
			}
		System.out.println("�ظ���������rcount:" + rcount);
			return rcount;
		}
		
		/**
		 * ��������Id����Ŀ��Ų�ѯ������Ļش���
		 * @param con ���ݿ�����
		 * @param oid ����Id
		 * @param qSeq ��Ŀ���
		 * @return �ش���
		 */
	@Override
		public  int getAnswerCount(Connection con, int oid,int qSeq) {
			JdbcUtil jdbcutil = new JdbcUtil();
			Statement stm=null;
			ResultSet rs=null;
			String sql = "";
			int rcount = 0;
			try {
				stm = con.createStatement();
				sql = "select count(*) from answer where oid =" + oid +" and qSeq="+qSeq;
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					rcount = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				jdbcutil.closeAll(stm, rs);
			}
		System.out.println("����Ļش���rcount:" + rcount);
			return rcount;
		}
		
		/**
		 * ��������Id����Ŀ��ź�ѡ����Ų�ѯ������ѡ��Ļش���
		 * @param con ���ݿ�����
		 * @param oid ����Id
		 * @param qSeq ��Ŀ���
		 * @param seSeq ѡ�����
		 * @return ����ѡ��Ļش���
		 */
	@Override
		public  int getAnswerCount(Connection con, int oid,int qSeq,int seSeq){
			
			JdbcUtil jdbcutil = new JdbcUtil();
			Statement stm=null;
			ResultSet rs=null;
			String sql = "";
			int rcount = 0;
			try {
				stm = con.createStatement();
				sql = "select count(*) from answer where oid =" + oid +" and qSeq="+qSeq +" and seSeq="+seSeq;
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					rcount = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				jdbcutil.free(stm, rs);
			}
//			System.out.println("����ѡ��Ļش���rcount:" + rcount);
			return rcount;
		}
		
		/**
		 * ���ظ���Ϣ�洢�����ݿ�
		 * @param rList
		 * @return
		 */
	@Override
		public  boolean save(Replay r,List<Answer> answers) {
			JdbcUtil jdbcutil= new JdbcUtil();
			Connection con=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			String sql = "";
			int count = 0;
			int replayId = 0;
			boolean flag = false;
			boolean defaultAutoCommit = true;
			Timestamp currentTime = new Timestamp(System.currentTimeMillis());
			try {
				con = jdbcutil.getConnection();
				defaultAutoCommit = con.getAutoCommit();
				con.setAutoCommit(false);
				sql = "insert into replay(replayCode,replayIp,oid,replayTime,remark) values (?,?,?,?,?)";
				System.out.println(sql);
				stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, r.getReplayCode());
				stmt.setString(2, r.getReplayIp());
				stmt.setInt(3, r.getoId());
				stmt.setTimestamp(4, currentTime);
				stmt.setString(5, r.getRemark());
				
				stmt.executeUpdate();
				rs = stmt.getGeneratedKeys();
				if(rs.next()) replayId = rs.getInt(1);
				System.out.println("replayId: "+replayId);
				
				sql = "insert into answer(replayId,oid,qSeq,seSeq,seValue,remark) values (?,?,?,?,?,?)";
				
				for(int i=0;i<answers.size();i++)
				{
					Answer a = answers.get(i);
					stmt = con.prepareStatement(sql);
					stmt.setInt(1, replayId);
					stmt.setInt(2, a.getOid());
					stmt.setInt(3, a.getqSeq());
					stmt.setInt(4, a.getSeSeq());
					stmt.setString(5, a.getSeValue());
					stmt.setString(6, a.getRemark());
					stmt.executeUpdate();
					
					count++;
				}
				con.commit();
				con.setAutoCommit(defaultAutoCommit);
				flag = true;
				System.out.println("�����[answer] "+count+" ����¼");
			} catch (Exception e) {
				try {
					if(con!=null){
						con.rollback();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally{
				jdbcutil.closeAll(con, stmt, rs);
			}
			return flag;
		}
	@Override
		// ɾ���ʾ�ظ����
		public  boolean delReplay(int oid) throws Exception {
			JdbcUtil dbcon = new JdbcUtil();
			boolean flag = false;
			Connection conn = dbcon.getConnection();
			conn.setAutoCommit(false);
			String sql1 = "delete from replay where oid="+oid;
			String sql2 = "delete from answer where oid="+oid;
			try {
				dbcon.update(sql1, conn);
				dbcon.update(sql2, conn);
				conn.commit();
				flag = true;
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			} finally {
				try {
					conn.setAutoCommit(true);
					dbcon.closeAll(conn);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return flag;
		}
		
		/**
		 * �ж��Ƿ���ڻظ�
		 * @param oid
		 * @param code
		 * @return
		 */
	@Override
		public  boolean exit(int oid,String replayIp,String replayCode) {
			JdbcUtil jdbcutil = new JdbcUtil();
			Connection con=null;
			Statement stm=null;
			ResultSet rs=null;
			String sql = "";
			boolean falg = false;
			int qcount = 0;
			try {
				con = jdbcutil.getConnection();
				stm = con.createStatement();
				sql = "select count(*) from replay r where oid="+oid;
				if(replayIp!=null&&!replayIp.trim().equals("")) sql +=" and r.replayIp='"+replayIp+"'";
				if(replayCode!=null&&!replayCode.trim().equals("")) sql +=" and r.replayCode='"+replayCode+"'";
				System.out.println(sql);
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					qcount = rs.getInt(1);
				}
				if(qcount>0) falg=true;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				jdbcutil.closeAll(con, stm, rs);
			}
			return falg;
		}

	}




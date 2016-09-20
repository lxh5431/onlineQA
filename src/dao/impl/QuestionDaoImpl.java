package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import dao.QuestionDao;
import entity.Question;
import util.JdbcUtil;

public class QuestionDaoImpl implements QuestionDao {
	//查看問題
	public List<Question> listQuesByOid(int oid){
		   JdbcUtil jdbcutil=null;
			Connection conn = null;
			Statement stm = null;
			ResultSet rs = null;
			
			List<Question>list=new LinkedList<Question>();
			String sql="select seq,content,qtype from question where oid='"
					+ oid + "' order by seq asc";

			//String sql="select content, qtype,seq from question where oid'"+oid+"'order by seq asc";
			try{
				 jdbcutil=new JdbcUtil();
				 conn=jdbcutil.getConnection();
				 stm=conn.createStatement();
				 rs=stm.executeQuery(sql);
				 while(rs.next()){
					 Question ques=new Question();
					 int seq=rs.getInt("seq");
					 int qtype=rs.getInt("qtype");
					 String content=rs.getString("content");
					 ques.setContent(content);
					 ques.setSeq(seq);
					 ques.setQtype(qtype);
					 list.add(ques);
					 }
					return list;
	}catch(Exception e){
		e.printStackTrace();
		return null;
	}
			finally{
				jdbcutil.closeAll(conn, stm, rs);
			}
			}
	
	
	public int addQues(int oid, String content, int qtype, int seq){
		 JdbcUtil jdbcutil=null;
			Connection conn = null;
			Statement stm = null;
			String sql="insert into question(oid,content,qtype,seq) values('"+oid+"','"+content+"','"+qtype+"','"+seq+"')";
		try{	
			jdbcutil=new JdbcUtil();
			 conn=jdbcutil.getConnection();
			 stm=conn.createStatement();
			
			int  quesid=stm.executeUpdate(sql);
			return quesid;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		} finally{
		
		
		jdbcutil.closeAll(conn, stm);
		
	}
		
	}
	public int updateQuesOrder(int oid, int seq) {
		 JdbcUtil jdbcutil=null;
			Connection conn = null;
			Statement stm = null;
			String sql="update question set seq=(seq + 1) where oid='"+oid+"',seq>'"+seq+"'";
			try{	
				jdbcutil=new JdbcUtil();
			 conn=jdbcutil.getConnection();
			 stm=conn.createStatement();
			
			int  quesid=stm.executeUpdate(sql);
			return quesid;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		} finally{
		jdbcutil.closeAll(conn,stm);
		}
	}
	public Question getQuesBySeq(int seq, int oid) {
		
		JdbcUtil jdbcutil=null;
		Connection conn = null;
		Statement stm = null;
		ResultSet rs=null;
	Question questions=new Question();
		String sql="update question set seq where oid='"+oid+"',seq>'"+seq+"'";
		try{	
			jdbcutil=new JdbcUtil();
		conn=jdbcutil.getConnection();
		  stm=conn.createStatement();
		 rs = stm.executeQuery(sql);
		  while(rs.next()){
			 String content=rs.getString("content");
			 int qtype=rs.getInt("qtype");
			 questions.setContent(content);
			 questions.setQtype(qtype);
			 
			 
		 }
		return questions;
	} catch (Exception e) {
			e.printStackTrace();
		return null;
	} finally {
		jdbcutil.closeAll(conn,stm,rs);
	}

		
	}

	public int deleteQues(int seq, int oid) {
		 JdbcUtil jdbcutil=null;
			Connection conn = null;
			Statement stm = null;
			ResultSet rs = null;

			int  quesid=0;
			String sql="delete  from question where oid=" + oid + " and seq = "+ seq;
			try{
        		jdbcutil=new JdbcUtil();
				conn=jdbcutil.getConnection();
				 stm=conn.createStatement();
				 quesid=stm.executeUpdate(sql);
					
			
	}catch(Exception e){
		e.printStackTrace();
		
	} finally{
	jdbcutil.closeAll(conn,stm,rs);

	}
			return quesid;
	}

	public int updateQseq(int seq, int oid) {
		 JdbcUtil jdbcutil=null;
			Connection conn = null;
			Statement stm = null;
			int count=0;
			String sql="update question set seq=(seq-1) where oid = " + oid+ " and seq > " + seq ;

			try{
				jdbcutil=new JdbcUtil();
				 conn=jdbcutil.getConnection();
				 stm=conn.createStatement();
				 count=stm.executeUpdate(sql);
					
			
	}catch(Exception e){
		e.printStackTrace();
		return 0;
	} finally{
	jdbcutil.closeAll(conn,stm);
	}
		return count;
		
	}
	public int getQuesCount(int oid) {
		JdbcUtil jdbcutil=null;
		Connection conn = null;
		Statement stm = null;
		ResultSet rs=null;
		int qcount = 0;
		String sql = "select count(*) from question where oid=" + oid;
		try {
			jdbcutil=new JdbcUtil();
			
            conn=jdbcutil.getConnection();
			stm=conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				qcount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcutil.closeAll(conn, stm, rs);
		}
		System.out.println("问题的总数" + qcount);
		return qcount;

		
	}

/*public static void main(String[] args) {
	QuestionDao qi=new QuestionDaoImpl();
	qi.addQues(22, "恢复数据库", 1, 2);
  //System.out.println(qi.listQuesByOid(21));
	//System.out.println(qi.getQuesCount(22));
	//qi.deleteQues(2, 22);
	Question question=new Question();
	question.setContent("不知者无罪，我会努力的");
	question.setRemark("如果一直吃下去公司欢迎你");
	
	qi.updateQseq(2, 22);
	     
}*/
		
	}
	


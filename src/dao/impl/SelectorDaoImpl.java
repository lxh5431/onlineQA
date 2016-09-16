package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import dao.SelectorDao;
import entity.Selecter;
import util.JdbcUtil;


public class SelectorDaoImpl implements SelectorDao {
	  @Override
		public List listSelecterBySeq(int seq, int oid) {
			JdbcUtil jdbcutil=null;
			Connection conn = null;
			Statement stm = null;
			ResultSet rs = null;
			List selList=new LinkedList();
			String sql = "select qseq,selseq,content from selecter where qseq = '"
					+ seq + "' and oid = '" + oid + "' order by selseq asc";
			 System.out.println(sql);
			try {
				jdbcutil=new JdbcUtil();
				conn=jdbcutil.getConnection();
				stm=conn.createStatement();
				rs=stm.executeQuery(sql);
				while(rs.next()){
					Selecter sel=new Selecter();
					int qseq=rs.getInt("qseq");
					int selseq=rs.getInt("selseq"); 
					String conntent=rs.getString("content");
					sel.setQseq(qseq);
					sel.setSelseq(selseq);
					sel.setContent(conntent);
					selList.add(sel);
				}
				return selList;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
				jdbcutil.closeAll(conn,stm, rs);
			}
		}



		@Override
		public int addSelecter(int oid, int seq, String content, int seq_selecter) {
			JdbcUtil jdbcutil=null;
			Connection conn = null;
			Statement stm = null;
			ResultSet rs = null;
			String sql = "insert into selecter(oid,qseq,content,selseq) values('"
					+ oid
					+ "','"
					+ seq
					+ "','"
					+ content
					+ "','"
					+ seq_selecter
					+ "')";
			System.out.println(sql);
			try {
				jdbcutil=new JdbcUtil();
				conn=jdbcutil.getConnection();
				stm=conn.createStatement();
				int i = stm.executeUpdate(sql);
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			} finally {
				jdbcutil.closeAll(conn,stm,rs);
			}

		}

		@Override
		public int updateSelecterSeq(int oid, int qseq) {
			JdbcUtil jdbcutil = null;
			Connection con = null;
			Statement stm = null;
			ResultSet rs = null;
			String sql = "update selecter set qseq=(qseq+1) where oid = '" + oid
					+ "'and qseq > '" + qseq + "'";
			System.out.println(sql);
			try {
				jdbcutil=new JdbcUtil();
				con=jdbcutil.getConnection();
				stm=con.createStatement();
				int i = stm.executeUpdate(sql);
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			} finally {
				try {
					jdbcutil.closeAll(jdbcutil.getConnection());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		

		@Override
		public int deleteSelecter(int seq, int oid) {
			JdbcUtil jdbcutil = null;
			Connection con = null;
			Statement stm = null;
			ResultSet rs = null;
			String sql = "delete from selecter where oid=" + oid + " and qseq="
					+ seq ;
			int count=0;
			System.out.println(sql);
			try {
				jdbcutil=new JdbcUtil();
				con=jdbcutil.getConnection();
				stm=con.createStatement();
				 count = stm.executeUpdate(sql);
				
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			} finally {
				jdbcutil.closeAll(con, stm, rs);
			}
			return count;

		}

		

		@Override
		public int updateSseq(int seq, int oid) {
			JdbcUtil jdbcutil = null;
			Connection con = null;
			Statement stm = null;
			ResultSet rs = null;
			int count=0;
			String sql = "update selecter set qseq=(qseq-1) where oid = " + oid
					+ " and qseq > " + seq ;
			System.out.print(sql);
			try {
				jdbcutil=new JdbcUtil();
				con=jdbcutil.getConnection();
				stm=con.createStatement();
				count = stm.executeUpdate(sql);
				
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			} finally {
				jdbcutil.closeAll(con, stm, rs);
			}
			return count;
		}

		}
		
		
		
		






package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.AdminDao;
import entity.Admin;

import util.JdbcUtil;
import util.MD5Util;

public class AdminDaoImpl implements AdminDao {
	/**
	 *@author lxh 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@Override
	public Admin login(String username,String password) throws Exception {
	 JdbcUtil jdbcutil = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin admin=new Admin();
		String md5Psw = MD5Util.MD5Encrypt(password);
		String sql = "select * from admin where username =? and password =?";
		try {
			jdbcutil=new JdbcUtil();
			con= jdbcutil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, md5Psw);
			rs = ps.executeQuery();
			 while(rs.next()){
			String uname=rs.getString("username");
			String pwd=rs.getString("password");
			admin.setPassword(pwd);
			admin.setUsername(uname);
		}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
		jdbcutil.closeAll(con, ps, rs);
		}
		return admin;
	}
	/**
	 * @
	 * @param username
	 * @return
	 */
	@Override
	public  String getOldPsw(String username)throws Exception{
		JdbcUtil jdbcutil = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String psw ="";
		String	sql = "select * from admin where username =?";
		try {
			jdbcutil=new JdbcUtil();
			con= jdbcutil.getConnection();
			ps= con.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
		    while(rs.next()){
		    	psw=rs.getString("password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcutil.closeAll(con, ps, rs);
		}
		return psw;
	}
	/**
	 * ÐÞ¸ÄÃÜÂë
	 * @param username
	 * @param newpsw
	 * @return
	 * @throws Exception 
	 */
	@Override
	public boolean updatePassword(String username,String newpsw) throws Exception{
		JdbcUtil jdbcutil = null;
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		String md5Psw = MD5Util.MD5Encrypt(newpsw);
		String	sql = "update admin set password = ? where username = ?";
		System.out.println(sql);
		try {
			jdbcutil=new JdbcUtil();
			con= jdbcutil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, md5Psw);
			ps.setString(2, username);
			ps.executeUpdate();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcutil.closeAll(con, ps, rs);
		}
		return flag;
	}
	
}

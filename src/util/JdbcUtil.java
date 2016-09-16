package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

	static String url = "jdbc:mysql://localhost:3306/vote?useUnicode=true&characterEncoding=utf-8";
	static String user = "root";
	static String password = "root";
	static Connection conn=null;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public Connection getConnection() throws SQLException {
		conn =DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	public int update(String sql, Connection conn){
		Statement sta = null;
		try {
			sta = conn.createStatement();
			System.out.println(sql);
			int i = sta.executeUpdate(sql);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	public ResultSet execute(String sql, Connection conn) {
		Statement sta = null;
		try {
			sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
	}
	public boolean executeSql(String sql, Connection conn) {
		Statement sta = null;
		try {
			sta = conn.createStatement();
			sta.execute(sql);
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		} 
	}
	public void closeAll(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeAll(Statement stm, ResultSet rs) {
		try {
			if (stm != null) {
				stm.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void closeAll(Connection conn, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void closeAll(Connection conn, Statement sta, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (sta != null) {
				sta.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	
	

	public void free(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeAll(Connection conn, Statement stm) {
		// TODO Auto-generated method stub
		try {
			if (conn != null) {
				conn.close();
			}
			if (stm != null) {
				stm.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

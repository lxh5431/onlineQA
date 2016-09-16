package dao;

import entity.Admin;

public interface AdminDao {
	public Admin login(String username,String password) throws Exception;
	public  String getOldPsw(String username)throws Exception;
	public boolean updatePassword(String username,String newpsw) throws Exception;

}

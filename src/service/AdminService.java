package service;

import entity.Admin;

public interface AdminService {
	public Admin login(String username,String password) throws Exception;
	public  String getOldPsw(String username)throws Exception;
	public boolean updatePassword(String username,String newpsw) throws Exception;

}

package service.impl;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import entity.Admin;
import service.AdminService;

public class AdminServiceImpl implements AdminService {
AdminDao adminDao= new AdminDaoImpl();
	@Override
	public Admin login(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.login(username, password);
	}

	@Override
	public String getOldPsw(String username) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.getOldPsw(username);
	}

	@Override
	public boolean updatePassword(String username, String newpsw) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.updatePassword(username, newpsw);
	}

}

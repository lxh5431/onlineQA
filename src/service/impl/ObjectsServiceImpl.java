package service.impl;

import java.sql.SQLException;
import java.util.List;

import dao.ObjectsDao;
import dao.impl.ObjectsDaoImpl;
import entity.Objects;
import service.ObjectsService;

public class ObjectsServiceImpl implements ObjectsService  {
	ObjectsDao objectDao=new ObjectsDaoImpl();

	@Override
	public int intsertObjects(Objects object) throws SQLException {
		// TODO Auto-generated method stub
		return objectDao.intsertObjects(object);
	}

	@Override
	public int updateObjects(Objects bean) throws Exception {
		// TODO Auto-generated method stub
		return objectDao.updateObjects(bean);
	}

	@Override
	public boolean delObjects(int oid) throws Exception {
		// TODO Auto-generated method stub
		return objectDao.delObjects(oid);
	}

	@Override
	public Objects getObjects(int oid) throws Exception {
		// TODO Auto-generated method stub
	return objectDao.getObjects(oid);
	}

	@Override
	public List ListObjects() throws Exception {
		// TODO Auto-generated method stub
		return objectDao.ListObjects();
	}

	@Override
	public Objects findObjectsByID(int id) throws Exception {
		// TODO Auto-generated method stub
		return objectDao.findObjectsByID(id);
	}

	@Override
	public Objects findPublishedObjectsByID(int ID) throws Exception {
		// TODO Auto-generated method stub
		return objectDao.findPublishedObjectsByID(ID);
	}

	@Override
	public int getCount(int oid) throws Exception {
		// TODO Auto-generated method stub
		return objectDao.getCount(oid);
	}

}

package service;

import java.sql.SQLException;
import java.util.List;

import entity.Objects;

public interface ObjectsService {
	public int intsertObjects(Objects object) throws SQLException;
	public  int updateObjects(Objects bean)throws Exception;
	public  boolean delObjects(int oid) throws Exception;
	public  Objects getObjects(int oid)throws Exception ;
	public  List ListObjects() throws Exception;
	public  Objects findObjectsByID(int id) throws Exception;
	public  Objects findPublishedObjectsByID(int ID)throws Exception;
	public  int getCount(int oid) throws Exception ;
		// TODO Auto-generated method stub
		
	

}

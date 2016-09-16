package test;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import service.AdminService;
import service.impl.AdminServiceImpl;

public class DaoTest {
	
		//public static void main(String[] args) throws Exception {
			//AdminDao测试
		
			public static void main(String[] args) throws Exception {
				AdminDao adminDao=new AdminDaoImpl();
				//adminDao.updatePassword("admin", "123456");
					System.out.println(adminDao.getOldPsw("admin"));
					System.out.println(adminDao.login("admin", "123456").getUsername());
					adminDao.login("admin", "123456").getUsername();
				
			}
		//println(objectsDao.getObjects(21).getTitle());
		
			//object 测试
			//ObjectsDao objectsDao=new ObjectsDao();
			//objectsDao.getObjects(2).getTitle();
			/*Objects objects=new Objects();
			objects.setOid(22);
			objects.setTitle("为何大学僧都那么复杂哦");
			objects.setState(1);
			objects.setDiscribe("恢复世界法师铠甲");
			objects.setRemark("jssjflsljk");*/
			/*objects.setCreateTime();*/
			//objects.setAnonymousFlag("0");
		//	objectsDao.intsertObjects(objects);
		    //objectsDao.delObjects(23);
		  // System.out.println(objectsDao.ListObjects()); 
			//QuestionDao questionDao=new QuestionDaoImpl();
		//System.out.println(questionDao.listQuesByOid(22));
		//questionDao.listQuesByOid(21);
			//questionDao.addQues(22, "abcd", 1,1 );
		//	AdminService adminService=new AdminServiceImpl();
			//System.out.println(adminService.getOldPsw("admin"));
			
			
		}


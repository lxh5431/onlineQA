package test;

import service.QuestionService;
import service.ReplayService;
import service.impl.QuestionServiceImpl;
import service.impl.ReplayServiceImpl;

public class DaoTest {
	
		//public static void main(String[] args) throws Exception {
			//AdminDao����
		
			public static void main(String[] args) throws Exception {
				/*AdminDao adminDao=new AdminDaoImpl();
				//adminDao.updatePassword("admin", "123456");
					System.out.println(adminDao.getOldPsw("admin"));
					System.out.println(adminDao.login("admin", "123456").getUsername());
					adminDao.login("admin", "123456").getUsername();*/
					/*ObjectsDao obDao=new ObjectsDaoImpl();
					System.out.println(obDao.ListObjects());
					System.out.println(obDao.findObjectsByID(22));
					*/
					
					QuestionService qs = new QuestionServiceImpl();
					 ReplayService	replayService=new ReplayServiceImpl();
					 replayService.getAllAnswer(21);
					
				
			}
		//println(objectsDao.getObjects(21).getTitle());
		
			//object ����
			
			//objectsDao.getObjects(2).getTitle();
			/*Objects objects=new Objects();
			objects.setOid(22);
			objects.setTitle("Ϊ�δ�ѧɮ����ô����Ŷ");
			objects.setState(1);
			objects.setDiscribe("�ָ����編ʦ����");
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


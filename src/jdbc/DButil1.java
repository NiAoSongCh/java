package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import Dao.DBUtil;

public class DButil1 {
	private static String url;
	private static String user;
	private static String password;
	private static String driver;
	public static void init(){
		//Properties����properties�����ļ��Ĺ�����
		Properties pro=new Properties();
		//����src��Ŀ¼�µ��ļ�
		InputStream in = DButil1.class.getClassLoader().getResourceAsStream("db.properties");
//		����DBUtil���ڰ��µ��ļ�
//		inputstream in = DBUtil.class.getResourceAsStream(db.properties);
		//new FileInputStream("�ļ���")��������Ŀ��Ŀ¼�µ��ļ�
		//InputStream in=new FileInputStream("db.properties");
		//��Properties������ֽ�����������
		try {
			pro.load(in);
			//Properties.getProperty(key):vgalue
			url=pro.getProperty(url);
			user=pro.getProperty(user);
			password=pro.getProperty(password);
			driver=pro.getProperty(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
		
	}

}

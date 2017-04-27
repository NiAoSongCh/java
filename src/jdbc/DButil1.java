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
		//Properties加载properties配置文件的工具类
		Properties pro=new Properties();
		//加载src根目录下的文件
		InputStream in = DButil1.class.getClassLoader().getResourceAsStream("db.properties");
//		加载DBUtil所在包下的文件
//		inputstream in = DBUtil.class.getResourceAsStream(db.properties);
		//new FileInputStream("文件名")：加载项目根目录下的文件
		//InputStream in=new FileInputStream("db.properties");
		//把Properties对象和字节输入流关联
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

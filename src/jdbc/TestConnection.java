package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
	private static final String url="jdbc:mysql://127.0.0.1:3306/txt";
	private static final String user="root";
	private static final String password="root";
	private static final String driver="com.mysql.jdbc.Driver";
	
	public static Connection getConnection(){
		//Connection对象：数据库连接对象
		 Connection conn=null;
		 try {
			//1.加载驱动
			Class.forName(driver);
			//2.通过DriverManager(驱动管理器)获取连接(Connection)
			conn=DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return conn;
		
	}
		public static void main(String[] args) {
			System.out.println(getConnection());
		}

}

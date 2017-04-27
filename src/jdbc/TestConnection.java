package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
	private static final String url="jdbc:mysql://127.0.0.1:3306/txt";
	private static final String user="root";
	private static final String password="root";
	private static final String driver="com.mysql.jdbc.Driver";
	
	public static Connection getConnection(){
		//Connection�������ݿ����Ӷ���
		 Connection conn=null;
		 try {
			//1.��������
			Class.forName(driver);
			//2.ͨ��DriverManager(����������)��ȡ����(Connection)
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

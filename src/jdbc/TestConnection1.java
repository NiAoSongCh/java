package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestConnection1 {
	private static final String url = "jdbc:mysql://127.0.0.1:3306/txt"
			+ "?useUnicode=true&characterEncoding=utf8";
	private static final String user = "root";
	private static final String password = "root";
	private static final String driver = "com.mysql.jdbc.Driver";

	public static void insert() {
		Connection conn = null;
		Statement sta = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			// 通过Connection获取Statement
			sta = conn.createStatement();
			StringBuffer sql = new StringBuffer("insert into dog values(null,'");
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入宠物昵称：");
			String name = sc.next();
			sql.append(name + "',");
			System.out.println("请输入健康值：");
			int health = sc.nextInt();
			sql.append(health + ",");
			System.out.println("请输入可爱值：");
			int love = sc.nextInt();
			sql.append(love + ",'");
			System.out.println("请输入品种：");
			String strain = sc.next();
			sql.append(strain + "')");
			System.out.println(sql);
			// execute:执行
			// update:更新
			// query:查询
			int result = sta.executeUpdate(sql.toString());
			System.out.println(result);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void delete(){
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url, user, password);
			String sql="delete from dog where id in(?);";
			//创建PreparedStatement要传sql
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setInt(1, 4);
			//给占位符赋值
			//pstmt.setXXX(从1开头,值);
			//执行的时候不传sql
			int result=pre.executeUpdate();
			System.out.println(result);
			
					} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	
		public static void login(){
			try {
				Class.forName(driver);
				Connection conn=DriverManager.getConnection(url, user, password);
				Statement sta=conn.createStatement();
				Scanner sc=new Scanner(System.in);
				StringBuffer sql=new StringBuffer("select * from master"+" where name= '");
				System.out.println("请输入用户名：");
				String name=sc.next();
				sql.append(name+"'and password='");
				System.out.println("请输入密码：");
				String password=sc.next();
				sql.append(password+"'");
				System.out.println(sql);
				ResultSet rs=sta.executeQuery(sql.toString());
				if(rs.next()){
					System.out.println("登录成功");
					
				}else{
					System.out.println("登录失败！！");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
			
			
		}

	public static void select() {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stat = conn.createStatement();
			String sql = "select * from dog;";
			// ResultSet:封装查询的结果，本质是一个多行的二维表
			// 查询：executeQuery
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString("name")
						+ "\t" + rs.getInt(3) + "\t" + rs.getInt(4) + "\t"
						+ rs.getString(5));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public static void closeAll(Connection conn,Statement sta,ResultSet rs){
			
			try {
				if (rs!=null) {
					rs.close();
				}
				if (sta!=null) {
					sta.close();
				}
				if (conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		public static Connection getConnection(){
			Connection conn=null;
			try {
				Class.forName(driver);
				conn=DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
			
		}
		/**
		 * 通用增删改
		 * @param args
		 */
		public static int generalUpdate(String sql,Object...params){
			int result=-1;
			Connection conn=null;
			PreparedStatement pre=null;
			
			try {
				conn=getConnection();
				pre=conn.prepareStatement(sql);
				//给每个占位符赋值
				for (int i = 0; i < params.length; i++) {
					pre.setObject(i+1, params[i]);
				}
				result=pre.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeAll(conn, pre, null);
				
			}
			return result;
			
			
		}
		public static void update(){
			//给形参赋值
			String sql="update dog set name=? where name=?;";
			Object[]params={"大色狗","5"};
			int result=generalUpdate(sql, params);
			if (result!=-1) {
				System.out.println("修改成功");
			}
			
			
		}
		
		
		
	public static void main(String[] args) {
//		insert();
//		select();
		login();
//		delete();
//		update();
	}
}

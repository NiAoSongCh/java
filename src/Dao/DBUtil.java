package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Master;


/**
 * 
 * @author NAS
 * DBUtil:JDBC������:
 * 1.���ݿ�����
 * 2.�رո�����Դ
 * 3.ͨ�õ���ɾ��
 * 4.ͨ�ò�ѯ
 *
 */

public class DBUtil {
			private static final String url="jdbc:mysql://127.0.0.1:3306/txt"+
							"?useUnicode=true&characterEncoding=utf8";
			private static final String user="root";
			private static final String password="root";
			private static final String  driver="com.mysql.jdbc.Driver";
		/**
		 * ��ȡ����
		 * 
		 */
			//�÷����в�Ҫ�ر����ӣ���ҵ�����/��ɾ�Ĳ����йر�����
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
			 * �رո�����Դ
			 */
			
			public static void closeAll(Connection conn,PreparedStatement pst,ResultSet rs){
						try {
							if (rs!=null) {
								rs.close();
							}
							if(pst!=null){
								pst.close();
							}
							if(conn!=null){
								conn.close();
							}
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
			}
			/**
			 * ͨ����ɾ��
			 */
			//params:ռλ��ֵ��ֵ����
			public static int generalUpdate(String sql,Object... params){
					int result=-1;
					Connection conn=null;
					PreparedStatement pst=null;
					try {
						conn=getConnection();
						pst=conn.prepareStatement(sql);
						for (int i = 0; i < params.length; i++) {
							pst.setObject(i+1, params[i]);
						}
						//executeUpdate����ɾ�ģ�:������Ӱ��ļ�¼�� 
						result=pst.executeUpdate();
						
					} catch (Exception e) {
						// TODO: handle exception
					}finally{
						closeAll(conn, pst, null);
					
					}
					
					return result;
			}
			
			/**
			 * ͨ�ò�ѯ
			 * @throws SQLException 
			 */
			public static Master generalselect(String sql,Object...params) {
				Connection conn=null;
				PreparedStatement pre=null;
				ResultSet rs=null;
				Master master=new Master();
				try {
					conn=getConnection();
					pre=conn.prepareStatement(sql);
					for (int i = 0; i < params.length; i++) {
						pre.setObject(i+1, params[i]);
					}
					rs=pre.executeQuery();
					if (rs.next()) {
						master.setId(rs.getInt(1));
						master.setName(rs.getString(2));
						master.setPassword(rs.getString(3));
						
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally{
					closeAll(conn, pre, rs);
					
				}
				
				return master;   
				
			}
			public static List<Master> generalSelect(String sql,Object...params){
				List<Master> list=new ArrayList<Master>();
				Connection conn=null;
				PreparedStatement pre=null;
				ResultSet rs=null;
				Master master=null;
				try {
					conn=getConnection();
					pre=conn.prepareStatement(sql);
					if (params!=null) {
							for (int i = 0; i < params.length; i++) {
								pre.setObject(1, params[i]);
							}
					}
					rs=pre.executeQuery();
					while(rs.next()){
						master=new Master();
						master.setId(rs.getInt(1));
						master.setName(rs.getString(2));
						master.setPassword(rs.getString(3));
						list.add(master);
						
					}
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					closeAll(conn, pre, rs);
				}
			
			
				
			
			
			return list;
			
			
			
			
		}
			
			
			
			
}

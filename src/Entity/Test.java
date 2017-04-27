package Entity;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dao.DBUtil;

public class Test {
			public static void testUpdate(){
//			System.out.println(DBUtil.getConnection());
				
				String sql="insert into master values(null,?,?)";
				Scanner sc=new Scanner(System.in);
				System.out.println("«Î ‰»Î–’√˚£∫");
				String name= sc.next();
				System.out.println("«Î ‰»Î√‹¬Î£∫");
				String password=sc.next();
				Object [] params={name,password};
				int result=DBUtil.generalUpdate(sql, params);
				if (result!=-1) {
					System.out.println("OK");
				}else{
					System.out.println("µ«¬º ß∞‹£°£°£°");
				}
			
			}
			public static void testselect(){
				String sql="select * from master where name=? and password =?";
				Object [] params={"kk","55"};
				Master ms=DBUtil.generalselect(sql, params);
				System.out.println(ms.getName());
				
			}
			
		
			
			
			
			
			private static Connection getConnection() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public static void testSelect1(){
				
				String sql="select * from master";
				List<Master> list=DBUtil.generalSelect(sql, null);
				for (Master master : list) {
					System.out.println(master.getName());
					System.out.println(master.getPassword());
					System.out.println(master.getPassword());
					
				}
			}
			
			
			
			
			public static void main(String[] args) {
//				testUpdate();
				testSelect1();
				
				
			}

}

package python;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB{
    public static int getProgress1() {
    	 try {
             Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
          }catch (Exception e) {
             System.out.print("����MySQL��������!");
         }
    	 
    	 try {
    		 //�������ݿ�
//	 		 Connection connect = DriverManager.getConnection("jdbc:mysql://120.77.201.150:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","765885195");
	 		 Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","765885195");

	 		 PreparedStatement Statement=connect.prepareStatement("select count(*) as num from a");
		     ResultSet set= Statement.executeQuery();//ִ���ѷ��͵�Ԥ�����sql
		     int num = 0;
		     while (set.next()) {
		    	 num = set.getInt("num");
		     }
		     connect.close();
		     return num;
    	 }catch(SQLException e){
    		 System.out.print("��ȡ���ݴ���");
         }
    	 return 0;
      }
    public static int getProgress2() {
   	 try {
            Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
         }catch (Exception e) {
            System.out.print("����MySQL��������!");
        }
   	 
   	 try {
   		 //�������ݿ�
//	 		 Connection connect = DriverManager.getConnection("jdbc:mysql://120.77.201.150:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","765885195");
	 		 Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","765885195");

	 		 PreparedStatement Statement=connect.prepareStatement("select count(1) as num from b");
		     ResultSet set= Statement.executeQuery();//ִ���ѷ��͵�Ԥ�����sql
		     int num = 0;
		     while (set.next()) {
		    	 num = set.getInt("num");
		     }
		     connect.close();

		     return num;
   	 }catch(SQLException e){
   		 System.out.print("��ȡ���ݴ���");
        }
   	 return 0;
     }
    public static void insert() {
   	 try {
            Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
         }catch (Exception e) {
            System.out.print("����MySQL��������!");
        }
   	 
   	 try {
// 		 Connection connect = DriverManager.getConnection("jdbc:mysql://120.77.201.150:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","765885195");
   		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","765885195");

   		 PreparedStatement Statement = null;
   		 
 		 for(int i=0 ; i< 1 ; i++){
 			 Statement=connect.prepareStatement("INSERT INTO a VALUES(100)");
 			 Statement.executeUpdate();
 			 Statement=connect.prepareStatement("INSERT INTO b VALUES(100)");
 			 Statement.executeUpdate();
 		 }
 		 connect.close();
   	 	}catch(SQLException e){
   			System.out.println(e.getErrorCode());
   	 	}
     }
}
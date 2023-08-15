package test;
import java.sql.*;
public class DBConnection {
		private static Connection con=null;
		private DBConnection()
		{
			
		}
		static 
		{
		 try
		 {
			 System.out.println("conn");
			 
			Class.forName("oracle.jdbc.driver.OracleDriver") ;
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","dipak","dipak");
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		}
		public static Connection getCon()
		{
			return con;
		}
}

package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlCon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/student","root","root");  
			
			//here student is database name, root is username and password: root
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from studentdata");  
			while(rs.next())  {
				
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4));  
			}
			con.close();  
			}catch(Exception e) { 
				 
				System.out.println(e);
			}  

	}

}
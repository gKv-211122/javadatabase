package transacmang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransMang {
	
	private static Connection con;

	public static Connection setConnection() {
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			
			con = DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Techouts","root","root");  
			
			// here student is database name, root is username and password: root
			System.out.println("Connection Successfuly Established.......");
			
			  
			}catch(Exception e) { 
				 
				System.out.println(e);
			}
		
		return con;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			TransMang.setConnection();
			
			con.setAutoCommit(true);
			
			Statement stmt=con.createStatement();  
			stmt.executeUpdate("insert into details values(192, 'abhinav', 'Mumbai')");  
			stmt.executeUpdate("insert into details values(193, 'umaa', 'Delhi')");  
			
//			con.commit();  
//			con.close();  
			
		} catch(Exception e) {
			
			System.out.println(e);
		}
		

	}

}

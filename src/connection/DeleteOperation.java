package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Connection con = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/student","root","root"); 
			
			Statement stmt1 = con.createStatement(); 
			String query = "delete from studentdata where id=103 ";
		
			
			stmt1.executeUpdate(query);
	        System.out.println("Record is deleted from the table successfully..................");
	        
		}catch(Exception e) {
			System.out.println(e);
			
		}

	}

}

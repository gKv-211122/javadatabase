package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateData {
	
	public static void main(String [] args) {
		
		try {
			Connection con = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/student","root","root"); 
			
			String query = "update studentdata set name=? where id=? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "change name");
			ps.setInt(2, 101);
			
			ps.executeUpdate();
	        System.out.println("Record is updated successfully......");
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
	}
	

}

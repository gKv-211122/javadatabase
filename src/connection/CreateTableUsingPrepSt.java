package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CreateTableUsingPrepSt {
	
	private static Connection con;

	public static Connection setConnection() {
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			
			con = DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/funapplication","root","root");  
			
			// here student is database name, root is username and password: root
			System.out.println("Connection Successfuly Established.......");
			
			  
			}catch(Exception e) { 
				 
				System.out.println(e);
			}
		return con;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		try {
			CreateTableUsingPrepSt.setConnection();
			
//			PreparedStatement pstmt = con.prepareStatement("create table details (id int, name VARCHAR(30) , location VARCHAR(50));");
//			pstmt.execute();
//			System.out.println("Table is create Successfully.....");
			
			String query = "INSERT INTO details (id, name, location)" + "VALUES (?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, 1396);
			pstmt.setString(2, "golu");
			pstmt.setString(3, "Hydarabad");
			pstmt.execute();
			
			System.out.println("Data Successfully Inserted.....");
			
			
			/** read data */
			// String readQuery = "select * from details";
			PreparedStatement pstmtr = con.prepareStatement("select * from details");
			
			ResultSet rs=pstmtr.executeQuery();  
			
			while(rs.next())  {
				
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			}
			
			// pstmt.executeUpdate();
			
//			System.out.println("Enter Your id: ");
//			int id = sc.nextInt();
//			
//			String queryDel = "delete from details where id='" + id + "'";
//			PreparedStatement pstmt1 = con.prepareStatement(queryDel);
//			pstmt1.execute();
//			
//			System.out.println("Deleted Successfully.....");
			
			
			
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
		
		
		
	}

}
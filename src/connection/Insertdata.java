package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Insertdata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			
			Connection con = DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/student","root","root");  
			
			//here student is database name, root is username and password: root
			Statement stmt=con.createStatement(); 
			System.out.println("Enter id: ");
			int id = sc.nextInt();
			long unsigned = id;
			
			System.out.println("Enter Name: ");
			String name = sc.next();
			
			System.out.println("Enter location: ");
			String lo = sc.next();
			
			System.out.println("Enter post: ");
			String post = sc.next();
			
			String query1 = "INSERT INTO studentdata " + "VALUES ('" + id + "','" + name + "','" + lo + "','" + post + "')";
		    stmt.executeUpdate(query1);
		    
		    query1 = "INSERT INTO studentdata " + "VALUES (106, 'EEE', 'Hydarbad', 'datascience')";
		    stmt.executeUpdate(query1);
		    
		    System.out.println("data is inserted successfully......");
			
		}catch(Exception e) {
			
			System.out.println(e);
			
		}

	}

}

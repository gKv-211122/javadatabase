package connection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CreateDbUsingPreSt {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			
			con = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Techouts","root","root");  
			
//			String dbName = "Techouts";
//			Statement createDbStatement = con.createStatement();
//			createDbStatement.execute("CREATE DATABASE " + dbName);
//			
//			System.out.println("Database, "+dbName+" Successfully Created...");
			
			Statement createTableStatement=con.createStatement();
			
			String query = "CREATE TABLE EMPLOYEE"
		            + "("
		            + " ID serial,"
		            + " NAME varchar(100) NOT NULL,"
		            + " SALARY numeric(15, 2) NOT NULL "
		            + ")";
			
			createTableStatement.execute(query);
			
			System.out.println("Table is created successfully");
			
			createTableStatement.close();
		    con.close();
			
			
			//connection.commit();
		}catch(Exception e) {
			
			System.out.println(e);
		}
		

	}

}

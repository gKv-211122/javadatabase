package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CheckCredentials {
	
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
			CheckCredentials.setConnection();

			System.out.println("Enter Your id: ");
			int id = sc.nextInt();
			System.out.println("Enter user name: ");
			String uname = sc.next();
			System.out.println("Enter password: ");
			String psw = sc.next();
			sc.close();
			
			// add another row in database, using preparedStatement
//			String query1 = "INSERT INTO loginpage " + "VALUES (106, 'email13@gmail.com', 'user', 'pass')";
//			PreparedStatement ps1 = con.prepareStatement(query1);
//			ps1.executeUpdate();
			
//			
			String query2 = "INSERT INTO loginpage (id, email, uname, psw)" + "VALUES (?, ?, ?, ?)";
			PreparedStatement ps2 = con.prepareStatement(query2);
			ps2.setInt(1, 1344);
			ps2.setString(2, "abc123@gmail.com");
			ps2.setString(3, "abcd");
			ps2.setString(4, "ps123454");
			ps2.execute();
			
			String queryDel = "delete from loginpage where id=106 ";
			PreparedStatement psDel = con.prepareStatement(queryDel);
			psDel.execute();
			
			
			// login
			String query = "select uname, psw from loginpage where Id = '" + id + "'";
			PreparedStatement ps = con.prepareStatement(query);

			
			ResultSet rs=ps.executeQuery();  
			System.out.println("Query is excecuted successfully.....");
			
			while(rs.next())  {
				
				//System.out.println(rs.getString(1)+"  "+rs.getString(2)); 
				if(rs.getString(1).equals(uname) && rs.getString(2).equals(psw)) {
					
					System.out.println("You are Successfully Logined....");
				}else {
					System.out.println("Invalid Credentials !!!! ....");
				}
			}
			con.close();
			
			
		
			
			
			
		}catch(Exception e) {
			
			System.out.println(e);
			
		}

	}

}

package transacmang;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransMangPrepSt {
	
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
			TransMangPrepSt.setConnection();
			
			con.setAutoCommit(false);  
			  
			PreparedStatement ps = con.prepareStatement("insert into details values(?, ?, ?)");  
			  
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
			
			while(true) {  
			  
				System.out.println("enter id: ");  
				String s1 = br.readLine();  
				int id=Integer.parseInt(s1);  
			  
				System.out.println("enter name: ");  
				String name = br.readLine();  
			  
				System.out.println("enter location: ");  
				String location = br.readLine();  
				 
			  
				ps.setInt(1,id);  
				ps.setString(2,name);  
				ps.setString(3,location);  
				ps.executeUpdate();  
			  
				System.out.println("Enter , commit/rollback");  
				String answer=br.readLine();  
				
				if(answer.equals("commit")){  
					con.commit();  // successful
				}  
				if(answer.equals("rollback")){  
					con.rollback();  // Failed
				}  
			  
			  
				System.out.println("Want to add more records y/n");  
				String ans=br.readLine();  
				
				if(ans.equals("n")){  
					break;  
				}  
			  
			}  
			
			con.commit();  
			System.out.println("record successfully saved");  
			  
			con.close();//before closing connection commit() is called  
			}catch(Exception e) {
				
				System.out.println(e);
				
			}  
			
		
	}

}

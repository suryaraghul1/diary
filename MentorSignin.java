package diary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MentorSignin {
	static void mentorsignin() throws ClassNotFoundException, SQLException, IOException                                                          
     {    	  
     System.out.println("--SIGNIN--");              
     Scanner e=new Scanner(System.in);                                                                                                                  
     System.out.println("ENTER THE MENTOR NUMBER");                                                                                                     
     String a=e.nextLine();                                                                                                                                
     System.out.println("ENTER THE PASSWORD");                                      
     String b=e.nextLine();  
     Connection con = null;
     PreparedStatement pstmt = null;
     ResultSet rs = null;
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager. getConnection("jdbc:mysql://localhost/surya?useSSL=true","root","surya");
     String query = "SELECT * FROM mentor";
     pstmt = con.prepareStatement(query);
     rs = pstmt.executeQuery();
     Signup obj=new Signup();
     int s=0;
     String a1="",b1="";  
     while(rs.next()) {
     a1= rs.getString("mentorid");
     b1 =rs.getString("password");
     if(a.equals(a1) && b.equals(b1))
     {
     obj.setNam(rs.getString("username"));
      s++;
      DashboardMentor.mentorpage(); 
     }
     } 
     if(s==0)
     {
     System.out.print("Try again");
     mentorsignin();
     }
    
     rs.close();
     pstmt.close();
     con.close();
     
     } 

}

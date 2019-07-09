package diary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MentorFees {
	 static void page3() throws SQLException, ClassNotFoundException, IOException
     {
     	System.out.println("                          ________________________");  
     	System.out.println("                         |         FEES           |"); 
     	System.out.println("                         |________________________|");
     	System.out.println(" ");
     	fees();
     }
     	
     static void fees() throws SQLException, ClassNotFoundException, IOException
     {   
     
    	 Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager. getConnection("jdbc:mysql://localhost/surya?useSSL=true","root","surya");
  
     	String query1 = "insert into fees(rollnumber,data,fees,pending)values (?,?,?,?)";
     	pstmt = con.prepareStatement(query1,Statement.RETURN_GENERATED_KEYS);
     	Signup obj=new Signup();
        String str=obj.getRno();
     	pstmt.setString(1,str); 
     	java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());	
     	pstmt.setDate(2, sqlDate);
     	System.out.println("UPDATE UPCOMING FEES");
     	System.out.println("-------------------- ");
     	Scanner w=new Scanner(System.in);
     	String right=w.nextLine();
     	pstmt.setString(3,right);
     	System.out.println("UPDATE PENDING FEES");
     	System.out.println("-------------------- ");
     	String right1=w.nextLine();
     	pstmt.setString(4,right1);
     	 pstmt.executeUpdate();
     	 rs = pstmt.getGeneratedKeys();
     	  rs.close();
     	  pstmt.close();
     	  con.close();   
     	  staythree();
   
     }
     	 static void staythree() throws ClassNotFoundException, SQLException, IOException
     	 {

     	 System.out.println("ENTER(1)FOR CHAT SECTION||(2)FOR NEXT STUDENT DASHBOARD");
     	 System.out.println("-------------------------------------------------------");
     	 Scanner h=new Scanner(System.in);
     	 int q1=h.nextInt();
     	 if(q1==1)
     	 {
     	 MentorReply.clear();
     	 }
     	 else if(q1==2)
     	 {
     	  DashboardMentor.studententry();
     	 }
     	 else
     	 {
     	   staythree();
     	 }
     	 }
}

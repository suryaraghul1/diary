package diary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MentorAttendence {
	  static void page() throws ClassNotFoundException, SQLException, IOException
     {
     	System.out.println("                          ________________________ ");     
     	System.out.println("                         |                        |");
     	System.out.println("                         |       ATTENDENCE       |"); 
     	System.out.println("                         |________________________|");
     	System.out.println(" ");
     	present();
     }
     static void present() throws ClassNotFoundException, SQLException, IOException
     { 
     Connection con = null;
     PreparedStatement pstmt = null;
     ResultSet rs = null;
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager. getConnection("jdbc:mysql://localhost/surya?useSSL=true","root","surya");

     System.out.println("ENTER (1) FOR  PRESENT ||ENTER (2) FOR ABSENT");
     System.out.println("---------------------------------------------");
     System.out.println(" ");
     String query1 = "insert into attendence(rollnumber,attend,data,percentage)values (?,?,?,?)";
     pstmt = con.prepareStatement(query1,Statement.RETURN_GENERATED_KEYS);
     Signup obj=new Signup();
     String str=obj.getRno();
     pstmt.setString(1,str);
     Scanner a1=new Scanner(System.in);
     int s1=a1.nextInt();
     if(s1==1)
     {   

     pstmt.setString(2,"Present"); 
     java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());	
     pstmt.setDate(3, sqlDate);
     }
     else if(s1==2)
     {
     pstmt.setString(2,"Absent");    
     java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());	
     pstmt.setDate(3, sqlDate);
     }

     System.out.println("ENTER THE PERCENTAGE");
     System.out.println("--------------------");
     System.out.println(" ");
     int s2=a1.nextInt();
     pstmt.setInt(4,s2);       

     pstmt.executeUpdate();
     rs = pstmt.getGeneratedKeys();
     rs.close();
     pstmt.close();
     con.close();   
     stay();
     }
    
    static void stay() throws ClassNotFoundException, SQLException, IOException
    {

    System.out.println("ENTER(1)FOR UPDATE HOMEWORK ||ENTER(2)FOR NEXT STUDENT DASHBOARD");
    System.out.println("----------------------------------------------------------------");
    Scanner h=new Scanner(System.in);
    int q1=h.nextInt();
    if(q1==1)
    {
     MentorHomework.page1();
    }
    else if(q1==2)
    {
     DashboardMentor.studententry();
    }
    else
    {
    stay();
    }
    }
}
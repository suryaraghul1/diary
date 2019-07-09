package diary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MentorTest {
	 static void page2() throws SQLException, ClassNotFoundException, IOException
     {
     	System.out.println("                          ________________________");  
     	System.out.println("                         |         TEST           |"); 
     	System.out.println("                         |________________________|");
     	System.out.println(" ");
     	test();
     }
    static void test() throws SQLException, ClassNotFoundException, IOException
     {

     Connection con = null;
     PreparedStatement pstmt = null;
     ResultSet rs = null;
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager. getConnection("jdbc:mysql://localhost/surya?useSSL=true","root","surya");
    
     	String query1 = "insert into test(rollnumber,data,tamil,english,maths)values (?,?,?,?,?)";
     	pstmt = con.prepareStatement(query1,Statement.RETURN_GENERATED_KEYS);
     	Signup obj=new Signup();
        String str=obj.getRno();
     	pstmt.setString(1,str);
     System.out.println("UPDATE UPCOMING TEST");
     System.out.println("-------------------- ");
     java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());	
      pstmt.setDate(2, sqlDate);
     Scanner w=new Scanner(System.in);
     System.out.println("Tamil");
     System.out.println("-----");
     String right=w.nextLine();
     pstmt.setString(3,right);
     System.out.println("English");
     System.out.println("-------");
     String right1=w.nextLine();
     pstmt.setString(4,right1);
     System.out.println("Maths");
     System.out.println("-----");
     String right2=w.nextLine();	
     pstmt.setString(5,right2);
     pstmt.executeUpdate();
     rs = pstmt.getGeneratedKeys();
      rs.close();
      pstmt.close();
      con.close();   
      staytwo();
     
     }
     static void staytwo() throws ClassNotFoundException, SQLException, IOException
     {

     System.out.println("ENTER(1)FOR UPDATE FEES ||ENTER(2)FOR NEXT STUDENT DASHBOARD");
     System.out.println("----------------------------------------------------------");
     Scanner h=new Scanner(System.in);
     int q1=h.nextInt();
     if(q1==1)
     {
     	MentorFees.page3();
     }
     else if(q1==2)
     {
     DashboardMentor.studententry();
     }
     else
     {
       staytwo();
     }
     }
}

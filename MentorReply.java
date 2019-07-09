package diary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MentorReply {
	
static void clear() throws ClassNotFoundException, SQLException, IOException
{
	System.out.println("                          ________________________ ");     
    System.out.println("                         |                        |");
	System.out.println("                         |           Chat         |"); 
	System.out.println("                         |________________________|");
	System.out.println(" ");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager. getConnection("jdbc:mysql://localhost/surya?useSSL=true","root","surya");
	String query4 = "SELECT * FROM doubt";
	pstmt = con.prepareStatement(query4);
	rs = pstmt.executeQuery();
	 Signup obj=new Signup();
     String str=obj.getRno();
	 while(rs.next()) 
	 {	 
	    if(str.equals(rs.getString("rollnumber")))
	    {
	     System.out.println(" ");
	     System.out.println("parent:"+rs.getString("ask")+"["+rs.getDate("date")+"]");
	     System.out.println(" ");
	     System.out.println("you:"+rs.getString("clear"));
	    }
     }
	 
	    rs.close();
	    pstmt.close();
	 	con.close();	
	   reply();
	 }

static void reply() throws SQLException, ClassNotFoundException, IOException
{
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager. getConnection("jdbc:mysql://localhost/surya?useSSL=true","root","surya");
	String query1 = "insert into doubt(rollnumber,date,ask,clear)values (?,?,?,?)";
 	pstmt = con.prepareStatement(query1,Statement.RETURN_GENERATED_KEYS);
 	Scanner d=new Scanner(System.in);
 	 Signup obj=new Signup();
     String str=obj.getRno();
 	pstmt.setString(1,str); 
 	java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());	
 	pstmt.setDate(2, sqlDate);
	String doubt=d.nextLine();
	String h="";
  	pstmt.setString(3,h);
  	pstmt.setString(4,doubt);
  	 pstmt.executeUpdate();
 	 rs = pstmt.getGeneratedKeys();
 	 rs.close();
 	 pstmt.close();
     con.close();   
     System.out.println("ENTER(1)FOR NEXT STUDENT DASBOARD");
     Scanner l=new Scanner(System.in);
	 int k=l.nextInt();
	   if(k==1)
	   {
		  DashboardMentor.studententry(); 
       }
	  else
	   {
		  DashboardMentor.studententry(); 
	   }
}

}

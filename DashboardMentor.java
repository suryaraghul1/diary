package diary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DashboardMentor {
static void mentorpage() throws ClassNotFoundException, SQLException, IOException
     { 
     System.out.println("                                  _____________  "); 
     System.out.println("                                 |             | ");   
     System.out.println("                                 | MENTOR PAGE |  "); 
     System.out.println("                                 |_____________| ");
     Signup obj=new Signup();
	 System.out.println("HI "+obj.getNam());
	 studententry();
     }
	 static void studententry() throws ClassNotFoundException, SQLException, IOException
	 {
	 Connection con = null;
     PreparedStatement pstmt = null;
     ResultSet rs = null;
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager. getConnection("jdbc:mysql://localhost/surya?useSSL=true","root","surya");
     System.out.println("ENTER THE STUDENT ROLLNUMBER");
     int count = 0,c1=0;
     Scanner f=new Scanner(System.in);	 

     String str=f.nextLine();
     for (int i = 0; i < str.length(); i++) { 
     char ch = str.charAt(i); 
     if (ch >= '0' && ch <= '9')  
     {  
     count++;
     }
     else
     {
     System.out.println("ENTER THE CORRECT STUDENT ROLLNUMBER");   
     studententry();
     break;
     }
     }
     if(count==str.length())
     { 
     String query = "SELECT * FROM parent";
     pstmt = con.prepareStatement(query);
     rs = pstmt.executeQuery();
     Signup obj=new Signup();
     String a=null; 
     while(rs.next()) 
     {
     a= rs.getString("rollnumber");
     if(str.equals(a))
     {
     c1++;
 	 obj.setRno(str);
 	 System.out.println("STUDENT DETAIL");
	 System.out.println("--------------");
     System.out.println("Name  :"+rs.getString("name")); 
     System.out.println("CLASS :"+rs.getString("cls")+"std");
     System.out.println("SCHOOL:"+rs.getString("School"));
     System.out.println(" ");
     break;
     }
     else
     {
     System.out.println("INVALID ROLLNUMBER");
     studententry();
     break;
     }
     }	
     if(c1==1)
     {
     System.out.println("                                                      [*]CLEAR Doubt press(0)");
     System.out.println(" ");
     System.out.println("                            ___________________________ "); 
     System.out.println("                           |                           |");
     System.out.println("                           |     STUDENT DASHBOARD     |"); 
     System.out.println("                           |___________________________|"); 
                                       
      try{Thread.sleep(300);}catch(InterruptedException e1){System.out.println(e1);}  
     System.out.println(" ________________________                              ________________________ ");     
     System.out.println("|                        |                            |                        |");
     System.out.println("|                        |                            |                        |");
     System.out.println("|Press (1) For ATTENDENCE|                            | Press (2) For HOMEWORK |"); 
     System.out.println("|                        |                            |                        |");
     System.out.println("|________________________|                            |________________________|");   
     try{Thread.sleep(500);}catch(InterruptedException e1){System.out.println(e1);}  	  
     System.out.println(" ________________________                              ________________________ ");  
     System.out.println("|                        |                            |                        |");
     System.out.println("|                        |                            |   Press (4) For FEES   |"); 
     System.out.println("|   Press (3) For TEST   |                            |         Details        |"); 
     System.out.println("|                        |                            |                        |");
     System.out.println("|________________________|                            |________________________|");                  
     try{Thread.sleep(300);}catch(InterruptedException e1){System.out.println(e1);}  	  
     System.out.println("                            ___________________________ "); 
     System.out.println("                           |      Press (5) For        |");
     System.out.println("                           |       ADD STUDENTS        |"); 
     System.out.println("                           |_______ ___________________|");
     try{Thread.sleep(300);}catch(InterruptedException e1){System.out.println(e1);}  	  
     System.out.println("              ______________________________________________________ ");
     System.out.println("             |                      Press (6) For                   |"); 
     System.out.println("             |                         LOGOUT                       |");
     System.out.println("             |______________________________________________________|"); 
                                       
     go();
     
     
     }
     }
	 }	 
  
 static  void go() throws ClassNotFoundException, SQLException, IOException
{
Scanner f=new Scanner(System.in);
int i=f.nextInt();
if(i==1)
{
 MentorAttendence.page();
} 
else if(i==2)
{
MentorHomework.page1();
}

else if(i==3)
{
MentorTest.page2();
}

else if(i==4)
{
 MentorFees.page3();
}
else if(i==5)
{
	MentorAdd.page4();
}
else if(i==6)
{
 MentorSignin.mentorsignin();
}
else if(i==0)
{
	MentorReply.clear();
}
else {
System.out.println("PLEASE CHOSE CORRECT OPTION");
go();
}
}
}
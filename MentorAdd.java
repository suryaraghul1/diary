package diary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MentorAdd {
	
static void page4() throws SQLException, ClassNotFoundException, IOException
 {
 	System.out.println("                          ________________________");  
 	System.out.println("                         |       Add STUDENT      |"); 
 	System.out.println("                         |________________________|");
 	System.out.println(" ");
 	username1();     	
 
 }
 static void username1() throws ClassNotFoundException, SQLException, IOException
	 {
		 int count=0,count1=0,count2=0;
	     Signup obj=new Signup();                         
	     Scanner f=new Scanner(System.in);                                                                        
	     System.out.println("ENTER THE STUDENT NAME");  
	     String str=f.nextLine(); 
	     char[] s= str.toCharArray();
	     for (int i = 0; i < s.length; i++) { 
	     if ((s[i] >= 'A' && s[i] <= 'Z') 
	     || (s[i] >= 'a' && s[i] <= 'z'))
	     {
	     count1++;
	     }
	     else if(s[i]==' ')
	     {
	    	 count2++;
	     }
	     else
	     {
	     System.out.println("*use only alpabets");   
	     username1() ;
	     break;
	     }
	     }
	     count=count1+count2;
	     if(count==s.length)
	     {	
	     obj.setUsername(str);
	     rollnumber();
	     
	     }
	     
	 }

   static void  rollnumber() throws ClassNotFoundException, SQLException, IOException
	 {
        Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
    	Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager. getConnection("jdbc:mysql://localhost/surya?useSSL=true","root","surya");
		String query = "SELECT * FROM parent";
	     pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
		 int i,count=0,count1=0;
		 Signup obj=new Signup(); 
	     System.out.println("ENTER THE ROLLNUMBER"); 
	     Scanner m=new Scanner(System.in);
	     String str=m.nextLine(); 
	      String a1="";
	   	 while(rs.next()) {
	 	 a1= rs.getString("rollnumber");
	 	 if(str.equals(a1))
	 	 {
	     count1++;
	     }
	 	 }
	 	 if(count1==0)
	   	{
	     for (i= 0;i <str.length(); i++) 
	     { 
	     char ch1 = str.charAt(i); 
	     if (ch1 >= '0' && ch1 <= '9')  
	     {  
	     count++;
	     }
	     else
	     {
	     System.out.println("*enter number only");   
	     rollnumber();
	     break;
	     } 
	     }
	     if(count==str.length())
	     {
	      obj.setRollnumber(str);
	      phonenumber();
	     }
	 	}
	 	else
	 	 {
	 		System.out.println("*the Rollnumber already taken");
	 		rollnumber();
	 	 }
		rs.close();
		pstmt.close();
		con.close();
	 }
	static void phonenumber() throws ClassNotFoundException, SQLException, IOException
	 {
		 int i,count=0;
		 Signup obj=new Signup(); 
		 Scanner m=new Scanner(System.in);
		 System.out.println("ENTER THE PHONENUMBER");                                                                                                                                                                                    
	     String str=m.nextLine(); 
	     for (i= 0; i< str.length(); i++) { 
	     char ch = str.charAt(i); 
	     
	     if (ch >= '0' && ch <= '9')  
	     {  
	     count++;
	     }
	     else
	     {
	     System.out.println("*enter the valid number");   
	     phonenumber()	;
	     break;
	     }
	     }
	     if(count==10)
	     {
	     obj.setPhonenumber(str);
	     dob();
	     }
	     else
	     {
	     System.out.println("*enter the valid number");   
	     phonenumber();
	     }
	 }
	 static void dob() throws ClassNotFoundException, SQLException, IOException
	{
		int i,count1=0,count2=0,count=0;
		 Signup obj=new Signup(); 
		 Scanner m=new Scanner(System.in);
		 char d='/';
		 System.out.println("ENTER THE STUDENT DOB[dd/MM/YYYY]");   
		 System.out.println("                   ex:03/08/2008");
	     String str=m.nextLine();
	     for (i= 0; i< str.length(); i++)
	       { 
	    	 char ch=str.charAt(i);
		     if (ch >= '0' && ch <= '9')
		     {  
		       count1++;
		     }
		     else if(ch==d)
		     {
		    	 count2++;
		     }
		     else
		     {
		     System.out.println("*wrong formate dob");   
		     dob();
		     break;
		     }
		     }
	         if(count1==8 && count2==2)
		     {
		     obj.setDob(str);
		     school();
		     }
		     else 
		     {
		    System.out.println("*wrong format dob ");   
		     dob(); 
		     }
	}
	     static void school() throws ClassNotFoundException, SQLException, IOException
	  	 {
	    		 int count=0,count1=0,count2=0,count3=0;
	    	     Signup obj=new Signup();                             
	    	     Scanner f=new Scanner(System.in);                                                                        
	    	     System.out.println("ENTER THE SCHOOL NAME");
	    	     String str=f.nextLine();
	    	     char[] s= str.toCharArray();
	    	     for (int i = 0; i < s.length; i++) { 
	    	    if ((s[i] >= 'A' && s[i] <= 'Z') || (s[i] >= 'a' && s[i] <= 'z'))
	    	     {
	    	    count1++;
	    	     }
	  		     else if(s[i]=='.')
	  		     {
		    	 count2++;
		    	 }
	  		   else if(s[i]==' ')
	  		     {
		    	 count3++;
		    	 }
	    	     else
	    	     {
	    	    System.out.println("*enter correct school name");  
	    	    	 school();
	    	    	 break;
	    	     }
	    	    }
	    	    count=count1+count2+count3;
	    	     if(count==s.length)
	    	     {
	    	     obj.setSchool(str);
                 cls();
	    	     } 
	    	    
	   	 }
	   static void  cls() throws ClassNotFoundException, SQLException, IOException
	    	 {
	    		 int i,count=0;
	    		 Signup obj=new Signup(); 
	    	     System.out.println("ENTER THE CLASS [ex:10]"); 
	    	     Scanner m=new Scanner(System.in);
	    	     String str=m.nextLine(); 
	    	     for (i= 0;i <str.length(); i++) 
	    	     { 
	    	     char ch1 = str.charAt(i); 
	    	     if (ch1 >= '0' && ch1 <= '9')  
	    	     {  
	    	     count++;
	    	     }
	    	     else
	    	     {
	    	     System.out.println("*enter correct school name");   
	    	     cls();
	    	     break;
	    	     } 
	    	     }
	    	     if(count==str.length())
	    	     {
	    	      obj.setCls(str);
	    	     }
	    	 
	     Connection con = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     Class.forName("com.mysql.jdbc.Driver");
	     con = DriverManager.  getConnection("jdbc:mysql://localhost/surya?useSSL=true" ,"root","surya");
	     String query = "insert into parent(name,rollnumber,dob,phonenumber,cls,school)values (?,?,?,?,?,?)";
	     pstmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	     pstmt.setString(1, obj.getUsername());
	     pstmt.setString(2, obj.getRollnumber());
	     pstmt.setString(3, obj.getDob());
	     pstmt.setString(4, obj.getPhonenumber());
	     pstmt.setString(5, obj.getCls());
	     pstmt.setString(6, obj.getSchool());
	     pstmt.executeUpdate();
	     rs = pstmt.getGeneratedKeys();
	     pstmt.close();
	     con.close();  
	     stayfour();
	}
	 static void stayfour() throws ClassNotFoundException, SQLException, IOException
     {

     System.out.println("ENTER(1)FOR ADD ANOTHER STUDENT ||ENTER(2)FOR DASHBOARD");
     System.out.println("---------------------------------------------------------");
     Scanner h=new Scanner(System.in);
     int q1=h.nextInt();
     if(q1==1)
     {
     	username1();
     }
     else if(q1==2)
     {
     	DashboardMentor.mentorpage();
     }
     else
     {
     	stayfour();
     }
     }
}
		
	



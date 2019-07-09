package diary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MentorSignup {
	
 static void username() throws ClassNotFoundException, SQLException, IOException
 {
	 int count=0,count1=0,count2=0;
     Signup obj=new Signup();  
     System.out.println("--SIGNUP--");                                
     Scanner f=new Scanner(System.in);                                                                        
     System.out.println("ENTER THE NAME");  
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
     username() ;
     break;
     }
     }
	  count=count1+count2;
     if(count==s.length)
     {	
     obj.setUsername(str);
     mentorid();
     }
 }

   static void  mentorid() throws ClassNotFoundException, SQLException, IOException
 {
	 int i,count=0;
	 Signup obj=new Signup(); 
     System.out.println("ENTER THE MENTOR ID"); 
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
     System.out.println("*enter valid id");   
     mentorid();
     break;
     } 
     }
     if(count==str.length())
     {
      obj.setMentorid(str);
      phonenumber();
     }
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
     System.out.println("*Invalid number");   
     phonenumber()	;
     break;
     }
     }
     if(count==10)
     {
     obj.setPhonenumber(str);
     password();
     }
     else if(count!=10)
     {
     System.out.println("Invalid number ");   
     phonenumber();
     }
 }
 static void password() throws ClassNotFoundException, SQLException, IOException
{
	int i,count=0;
	 Signup obj=new Signup(); 
	 Scanner m=new Scanner(System.in);
	 System.out.println("ENTER THE PASSWORD");                                                                                            	                                                                                 
     String str=m.nextLine() ;
     if(str.length()>=5)
     {
     obj.setPassword(str) ;
     } 
     else if(str.length()<5)
     {
     System.out.println("*enter atleast five character");   
      password();
     }
     if(str.length()==5)
     {
     System.out.println("*your password is week");    
     }
     else if(str.length()>5&&str.length()<=8)
     {
     System.out.println("*your password is simple");    
     }
     else if(str.length()>8)
     {
     System.out.println("*your password is strong");
     }
     
     Connection con = null;
     PreparedStatement pstmt = null;
     ResultSet rs = null;
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager.  getConnection("jdbc:mysql://localhost/surya?useSSL=true" ,"root","surya");
     String query = "insert into mentor(username,phonenumber,mentorid,password)values (?,?,?,?)";
     pstmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
     pstmt.setString(1, obj.getUsername());
     pstmt.setString(2, obj.getPhonenumber());
     pstmt.setString(3, obj.getMentorid());
     pstmt.setString(4, obj.getPassword());
     pstmt.executeUpdate();
     rs = pstmt.getGeneratedKeys();
     pstmt.close();
     con.close();   
     MentorSignin.mentorsignin();
}

}

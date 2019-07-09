package diary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Scanner;

public class Chose {
static void chose() throws IOException, ParseException, ClassNotFoundException, SQLException                                                          
 {    
                                                                 
      Scanner first=new Scanner(System.in);                                                                                                             
      System.out.println("**PARENT press (1)** -------**MENTOR press (2)**");                                  
                                                                             
             
       int a=first.nextInt();   
       if(a==1)
       {
      
             Parent.parentsignin();
       }
         
       
       else if(a==2)
       {
      
       mentorsite();
            
       }
       else
       {
      System.out.println("Invalid key");
      chose();
       }
 } 
 static void mentorsite() throws ClassNotFoundException, SQLException, IOException
 {
	   System.out.println("**SIGNUP press (1)** -------** SIGNIN (2)**");	
	   Scanner second=new Scanner(System.in);   
	   	int b=second.nextInt();   
	            if(b==1)
	            {
	                MentorSignup.username();
	            }
	            else if(b==2)
	            {
	             	MentorSignin.mentorsignin(); 
	            }
	            else
	            {
	           	System.out.println("Invalid key");
	           	mentorsite();
	           	
	            }
 }
    
     }
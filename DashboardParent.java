package diary;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class DashboardParent {
	static void parentdashboard() throws IOException, SQLException, ClassNotFoundException
	{  
	  Signup obj=new Signup();
	  System.out.println("STUDENT DETAIL");
	  System.out.println("--------------");
      System.out.println("Name  :"+obj.getNam()); 
      System.out.println("CLASS :"+obj.getCls()+"std                                       [?]ASK DOUBTS press(0)");
      System.out.println("SCHOOL:"+obj.getSchool());
	  System.out.println("                         ___________________________ "); 
	  System.out.println("                        |                           |");
	  System.out.println("                        |     STUDENT DASHBOARD     |"); 
	  System.out.println("                        |___________________________|"); 
	                                     
	    try{Thread.sleep(300);}catch(InterruptedException e1){System.out.println(e1);}  
	  System.out.println(" ________________________                              ________________________ ");     
	  System.out.println("|                        |                            |                        |");
	  System.out.println("|                        |                            |                        |");
	  System.out.println("|Press (1) For ATTENDENCE|                            | Press (2) For HOMEWORK |"); 
	  System.out.println("|                        |                            |                        |");
	  System.out.println("|________________________|                            |________________________|");   
	  try{Thread.sleep(300);}catch(InterruptedException e1){System.out.println(e1);}  	  
	  System.out.println(" ________________________                              ________________________ ");  
	  System.out.println("|                        |                            |                        |");
	  System.out.println("|                        |                            |                        |"); 
	  System.out.println("|   Press (3) For TEST   |                            |   Press (4) For FEES   |"); 
	  System.out.println("|                        |                            |         Details        |");
	  System.out.println("|________________________|                            |________________________|");                  
	  try{Thread.sleep(300);}catch(InterruptedException e1){System.out.println(e1);}
	  System.out.println("                           ___________________________ "); 
	  System.out.println("                          |      Press (5) For        |");
	  System.out.println("                          |           LOGOUT          |"); 
	  System.out.println("                          |_______ ___________________|");
	   
	   Scanner f=new Scanner(System.in);
	    int i=f.nextInt();
	    if(i==1)
	    {
	    ParentAttendence. attendence();
	    } 
	    else if(i==2)
	    {
	    ParentHomework.homework();
	    }
	    
	    else if(i==3)
	    {
	    ParentTest.test();
	    }
	    
	    else if(i==4)
	    {
	     ParentFees.fees();
	    }
	    else if(i==5)
	    {
	    Parent.parentsignin();
	     
	    }
	    else if(i==0)
	    {
	    	ParentASkdoubt.rply();;
	    }
	      
	   else {
	    System.out.println("PLEASE CHOSE CORRECT OPTION");
	    parentdashboard();
	    }
	    
	    


	}    
}

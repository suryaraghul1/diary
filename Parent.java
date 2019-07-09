package diary;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Parent {
	static void parentsignin() throws IOException,SQLException, ClassNotFoundException
	{  
	int c=0;
	System.out.println("--SIGNIN--");              
	Scanner e=new Scanner(System.in);                                         
	System.out.println("ENTER YOUR CHILD RollNUMBER");                                                                                                   
	String a=e.nextLine();                                                                                                                                
	System.out.println("ENTER YOUR CHILD DATAOFBIRTH[dd/mm/yyyy]");
	System.out.println("                          ex:03/05/2008");
	String b=e.nextLine();  
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager. getConnection("jdbc:mysql://localhost/surya?useSSL=true","root","surya");
	String query = "SELECT * FROM parent";
	pstmt = con.prepareStatement(query);
	rs = pstmt.executeQuery();
	Signup obj=new Signup();
	String a1="",b1="";
	while(rs.next()) {
	a1= rs.getString("rollnumber");
	b1 =rs.getString("dob");
	if(a.equals(a1) && b.equals(b1)) 
	{
	c++;
	obj.setNam(rs.getString("name"));
	obj.setCls(rs.getString("cls"));
	obj.setSchool(rs.getString("school"));
	obj.setRno(a);
	DashboardParent.parentdashboard();
	break;
	}
	}
	if(c==0)
	{
		System.out.println("Ivalid Rollnumber & DOB!try again");
	     parentsignin();
	}

	rs.close();
	pstmt.close();
	con.close();
	}
}
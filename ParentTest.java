package diary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParentTest {
	 static void test() throws IOException, SQLException, ClassNotFoundException
	    {
	  
	    	System.out.println("                          ________________________ ");     
	        System.out.println("                         |                        |");
	    	System.out.println("                         |          TEST          |"); 
	    	System.out.println("                         |________________________|");
	    	System.out.println(" ");
	    	Connection con = null;
	    	PreparedStatement pstmt = null;
	    	ResultSet rs = null;
	    	Class.forName("com.mysql.jdbc.Driver");
	    	con = DriverManager. getConnection("jdbc:mysql://localhost/surya?useSSL=true","root","surya");
	    	String query3 = "SELECT * FROM test";
	    	pstmt = con.prepareStatement(query3);
	    	rs = pstmt.executeQuery();
	    	Signup obj=new Signup();
	    	String str=obj.getRno();
	    	String a=null;
	    	while(rs.next()) 
	    	{
	    	a= rs.getString("rollnumber");
	    	if(str.equals(a))
	    	{
	    		System.out.println(" UPCOMING TEST[upadate in("+rs.getString("data")+")]");
	    		System.out.println(" ");
	    		System.out.println("TAMIL   :"+rs.getString("tamil"));
	    		System.out.println(" ");
	    		System.out.println("ENGLISh :"+rs.getString("english"));
	    		System.out.println(" ");
	    		System.out.println(" MATHS  :"+rs.getString("maths"));
	    		
	    		
	    	}
	    	}
	    	rs.close();
	    	pstmt.close();
	    	con.close();	
	    	Choice.chose();
	    	}
}

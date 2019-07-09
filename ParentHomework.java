package diary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParentHomework {
	static void homework() throws SQLException, ClassNotFoundException, IOException
    {
    
    	System.out.println("                          ________________________ ");     
        System.out.println("                         |                        |");
    	System.out.println("                         |       HOMEWORK         |"); 
    	System.out.println("                         |________________________|");
    	System.out.println(" ");
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	Class.forName("com.mysql.jdbc.Driver");
    	con = DriverManager. getConnection("jdbc:mysql://localhost/surya?useSSL=true","root","surya");
    	String query2 = "SELECT * FROM homework";
    	pstmt = con.prepareStatement(query2);
    	rs = pstmt.executeQuery();
    	Signup obj=new Signup();
    	String str=obj.getRno();
    	String a=null;
    	while(rs.next()) 
    	{
    	a= rs.getString("rollnumber");
    	if(str.equals(a))
    	{
    		System.out.println("Today HomeWork Status["+rs.getString("data")+"]");
    		System.out.println(" ");
    		System.out.println("TAMIL   :"+rs.getString("tamil"));System.out.println(" ");
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

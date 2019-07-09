package diary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParentAttendence {
	static void attendence() throws ClassNotFoundException, SQLException, IOException
    {
    	System.out.println("                          ________________________ ");     
    	System.out.println("                         |                        |");
    	System.out.println("                         |       ATTENDENCE       |"); 
    	System.out.println("                         |________________________|");
    	System.out.println(" ");
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	Class.forName("com.mysql.jdbc.Driver");
    	con = DriverManager. getConnection("jdbc:mysql://localhost/surya?useSSL=true","root","surya");
    	String query1 = "SELECT * FROM attendence";
    	pstmt = con.prepareStatement(query1);
    	rs = pstmt.executeQuery();
    	Signup obj=new Signup();
    	String str=obj.getRno();
    	String a=null;
    	while(rs.next()) 
    	{
         a= rs.getString("rollnumber");
    	if(str.equals(a))
    	{
    		System.out.println("Today Attendence Status :"+rs.getString("attend")+"["+rs.getString("data")+"]");
    		System.out.println("Overall Percentage :"+rs.getString("percentage"));
    	}
    	}
    	rs.close();
    	pstmt.close();
    	con.close();
    	Choice.chose();
       }
}

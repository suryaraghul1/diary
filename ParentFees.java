package diary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParentFees {
	 static void fees() throws SQLException, ClassNotFoundException, IOException
	    {
	    	System.out.println("                          ________________________ ");     
	        System.out.println("                         |                        |");
	    	System.out.println("                         |          FEES          |"); 
	    	System.out.println("                         |________________________|");
	    	System.out.println(" ");
	    	Connection con = null;
	    	PreparedStatement pstmt = null;
	    	ResultSet rs = null;
	    	Class.forName("com.mysql.jdbc.Driver");
	    	con = DriverManager. getConnection("jdbc:mysql://localhost/surya?useSSL=true","root","surya");
	    	String query4 = "SELECT * FROM fees";
	    	pstmt = con.prepareStatement(query4);
	    	rs = pstmt.executeQuery();
	    	String a=null;
	    	Signup obj=new Signup();
	    	String str=obj.getRno();
	    	while(rs.next()) 
	    	{
	    	a= rs.getString("rollnumber");
	    	if(str.equals(a))
	    	{
	    		System.out.println(" UPCOMING Fees[upadate in("+rs.getString("data")+")]");
	    		System.out.println(" ");
	    		System.out.println("->"+rs.getString("fees"));
	    		System.out.println(" ");
	    		System.out.println("PENDING :"+rs.getString("pending"));
	    	}
	    	}
	    	rs.close();
	    	pstmt.close();
	    	con.close();	
	    	
	    	
	    	Choice.chose();
	    }

}

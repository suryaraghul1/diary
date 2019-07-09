package diary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ParentASkdoubt {
	
static void rply() throws SQLException, ClassNotFoundException, IOException
{
	System.out.println("                          ________________________");  
	System.out.println("                         |         Chat           |"); 
	System.out.println("                         |      With Mentor       |");
	System.out.println("                         |________________________|");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager. getConnection("jdbc:mysql://localhost/surya?useSSL=true","root","surya");
	String query4 = "SELECT * FROM doubt";
	pstmt = con.prepareStatement(query4);
	rs = pstmt.executeQuery();
	String a=null;
	Signup obj=new Signup();
	String str=obj.getRno();
	java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());	
	while(rs.next()) 
	{
	a= rs.getString("rollnumber");
	if(str.equals(a))
	{
		System.out.println(" ");
		System.out.println("Mentor:"+rs.getString("clear")+"["+rs.getDate("date")+"]");
		System.out.println(" ");
		System.out.println("you:"+rs.getString("ask"));
	}
		
	}
	    rs.close();
	    pstmt.close();
	 	con.close();	
	 	question();
	 
	}
static void question() throws ClassNotFoundException, SQLException, IOException
{

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager. getConnection("jdbc:mysql://localhost/surya?useSSL=true","root","surya");
	 	
	String query1 = "insert into doubt(rollnumber,date,ask,clear)values (?,?,?,?)";
  	pstmt = con.prepareStatement(query1,Statement.RETURN_GENERATED_KEYS);
  	Signup obj=new Signup();
 	String str=obj.getRno();
  	pstmt.setString(1,str); 
  	java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());	
  	pstmt.setDate(2, sqlDate);
  	Scanner d=new Scanner(System.in);
  	String doubt=d.nextLine();
  	pstmt.setString(3,doubt);
  	String h="";
  	pstmt.setString(4,h);
    pstmt.executeUpdate();
    rs = pstmt.getGeneratedKeys();
    rs.close();
    pstmt.close();
    con.close();   
    Choice.chose();

}
}



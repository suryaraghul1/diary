package diary;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Choice {
static void chose() throws IOException, SQLException, ClassNotFoundException
{
  System.out.println("ENTER(1)FOR DASHBOARD||ENTER(2)FOR LOGOUT");
  Scanner l=new Scanner(System.in);
  int k=l.nextInt();
  if(k==1)
  {
  DashboardParent.parentdashboard();
  }
  else if(k==2)
  {
  Parent.parentsignin();
  }
  
  else
  {
  chose();
  }
  
}
}

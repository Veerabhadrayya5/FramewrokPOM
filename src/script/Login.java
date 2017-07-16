package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

@Test
public class Login extends BaseTest {
	
	


		public void testLogin() throws InterruptedException
	{
	LoginPage lo=new LoginPage(driver);
	
	lo.setUseerName(Excel.getCellCalue(EXCEL_PATH, "Login", 1, 0));

	lo.setPassword(Excel.getCellCalue(EXCEL_PATH, "Login", 1, 1));

	lo.clickLogin();
	Thread.sleep(2000);
   lo.logout();
	
	
	
	
	}
	
	
}

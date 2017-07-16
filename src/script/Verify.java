package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LicensesPage;
import page.LoginPage;
import page.actiTIMETTPage;

public class Verify extends BaseTest {

	@Test
	public void verifyVersion() throws InterruptedException
	{
		
		LoginPage login=new LoginPage(driver);
		String eversion=login.getVersion();
		log.info("version in login page"+eversion);
		login.setUseerName(Excel.getCellCalue(EXCEL_PATH, "Login", 1, 0));

		login.setPassword(Excel.getCellCalue(EXCEL_PATH, "Login", 1, 1));
		login.clickLogin();
		Thread.sleep(2000);
		actiTIMETTPage at=new actiTIMETTPage(driver);
		at.setClickSetting();
		Thread.sleep(1000);
		at.setclickLicense();
		Thread.sleep(1000);
		LicensesPage lc=new LicensesPage(driver);
		
		lc.setCompare(eversion);
		Thread.sleep(2000);
		lc.logout();
				
	}
	
	
	
}

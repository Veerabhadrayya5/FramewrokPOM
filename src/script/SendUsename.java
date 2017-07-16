package script;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;


public class SendUsename extends BaseTest {

	
	@Test
	public void sendData()
	{
	String j=	Excel.getCellCalue(EXCEL_PATH, "sheet1", 0, 0);
	driver.findElement(By.name("username")).sendKeys(j);
	log.info("entered UserName");
	
	}
	
}

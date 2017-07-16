package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LicensesPage extends BasePage{
public LicensesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


@FindBy(xpath="//b[contains(.,'actiTIME')]")
private WebElement versionText;

	public void setCompare(String eVersion)
	{
		String version = versionText.getText();
		Assert.assertEquals(version, eVersion);
		
	}
	
	
	
}

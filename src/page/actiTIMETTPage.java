package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class actiTIMETTPage extends BasePage{

	public actiTIMETTPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath="//div[@class='popup_menu_icon warning_icon']")
	private WebElement setting;
	
	@FindBy(xpath="//a[.='Licenses']")
	private WebElement licenses;
	
	@FindBy(xpath="//b[contains(.,'actiTIME')]")
	private WebElement versioninHome;
	
	public void setClickSetting()
	{
		setting.click();
	}
	
	public void setclickLicense()
	{
		licenses.click();
	}
	
}

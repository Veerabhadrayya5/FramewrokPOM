package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name = "username")
	private WebElement setName;

	@FindBy(name = "pwd")
	private WebElement setPwd;

	@FindBy(xpath = "//div[.='Login ']")
	private WebElement clickLogin;

	@FindBy(xpath = "//span[contains(.,'invalid')]")
	private WebElement errMsg;

	@FindBy(xpath = "//nobr[contains(text(),'actiTIME')]")
	private WebElement version;

	public void setUseerName(String name) {
		setName.sendKeys(name);
	}

	public void setPassword(String pass) {
		setPwd.sendKeys(pass);
	}

	public void clickLogin() {
		clickLogin.click();
	}

public String getVersion()
{

String strversion= 	version.getText();
return strversion; 
}
}

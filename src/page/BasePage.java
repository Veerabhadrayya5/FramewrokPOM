package page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.AllPath;

public class BasePage implements AllPath {

	public WebDriver driver;
	public Logger log;

	@FindBy(id = "logoutLink")
	private WebElement clickLogout;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		log = Logger.getLogger(this.getClass());
	}

	public void logout() {
		clickLogout.click();
	}

}

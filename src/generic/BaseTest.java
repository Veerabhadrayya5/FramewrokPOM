package generic;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;


@Listeners(IListener.class)
public class BaseTest implements AllPath {
	public WebDriver driver;
	public Logger log = Logger.getLogger(this.getClass());
	String strurl;
	String Iit;

	@BeforeSuite
	public void setPath() {
		log.info("Set the Path");
		System.setProperty(CHROME_KEY, CHROME_VALUE);

		System.setProperty(GECKO_KEY, GECKO_VALUE);

	}

	@Parameters({ "browser" })
	@BeforeMethod
	public void openB(String browser) {
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
			log.info("open the chrome browser");
		} else {
			driver = new FirefoxDriver();
			log.info("open the firefox browser");

		}

		strurl = AutoUtility.getProprty(CONFIG_PATH, "url");
		driver.get(strurl);
		log.info("enter the url");
		String x = AutoUtility.getProprty(CONFIG_PATH, "it");

		Long Iit = Long.parseLong(x);
		driver.manage().timeouts().implicitlyWait(Iit, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void closeB() {
		driver.close();
		log.info("chrome browser has beed closed");
	}

}

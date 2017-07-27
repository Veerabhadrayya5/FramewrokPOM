package script;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
//import org.apache.log4j.Logger;
public class OutLetRod {
	public Logger log = Logger.getLogger(this.getClass());
	WebDriver driver;
	@BeforeSuite
	public void setPath() {
		log.info("Set the Path");
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe" );
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe" );
	}
	
	@Parameters({ "browser" })
	@BeforeMethod()
public void open(String browser)
	{
		if(browser.equals("chrome"))
		{
		driver=new ChromeDriver();
		log.info("Opening chrome browser");
		}
		if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
			log.info("Opening firefox browser");
				
		}
		
		driver.manage().window().maximize();
		driver.get("https://outlet.rods.com/");
		log.info("Enter the URL");

		
	}
	
	@Test(priority=1)
  public void EachLetter() throws BiffException, IOException, InterruptedException {
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(.,'Thanks')]")).click();

	FileInputStream fi=new FileInputStream("D:\\bbb1.xls");
		Workbook wb=Workbook.getWorkbook(fi);
		Sheet sh=wb.getSheet("Sheet1");
String x = null;
		for(int i=1;i<=11;i++)
		{

		 x=sh.getCell(0,i).getContents();
		 log.info("Fetching query from Excel");
			log.info("Searched query is:"+x);
	 
		
		 driver.findElement(By.id("search")).sendKeys(x);
		 Thread.sleep(5000);
		try
		{
		String actul = driver.findElements(By.xpath("//li[contains(@class,'header')]")).get(0).getText();
		log.info(actul);
		String exp="Suggestions";
		String exp1="Popular";
		
		if(actul.contains(exp)|actul.contains(exp1))
		{
			log.info("Autosuggest Should display");
			log.info("Autosuggest Displaying for "+x+" letter :: PASS");
			log.info("------------------------------------------------");
		}
		else
		    {
			 log.info("Autosuggest Should display");
			 log.info("Autosuggest is not displaying for "+x+" word :: FAIL");
			 log.info("------------------------------------------------");
		    }
		}
		catch(Exception e)
		{
			log.info("Autosuggest Should not display");
			log.info("Autosuggest is not displaying for "+x+" word :: PASS");
			log.info("------------------------------------------------");
		}
		Thread.sleep(1000);
		
		driver.findElement(By.id("search")).clear();
	
		}
	
  }

//---------------------------------------------------------------------------------------
//Keywordsuggation selected or not
	@Test(priority=2)
	public void infieldClickable() throws InterruptedException, BiffException, IOException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.linkText("No Thanks")).click();


FileInputStream fi=new FileInputStream("D:\\bbb1.xls");
Workbook wb=Workbook.getWorkbook(fi);
Sheet sh=wb.getSheet("Sheet1");
String y = null;

 y=sh.getCell(2,1).getContents();
 log.info("Fetching query from Excel");
 log.info("Searched query is:"+y);

		driver.findElement(By.name("q")).sendKeys(y);

		List<WebElement> alloption = driver.findElements(By.xpath("//ul//li//strong[contains(.,'Shirt')]"));
	 
	 alloption.get(1).click();
	 String actul=driver.getTitle();
	 log.info("Selected infield"+actul);
	if(actul.contains("Shirts"))
	{
		log.info("infield is Clickable"+ y+" word :: PASS");
		log.info("------------------------------------------------");
	}
	else
	{
		log.info("infield is not Clickable"+ y+" word :: FAIL");
		 log.info("------------------------------------------------");
	}
	    
	Thread.sleep(1000);
	
	driver.findElement(By.id("search")).clear();	
	}


// withspace and click on search box , it should be trigger
	
	@Test (priority=3)
	  public void space() throws InterruptedException, IOException {
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          driver.findElement(By.xpath("//a[contains(.,'Thanks')]")).click();
		String actual=driver.getCurrentUrl();
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys(" ");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='image']")).click();
	String exp=driver.getCurrentUrl();
	if(exp.equals(actual))
	{
		log.info("Should not show any results for blank space"+"PASS");
	
	}
	else
	{
		 log.info("Should not show any results for blank space"+"FAIL");
	}
		}
	
	@Test (priority=4)
	  public void http() {
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(.,'Thanks')]")).click();
log.info("Test case:4");
		log.info("Test case got Failed");
	Assert.fail();	
	}
	

/*
	//checking http and https
	@Test (priority=4)
	  public void http() throws InterruptedException, IOException {
			
				
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://outlet.rods.com/catalog/product/view/id/157680?___store=outlet");
     driver.findElement(By.xpath("//a[contains(.,'Thanks')]")).click();
		
		String x=driver.findElement(By.xpath("//span/span[contains(.,'Add to Cart')]")).getText();
		String exp=driver.getCurrentUrl();
		log.info("The expected URL is"+exp);
	      System.out.println(x);
	      Thread.sleep(1000);
	      driver.get("http://outlet.rods.com/catalog/product/view/id/157680?___store=outlet");
	      String y=driver.findElement(By.xpath("//span/span[contains(.,'Add to Cart')]")).getText();
	  	String actual=driver.getCurrentUrl();
	    log.info("The Actual URL is"+actual);   
	    log.info(y);
	 
	      
	      if(exp.equals(actual))
	{
	    	  log.info("Both Page conent is same:"+"PASS");
	    	  log.info("------------------------------------------------");
	}
	else
	{
		 log.info("Both Page conent is not same:"+"FAIL");
		 log.info("------------------------------------------------");
	}
		}	
	

*/
}

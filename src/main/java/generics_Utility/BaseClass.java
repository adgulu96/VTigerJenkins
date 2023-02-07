package generics_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject_Repository.Login_Page;

public class BaseClass 
{
	public static WebDriver driver; 
	
	//CONNECTING THE DATABASE **BEFORE_SUITE**
	@BeforeSuite (groups = {"smoke","regression"})
	public void beforeSuite()
	{
		System.out.println("\n CONNECTING THE DATABASE.........");
	}
	//FOR PARALLEL EXECUTION  **BEFORE_TEST**
	@BeforeTest (groups = {"smoke","regression"})
	public void beforeTest()
	{
		System.out.println("\n PARALLEL EXECUTION.......");
	}
	//LAUNCHING THE BROWSER  **BEFORE_CLASS**
	//@Parameters ("BROWSER")
	@BeforeClass (groups ={"smoke","regression"})
//	  public void beforeClass(String BROWSER) 
//	   {
		public void beforeClass() throws Throwable {
			 
		System.out.println("\n LAUNCHING THE BROWSER...");
		
		  File_Utility flib = new File_Utility(); String
		  BROWSER=flib.getKeyandValue("browser");
		 
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else
		{
			//driver=new ChromeDriver();
		}
		System.out.println("Launching Browser ::: :::: :: "+driver);
	}
	//LAUCHING THE BROWSER	**BEFORE_METHOD**
	@BeforeMethod (groups = {"smoke","regression"})
	public void beforeMethod() throws Throwable
	{
		System.out.println("\n LAUNCHING THE APPLICATION.....");
		System.out.println("     ");
		
		File_Utility flib = new File_Utility();
		//This is imported from the webdriver utility class of generic package	
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeScreen(driver);
		wlib.waitForPageToLoad(driver,20);
		
	//This is imported from the generic_utility package and obj created from the File_Utility class
			String URL = flib.getKeyandValue("url");
			String USERNAME = flib.getKeyandValue("username");
			String PASSWORD = flib.getKeyandValue("password");
			
	//Imported from the POM object repo package and Login_Page class
			driver.get(URL);
			Login_Page login = new Login_Page(driver);
			login.loginToapp(USERNAME, PASSWORD);
	}
	//CLOSING THE APPLICATION	**AFTER_METHOD**
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("\n CLOSING THE APPLICATION....");
	}
	//CLOSING THE BROWSER  **AFTER_CLASS**
	@AfterClass
	public void afterClass() throws Throwable
	{
		System.out.println("\n CLOSING THE BROWSER...");
		Thread.sleep(500);
		driver.quit();
	}
	//PARALLEL EXECUTION	**AFTER_TEST**
	@AfterTest
	public void afterTest()
	{
		System.out.println("\n PARALLEL EXECUTION STOPPED....");
	}
	//CLOSING THE DATABASE  **AFTER_SUITE**
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("\n CLOSING THE DATABASE...");
	}
}


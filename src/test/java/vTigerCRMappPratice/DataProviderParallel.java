package vTigerCRMappPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderParallel 
{

    public WebDriver driver;

    @BeforeTest
    public void setUp() 
    {
    	System.out.println("Starting the test...");
    }

    @Test(dataProvider = "data", threadPoolSize = 3)
    public void login(String username, String password) throws InterruptedException 
    {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    	driver.get("https://demo.actitime.com");
        Thread.sleep(2000);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password);
    }

    @DataProvider(name = "data", parallel = true)
    public Object[][] passdata() {
        return new Object[][] { { "abinash" , "abinash123" }, 
        	                  {   "satyam"  , "satyam123" }, 
        	                  {    "manas"  , "manas123" } };
    }
    
    @AfterTest
    public void tearDown() {
        //driver.quit();
    }
}

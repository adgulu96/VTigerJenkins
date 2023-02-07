package vTigerCRMappPratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generics_Utility.Excel_Utility;
import generics_Utility.File_Utility;
import generics_Utility.WebDriver_Utility;

public class SalesordersaveContact {

	public static void main(String[] args) throws Throwable 
	{
		String key = "webdriver.chrome.driver";
		String value = "./src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Fetching data from the File_Utility class and GENERIC package
		File_Utility flib = new File_Utility();
		String URL = flib.getKeyandValue("url");
		String USERNAME = flib.getKeyandValue("username");
		String PASSWORD = flib.getKeyandValue("password");
		
		driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
		
		//adding new contact to fetch in the salesorder (INTEGRATON TESTING / DATAFLOW)
			driver.findElement(By.xpath("//a[.='Contacts']")).click();
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			
		WebElement element = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.selectByText(element, "Mr.");
		Thread.sleep(1000);

		Excel_Utility celib = new Excel_Utility();
		String conName=celib.getExcelData("SalesOrder", 0, 0);
		driver.findElement(By.name("firstname")).sendKeys(conName);
			
			
		driver.findElement(By.xpath("//td[.='More']")).click();
		driver.findElement(By.name("Sales Order")).click();
		driver.findElement(By.xpath("//img[@alt='Create Sales Order...']")).click();
		
		//Fetching data from the Excel_Utility class and GENERIC package
		Excel_Utility elib = new Excel_Utility();
		String saleorderName =elib.getExcelData("SalesOrder", 0, 0);
		driver.findElement(By.name("subject")).sendKeys(saleorderName);
		driver.findElement(By.xpath("(//img[@title='Select'])[3]")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

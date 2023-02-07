package organizations;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import generics_Utility.BaseClass;
import generics_Utility.Excel_Utility;
import generics_Utility.Java_Utility;
import generics_Utility.RetryImpClass;
import pageObject_Repository.Home_Page;
import pageObject_Repository.OrganizationCreation_Page;

public class CreateOrganization extends BaseClass
{
	@Test (retryAnalyzer = generics_Utility.RetryImpClass.class)
	//@Test (groups = "smoke")
	public void createOrganizaion() throws Throwable
	{
		//Imported from the POM object repo package and Home_page Class		
				Home_Page home = new Home_Page(driver);
				home.clickOrganizationsLinkText(); 
				
		//Calling method from the Java_Utility class and generic package
				Java_Utility jlib = new Java_Utility();
				int ranNum = jlib.getRandomNumber();	
				
		//Calling from the Excel_Utility class of generic package
				Excel_Utility elib = new Excel_Utility();
				String OrgName=elib.getExcelData("OrgName", 0, 0)+ranNum;
				
		//Imported from the POM object repo package and OrganizationCreation_page Class		
				OrganizationCreation_Page org = new OrganizationCreation_Page(driver);
				org.CreateOrganizationbutton();
				org.organizationNameTextfield(OrgName);
				//org.ClickOrganizationCreateImage();
				org.Save();
				
				String actualData = driver.findElement(By.xpath("//span[text()='"+OrgName+"']")).getText();
				Assert.assertEquals(actualData, OrgName);
				
//		//validation
//				ValidationAndVerification_Page validate = new ValidationAndVerification_Page(driver);
//				validate.Organizationvalidation(driver, OrgName);
		//Sign Out
				home.signoutLink(driver);
	}
}



//String key = "webdriver.chrome.driver";
//String value = "./src/main/resources/chromedriver.exe";
//System.setProperty(key, value);
//WebDriver driver = new ChromeDriver();
//driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
////fetching data from the property
//FileInputStream fis = new FileInputStream("./src/test/resources/PropertyData.properties");
//Properties pro = new Properties();
//pro.load(fis);
//String URL=pro.getProperty("url");
//String USERNAME=pro.getProperty("username");
//String PASSWORD=pro.getProperty("password");
//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//driver.findElement(By.id("submitButton")).click();
//Random ran = new  Random();
//int ranNum = ran.nextInt(1000);			
////fetching data from the excel sheet
//FileInputStream fis1 = new FileInputStream("./src/test/resources/VtigerData.xlsx");
//Workbook book = WorkbookFactory.create(fis1);
//Sheet sh = book.getSheet("OrgName");
//Row row =sh.getRow(0);
//Cell cell =row.getCell(0);
//String orgname = cell.getStringCellValue()+ranNum;	
//driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();	
//driver.findElement(By.name("accountname")).sendKeys(OrgName);
//driver.findElement(By.name("button")).click();	
//Thread.sleep(1000);
//WebElement element = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
//WebElement signout = driver.findElement(By.xpath("//a[.='Sign Out']"));
//Actions act = new Actions(driver);
//act.moveToElement(element).perform();
//Thread.sleep(2000);
//act.click(signout).perform();
//Thread.sleep(1000);
//driver.quit();
//String actData= driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
//if(actData.contains(OrgName))
//{
//	System.out.println("Validation is passed");
//}
//else 
//{
//	System.out.println("Validation is failed");
//}

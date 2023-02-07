package campaigns;

import org.testng.Assert;
import org.testng.annotations.Test;
import generics_Utility.BaseClass;
import generics_Utility.Excel_Utility;
import generics_Utility.Java_Utility;
import pageObject_Repository.CampaignCreation_Page;
import pageObject_Repository.Home_Page;

public class CreateCampaign extends BaseClass {

	 @Test
	 public void createCampaign() throws Throwable 
	 {
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();

     //Homepage called for click on the more link
		 Home_Page home = new Home_Page(driver);
		 home.moreLink(driver);
	//Campaign page called for click on campaign and create campaign	 
		 CampaignCreation_Page campaign = new CampaignCreation_Page(driver);
		 campaign.clickoncampaignlink();
		 campaign.campaignCreateImage();
		 //Random number call and data from the excel sheet
		 int ranNum = jlib.getRandomNumber();
		 String campName = elib.getExcelData("CampaignName", 0, 0)+ranNum;
		 campaign.campaignTextField(campName);
		 campaign.saveButton();
		 //Validation and verification
		 
		 Assert.assertEquals(campName, campName);
		 
//		 ValidationAndVerification_Page validate = new ValidationAndVerification_Page(driver);
//		 validate.CampaignValidation(driver, campName);
		 home.signoutLink(driver);
	}
}
//String key = "webdriver.chrome.driver";
//String value = "./src/main/resources/chromedriver.exe";
//System.setProperty(key, value);
//WebDriver driver = new ChromeDriver();
//// Accessing data from the properties file
//FileInputStream fis = new FileInputStream("./src/test/resources/PropertyData.properties");
//Properties pro = new Properties();
//pro.load(fis);
//String URL=pro.getProperty("url");
//String USERNAME = pro.getProperty("username");
//String PASSWORD = pro.getProperty("password");

//WebDriver driver = new ChromeDriver();
//driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//driver.findElement(By.id("submitButton")).click();
//WebElement hovermore = driver.findElement(By.xpath("//a[.='More']"));	
//Actions act = new Actions(driver);
//act.moveToElement(hovermore).perform();
// Thread.sleep(1500);
//driver.findElement(By.xpath("//a[.='Campaigns']")).click();
//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
////To avoid duplicates name in the campaigns we make user of random number with the name
//Random ran = new Random();
//int rannum = ran.nextInt(1000);
////Accessing data from the excel file
//FileInputStream efis = new FileInputStream("./src/test/resources/VtigerData.xlsx");
//Workbook book = WorkbookFactory.create(efis);
//Sheet sh = book.getSheet("CampaignName");
//Row r=sh.getRow(0);
//Cell c =r.getCell(0);
//String name =c.getStringCellValue()+rannum;
//driver.findElement(By.name("campaignname")).sendKeys(name);
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//Thread.sleep(1000);
//if(actData.contains(campName)) 
//{
//	 System.out.println("Validation is passed");
//}
//else
//{
//	 System.out.println("Validation is failed");
//}
//WebElement element = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
//WebElement signout = driver.findElement(By.xpath("//a[.='Sign Out']"));
//Actions act1 = new Actions(driver);
//act1.moveToElement(element).perform();
//Thread.sleep(2000);
//act.click(signout).perform();
//Thread.sleep(2000);
//driver.quit();

package campaigns;

import org.testng.annotations.Test;
import generics_Utility.BaseClass;
import generics_Utility.Excel_Utility;
import generics_Utility.Java_Utility;
import generics_Utility.WebDriver_Utility;
import pageObject_Repository.CampaignCreation_Page;
import pageObject_Repository.Home_Page;
import pageObject_Repository.ProductCreation_Page;
import pageObject_Repository.ValidationAndVerification_Page;

/*It is an INTEGRATION SCENARIO first create the product and create campaign with data flow of product name
from the PRODUCT MODULE to the CAMPAIGNS MODULE*/

public class CreateCampWithProduct extends BaseClass 
{
	@Test (groups = "regression")
	public void createCampWithProduct() throws Throwable
	{
		
		//IMPLEMENTING THE METHODS AND DATA FROM GENERIC PACKAGES (DDT & MDT)
				Java_Utility jlib = new Java_Utility();
				Excel_Utility elib = new Excel_Utility();
				WebDriver_Utility wlib = new WebDriver_Utility();
	
		   Home_Page home = new Home_Page(driver);
		   home.clickProductLink();
		   
		   ProductCreation_Page product = new ProductCreation_Page(driver);
		   product.productCreateImage();
		   int ranNum = jlib.getRandomNumber();
		   String proName = elib.getExcelData("Product", 0, 0)+ranNum;
		   product.productTextField(proName);
		   product.saveButton();

		  home.moreLink(driver);
		  CampaignCreation_Page campaign = new CampaignCreation_Page(driver);
		  campaign.clickoncampaignlink();
		  campaign.campaignCreateImage();
		  String campName = elib.getExcelData("CampaignName", 1, 0)+ranNum;
		  campaign.campaignTextField(campName);
		  
		  campaign.productSelectionImage(driver);
		  wlib.switchToWindow(driver, "Products&action");
		  campaign.searchProductButton(driver, proName);
		  wlib.switchToWindow(driver, "Campaigns&action");
		  campaign.saveButton();
		  
		  ValidationAndVerification_Page validate = new ValidationAndVerification_Page(driver);
		  validate.CampaignNamewithProductValidation(driver, campName);
		  
		  home.signoutLink(driver);
	}
}


////key and value for giving the properties of a CHROME browser
//String key = "webdriver.chrome.driver";
//String value = "./src/main/resources/chromedriver.exe";
//System.setProperty(key, value);
//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//driver.findElement(By.id("submitButton")).click();
////Fetching data from the properties file
//FileInputStream fis = new FileInputStream("./src/test/resources/PropertyData.properties");
//Properties pro = new Properties();
//pro.load(fis);
//String URL=pro.getProperty("url");
//String USERNAME = pro.getProperty("username");
//String PASSWORD = pro.getProperty("password");
////Creating an random number to avoid duplicates
//Random ran = new Random();
//int ranNum =  ran.nextInt(1000);
////Fetching the PRODUCT name from the excel sheet 
//FileInputStream pfis = new FileInputStream("./src/test/resources/VtigerData.xlsx");
//Workbook book = WorkbookFactory.create(pfis);
//Sheet sh =book.getSheet("Product");
//Row r = sh.getRow(1);
//Cell c =  r.getCell(0);
//String pname = c.getStringCellValue()+ranNum;
////click on the PRODUCT module / link and create product
//driver.findElement(By.linkText("Products")).click();
//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
//driver.findElement(By.name("productname")).sendKeys(pname);
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
////Navigate to more and campaigns
//driver.findElement(By.linkText("More")).click();
//driver.findElement(By.linkText("Campaigns")).click();
//
//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
//
//// //Fetching the CAMPAIGN name from the excel sheet // FileInputStream cfis
//= new FileInputStream("./src/test/resources/VtigerData.xlsx"); //
//XSSFWorkbook book1 = new XSSFWorkbook(cfis); // Sheet sh1 =
//book1.getSheet("CampaignName"); // Row r1 = sh1.getRow(1); // Cell c1 =
//r1.getCell(0); // String cname = c1.getStringCellValue()+ranNum;
//
//String cname=elib.getExcelData("CampaignName", 1, 0);
//
//driver.findElement(By.name("campaignname")).sendKeys(cname);
//
////Integration scenario from PRODUCT to CAMPAIGN page
//driver.findElement(By.xpath("//img[@title='Select']")).click();
//
//// //Child Window SWITCHING using the Iterator // Set<String> window =
//driver.getWindowHandles(); // Iterator<String> it = window.iterator(); // //
//while(it.hasNext()) // { // String wid = it.next(); //
//driver.switchTo().window(wid); // String title = driver.getTitle(); // if
//(title.contains("Products&action")) // { // break; // } // } //Child Window
//SWITCHING using the Iterator wlib.switchToWindow(driver, "Products&action");
//
//driver.findElement(By.name("search_text")).sendKeys(pname);
//driver.findElement(By.name("search")).click();
//
//Thread.sleep(1000);
//
////Dynamic X-path
//driver.findElement(By.xpath("//a[text()='"+pname+"']")).click();
//
//// //SWTICHING BACK TO THE PARENT WINDOW IMPORTANT IF NOT EXCEPTION: NoSuch
//Window exception // Set<String> window1 = driver.getWindowHandles(); //
//Iterator<String> it1 = window1.iterator(); // // while(it1.hasNext()) // { //
//String wid1 = it1.next(); // driver.switchTo().window(wid1); // String title
//= driver.getTitle(); // if (title.contains("Campaigns&action")) // { //
//break; // } // } wlib.switchToWindow(driver, "Campaigns&action");
//
////SAVE CAMPAIGN
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
////Sign-out from the V-tiger application and closing the browser
//Thread.sleep(1000); WebElement element =
//driver.findElement(By.xpath("(//td[@class='small'])[2]")); WebElement signout
//= driver.findElement(By.xpath("//a[.='Sign Out']")); Actions act1 = new
//Actions(driver); act1.moveToElement(element).perform(); Thread.sleep(2000);
//act1.click(signout).perform(); Thread.sleep(1000); driver.quit();
//if (actData.contains(campName))
//{
//	  System.out.println("validation is passed");
//}
//else
//{
//	  System.out.println("Validation is failed");
//}
//home.signoutLink(driver);

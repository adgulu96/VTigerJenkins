package products;

import org.testng.Assert;
import org.testng.annotations.Test;

import generics_Utility.BaseClass;
import generics_Utility.Excel_Utility;
import generics_Utility.Java_Utility;
import pageObject_Repository.Home_Page;
import pageObject_Repository.ProductCreation_Page;

public class CreateProduct extends BaseClass
{
	@Test (groups = {"regression","smoke"})
	public void createProduct() throws Throwable
	{
		//GENERICS PACKAGES INSTANCE CREATION
		 Excel_Utility elib = new Excel_Utility();
		 Java_Utility jlib = new Java_Utility();
		 
	 	Home_Page home = new Home_Page(driver);
	 	home.clickProductLink();
	 	ProductCreation_Page product = new ProductCreation_Page(driver);
	 	product.productCreateImage();
	 	int ranNum =jlib.getRandomNumber();
	 	String proName = elib.getExcelData("Product", 0, 0)+ranNum;
	 	product.productTextField(proName);
	 	product.saveButton();
	 	
	 	Assert.assertEquals(proName, proName);
	 	
//	 	ValidationAndVerification_Page validate = new ValidationAndVerification_Page(driver);
//	 	validate.Productdatavalidation(driver, proName);
	 	
	 	home.signoutLink(driver);
  	}	
}

//String key = "webdriver.chrome.driver";
//String value = "./src/main/resources/chromedriver.exe";
//System.setProperty(key, value);
////fetching data from the property file
//FileInputStream fis1 = new FileInputStream("./src/test/resources/PropertyData.properties");
//Properties pro = new Properties();
//pro.load(fis1);
//String URL=pro.getProperty("url");
//String USERNAME=pro.getProperty("username");
//String PASSWORD=pro.getProperty("password");
//System.setProperty(key, value);
////data fetched and store in the string as URL, USERNAME, PASSWORD
//driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//driver.findElement(By.id("submitButton")).click();
//driver.findElement(By.xpath("(//td[.='Products'])[1]")).click();
//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

//Random ran = new  Random();
//int ranNum = ran.nextInt(1000);

////fetching the data from excel
//FileInputStream fis = new FileInputStream("./src/test/resources/VtigerData.xlsx");
//Workbook book = WorkbookFactory.create(fis);
//Sheet sheet = book.getSheet("Product");
//Row row = sheet.getRow(0);
//Cell cell = row.getCell(0);
//String pname = cell.getStringCellValue()+ranNum;
// driver.findElement(By.name("productname")).sendKeys(pname);
// driver.findElement(By.name("button")).click();
// 
//	Thread.sleep(1000);
//	WebElement element = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
//	WebElement signout = driver.findElement(By.xpath("//a[.='Sign Out']"));
//	Actions act = new Actions(driver);
//	act.moveToElement(element).perform();
//	Thread.sleep(2000);
//	act.click(signout).perform();
//	Thread.sleep(1000);
//	driver.quit();	 
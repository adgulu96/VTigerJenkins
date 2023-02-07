package products;

import org.testng.annotations.Test;
import generics_Utility.BaseClass;
import generics_Utility.Excel_Utility;
import generics_Utility.Java_Utility;
import generics_Utility.WebDriver_Utility;
import pageObject_Repository.Home_Page;
import pageObject_Repository.ProductCreation_Page;

public class CreateDeleteProduct extends BaseClass
{
	@Test (groups = "regression")
	public void createDeleteProduct() throws Throwable
	{
		
	//IMPLEMENTING THE METHODS AND DATA FROM GENERIC PACKAGES (DDT & MDT)
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		
		int ranNum = jlib.getRandomNumber();
		String proName = elib.getExcelData("Product", 2, 0)+ranNum;
		
		Home_Page home = new Home_Page(driver);
		home.clickProductLink();
		
		//CREATING A NEW PRODUCT
		ProductCreation_Page product = new ProductCreation_Page(driver);
		product.productCreateImage();
		product.productTextField(proName);
		product.saveButton();
		
		product.deleteProductbutton();
	    wlib.switchToAlertAndAccept(driver);
	    home.signoutLink(driver);
	}
}


////Setting the PROPERTIES key and value for the CHROME driver
//String key = "webdriver.chrome.driver";
//String value = "./src/main/resources/chromedriver.exe";
//System.setProperty(key, value);
////Fetching the data from the PROPERTY FILE
//FileInputStream fis = new FileInputStream("./src/test/resources/PropertyData.properties");
//Properties pro = new Properties();
//pro.load(fis);
//String URL = pro.getProperty("url");
//String USERNAME = pro.getProperty("username");
//String PASSWORD = pro.getProperty("password");
////Instantiate the browser
//WebDriver driver = new ChromeDriver();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//driver.manage().window().maximize();
//Random ran = new  Random();
//int ranNum = ran.nextInt(1000);
//
////FETCHING THE PRODUCT NAME FROM THE EXCEL SHEET
//FileInputStream pfis = new FileInputStream("./src/test/resources/VtigerData.xlsx");
//Workbook book = WorkbookFactory.create(pfis);
//String pname = book.getSheet("Product").getRow(2).getCell(0).getStringCellValue()+ranNum;
//driver.findElement(By.xpath("(//td[.='Products'])[1]")).click();
//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
//driver.findElement(By.name("productname")).sendKeys(proName);
//driver.findElement(By.name("button")).click();
//driver.switchTo().alert().accept();
//Thread.sleep(1000);
//WebElement element = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
//WebElement signout = driver.findElement(By.xpath("//a[.='Sign Out']"));
//Actions act = new Actions(driver);
//act.moveToElement(element).perform();
//Thread.sleep(2000);
//act.click(signout).perform();
//Thread.sleep(1000);
//driver.quit();	
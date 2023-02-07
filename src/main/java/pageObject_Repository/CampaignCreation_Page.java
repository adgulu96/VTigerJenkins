package pageObject_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignCreation_Page 
{ 
	public CampaignCreation_Page(WebDriver driver) 
	{ 
		PageFactory.initElements(driver, this); 
	}
	
	//Declaration 
	@FindBy (xpath = "//a[text()='Campaigns']")
	private WebElement campaignlink;
	
	@FindBy(xpath="//img[@alt='Create Campaign...']") 
	private WebElement campaignCreateImage; 
	
	@FindBy(xpath="//input[@name='campaignname']") 
	private WebElement campaignTextField; 
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']") 
	private WebElement productSelectionImage; 
	
	@FindBy(xpath="//input[@id='search_txt']") 
	private WebElement productTextField; 
	
	@FindBy(css="input[name='search']") 
	private WebElement searchProductButton; 
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']") 
	private WebElement saveButton; 
	
	//getter methods
	
	public WebElement getCampaignCreateImage() 
	{ 
		return campaignCreateImage; 
	} 
	public WebElement getProductSelectionImage() 
	{ 
		return productSelectionImage; 
	} 
	public WebElement getProductTextField() 
	{
		return productTextField; 
	} 
	public WebElement getSearchProductButton() 
	{
		return searchProductButton; 
	} 
	public WebElement getCampaignTextField() 
	{ 
		return campaignTextField; 
	} 
	public WebElement getSaveButton() 
	{ 
		return saveButton; 
	} 
	
	//Business logics 
	public void clickoncampaignlink()
	{
		campaignlink.click();
	}
	public WebElement getCampaignlink() {
		return campaignlink;
	}
	public void campaignCreateImage() 
	{ 
		campaignCreateImage.click(); 
	} 
	public void campaignTextField(String campaignName) 
	{ 
		campaignTextField.sendKeys(campaignName); 
	} 
	public void saveButton() 
	{ 
		saveButton.click(); 
	}
	public void productSelectionImage(WebDriver driver) 
	{ 
		 Actions act=new Actions(driver); 
		 act.moveToElement(productSelectionImage).perform(); 
		productSelectionImage.click(); 
	} 
	public void productTextField(String ProductName) 
	{
		productTextField.sendKeys(ProductName); 
	} 
	public void searchProductButton(WebDriver driver,String productName) 
	{ 
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(productName);
		searchProductButton.click();
		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click(); 
	} 
  }


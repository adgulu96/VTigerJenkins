package pageObject_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreation_Page 
{ 
	public ProductCreation_Page(WebDriver driver) 
	{ 
		PageFactory.initElements(driver, this); 
	} 
	//Declaration
	@FindBy(xpath="//img[@alt='Create Product...']") 
	private WebElement productCreateImage; 
	
	@FindBy(xpath="//input[@name='productname']") 
	private WebElement productTextField; 
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']") 
	private WebElement saveButton; 
	
	@FindBy (xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement deletebutton;
	
	public WebElement getDeletebutton() {
		return deletebutton;
	}

	public WebElement getProductCreateImage() 
	{ 
		return productCreateImage; 
	} 
	//Getter methods 
	public WebElement getProductTextField() 
	{ 
		return productTextField; 
		} 
	public WebElement getSaveButton() 
	{ 
		return saveButton; 
	} 
	//Business Logics 
	public void productCreateImage() 
	{ 
		productCreateImage.click(); 
	} 
	
	//ProductName 
	public void productTextField(String ProductName) 
	{ 
		productTextField.sendKeys(ProductName); 
	} 
	//Save 
	public void saveButton() 
	{ 
		saveButton.click(); 
	} 
	public void deleteProductbutton()
	{
		deletebutton.click();
	}
}

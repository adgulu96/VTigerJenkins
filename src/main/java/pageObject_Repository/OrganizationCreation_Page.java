package pageObject_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreation_Page 
{
	@FindBy (xpath="//img[@alt='Create Organization...']")
	private WebElement createOrganizationButton;
	
	@FindBy (name = "accountname")
	private WebElement organizationNametextfield;
	
	@FindBy (xpath = "//img[@alt='Select']")
	private WebElement clickorganizationcreateimage;
	
	@FindBy (xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	//CONSTRUCTOR
	public OrganizationCreation_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrganizationButton() 
	{
		return createOrganizationButton;
	}

	public WebElement getOrganizationNametextfield() 
	{
		return organizationNametextfield;
	}

	public WebElement getClickorganizationcreateimage() 
	{
		return clickorganizationcreateimage;
	}

	public WebElement getSavebutton() 
	{
		return savebutton;
	}	
	
	//Bussiness logics
	public void CreateOrganizationbutton()
	{
		createOrganizationButton.click();
	}
	public void organizationNameTextfield(String orgName)
	{
		organizationNametextfield.sendKeys(orgName);
	}

	public void OrganizationnameTextfield(String orgName) 
	{
		organizationNametextfield.sendKeys(orgName);
	}
	public void ClickOrganizationCreateImage() 
	{
		clickorganizationcreateimage.click();
	}
	
	public void Save()
	{
		savebutton.click();
	}
	
	
}

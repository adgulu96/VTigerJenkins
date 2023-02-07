package pageObject_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page 
{
	//DECLARATION
	@FindBy(name="user_name")
	private WebElement usernametextfield;
	
	@FindBy(name="user_password")
	private WebElement passwordtextfield;
	
	@FindBy(id="submitButton")
	private WebElement loginbutton;
	
	//INITIALLIZATION
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
    //Getters methods
	public WebElement getUsernametextfield() {
		return usernametextfield;
	}

	public WebElement getPasswordtextfield() {
		return passwordtextfield;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	//BUSSINESS LOGICS
	public void loginToapp(String username, String password)
	{	
		usernametextfield.sendKeys(username);
		passwordtextfield.sendKeys(password);
		loginbutton.click();
	}
	
	
	
	
	
	
}

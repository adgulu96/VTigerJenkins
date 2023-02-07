package pageObject_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics_Utility.WebDriver_Utility;

	//DECLARATION
	public class Home_Page 
	{ 
		public Home_Page(WebDriver driver) 
		{ 
			PageFactory.initElements(driver, this); 
		} 
		//declaration
		@FindBy(linkText="Products")
		private WebElement productLinkText; 
		
		@FindBy(linkText="More") 
		private WebElement morelink;
		
		@FindBy(linkText="Campaigns") 
		private WebElement campaignsLinkText; 
		
		@FindBy(linkText="Organizations")
		private WebElement organizationLinkText; 
		
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") 
		private WebElement signoutImg;
		
		@FindBy(linkText="Sign Out") 
		private WebElement signoutLinkText;
		
		//getters methods 
		public WebElement getOrganizationLinkText() 
		{
			return organizationLinkText; 
		} 
		
		public WebElement getSignoutImg() 
		{
			return signoutImg; 
		} 
		public WebElement getSignoutLinkText() 
		{
			return signoutLinkText;
		}
		public WebElement getMorelink() 
		{
			return morelink; 
		}
		public WebElement getCampaignsLinkText() 
		{ 
			return campaignsLinkText; 
		}
		public WebElement getProductLinkText() 
		{
			return productLinkText; 
		} 
		
		//Business Logic for Product
		public void clickProductLink() 
		{
			productLinkText.click(); 
		}
		//Business Logic for More 
		public void moreLink(WebDriver driver) 
		{
			WebDriver_Utility wlib = new WebDriver_Utility(); 
			wlib.mouseMoveToElement(driver, morelink); 
			} 
		//Campaign 
		public void campaignLinkText() 
		{ 
			campaignsLinkText.click(); 
		}
		//Organization 
		public void clickOrganizationsLinkText() 
		{
			organizationLinkText.click(); 
		} 
		//Sign out
		public void signoutLink(WebDriver driver) 
		{ 
			Actions act=new Actions(driver); 
			act.moveToElement(signoutImg).perform(); 
			signoutLinkText.click(); 
		}
	}

	



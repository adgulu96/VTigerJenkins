package pageObject_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerification_Page 
{
	@FindBy (css="span.dvHeaderText")
	private WebElement actualOrganizationData;
	
	@FindBy(css="span.dvHeaderText")
	private WebElement actualCampaignData;
	
	@FindBy (id="dtlview_Campaign Name")
	private WebElement actualcampaignnamewithproductdata;
	
	@FindBy (css = "span.lvtHeaderText")
	private WebElement actualproductdata;

	public WebElement getCampaignnamewithproduct() {
		return actualcampaignnamewithproductdata;
	}

	public WebElement getActualCampaignData() {
		return actualCampaignData;
	}


	public WebElement getActualOrganizationData() 
	{
		return actualOrganizationData;
	}
	
	
	public ValidationAndVerification_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business Logic
	public void Organizationvalidation(WebDriver driver, String data)
	{
		String actData = actualOrganizationData.getText();
		if (actData.contains(data))
		{
			System.out.println("PASS"+" "+data);
		}
		else
		{
			System.out.println("FAIL");
		}
	}
	public void CampaignValidation(WebDriver driver, String data)
	{
		String actData = actualCampaignData.getText();
		if (actData.contains(data))
		{
			System.out.println("PASS"+" "+data);
		}
		else
		{
			System.out.println("FAIL");
		}
	}
	public void CampaignNamewithProductValidation(WebDriver driver, String data)
	{
		String actData = actualcampaignnamewithproductdata.getText();
		if (actData.contains(data))
		{
			System.out.println("PASS"+" "+data);
		}
		else
		{
			System.out.println("FAIL");
		}
	}
	public void Productdatavalidation(WebDriver driver, String data)
	{
		String actData = actualproductdata.getText();
		if (actData.contains(data))
		{
			System.out.println("PASS"+" "+data);
		}
		else
		{
			System.out.println("FAIL");
		}
	}
}

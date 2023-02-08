package generics_Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility 
{
	public static void flash(WebDriver driver, WebElement element)
	{
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		String bgcolor = element.getCssValue("backgroundColor");
		
		for (int i = 0; i < 20; i++)
		{
			changeColor("#000000", element, driver);
			changeColor(bgcolor, element, driver);
		}
	}
	public static void changeColor(String color, WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
		try 
		{
			Thread.sleep(20);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public static void drawBorder(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'",element);
	}
	public static String getTitleByJS(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	public static void clickOnElementJS(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	//GENERATING THE ALERT INFO USING THE JAVASCRIPT
	public static void generateAlert(WebDriver driver, String message)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert (' " +message+ " ' ) ");
	}
	//REFRESHING THE PAGE USING THE JS EXECUTOR
	public static void refreshBrowserJS(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	//SCROLLING THE PAGE USING JS
	public static void scrollIntoView(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}

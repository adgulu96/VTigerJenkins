package generics_Utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility 
{
	/**
	 * Used to MAXIMIZE the window screen
	 * @param driver
	 */
	public void maximizeScreen(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * Wait for the page to load before identifying any sychronized element in DOM
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver , int seconds)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
//	/**
//	 * After every action it will wait for next action to perform
//	 */
//	public void scriptTimeout(WebDriver driver)
//	{
//		driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(20));
//	}
	
	/**
	 * Used to wait for the element to be clickable in GUI and check for specific element for every 500ms
	 */
	public void waitforElementWithCustomTimeout(WebDriver driver, WebElement Element, int pollingTime)
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofSeconds(pollingTime));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	/**
	 * Used to switch to any window based on window title
	 * @param driver
	 * @param PartialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String PartialWindowTitle)
	{
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			if (driver.getTitle().contains(PartialWindowTitle))
			{
				break;
			}
		}
	}
	/**
	 * Used to switch to AlertWindow and ACCEPT (Click on ok button)
	 * @param driver
	 */
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * Used to switch to AlertWindow and DISMISS (Click on cancel button)
	 * @param driver
	 */
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * Used to switch to frame window based on index
	 * @param driver
	 * @param index
	 * @author das_a
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}

	/**
	 * Used to switch to frame window based on id or name attribute
	 * @param driver
	 * @param id_name_Attribute
	 */
	public void  switchToFrame(WebDriver driver, String id_name_Attribute)
	{
		driver.switchTo().frame(id_name_Attribute);
	}
	
	/**
	 * Used to select the value from the DROPDOWN based on the index
	 * @param element
	 * @param index
	 */
	public void selectByValue(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	
	/**
	 * Used to select the value from the DROPDOWN List based on the text
	 * @param element
	 * @param text
	 */
	public void selectByText(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * Used to select by the INDEX from the dropdown list 
	 * @param element
	 * @param index
	 */
	public void selectbyIndex(WebElement element , int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * deselect by value
	 * @param element
	 */
	public void deselectbyvalue(WebElement element )
	{
		Select select=new Select(element);
		select.deselectAll();
	}
	
	/**
	 * Deselect by the visible text entered
	 * @param element
	 * @param text
	 */
	public void deselectbyvisibletext(WebElement element , String text)
	{
		Select select=new Select(element);
		select.deselectByVisibleText(text);
	}
	
	/**
	 * Deselect By the INDEX value
	 * @param element
	 * @param index
	 */
	public void deselectbyIndex(WebElement element , int index)
	{
		Select select=new Select(element);
		select.deselectByIndex(index);
	}
	/**
	 * To check whether the dropdown list is single select or multi select
	 * @param element
	 */
	public void isMultiple(WebElement element)
	{
		Select select=new Select(element);
		select.isMultiple();
	}
	
	/**
	 * Used to place the mouse cursor on the specific element
	 * @param driver
	 * @param element
	 */
	public void mouseMoveToElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * Used to right click / context click on the specific element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void moveByoffset(WebDriver driver, int x,int y)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}
	/**
	 * Left click mouse operation
	 * @param driver
	 * @param element
	 */
	public void mouseClickOperation(WebDriver driver , WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.click(element).perform();
	}
	/**
	 * double click mouse operation
	 * @param driver
	 * @param element
	 */
	public void mouseDoubleClickOperation(WebDriver driver , WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	/**
	 * Mouse drag and drop operation
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void mousedragAndDrop(WebDriver driver , WebElement source,WebElement target)
	{
		Actions actions=new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}
	/**
	 * Mouse click and hold operation
	 * @param driver
	 * @param element
	 */
	public void mouseclickAndHold(WebDriver driver , WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.clickAndHold(element).perform();
	}
	/**
	 * Mouse release operation
	 * @param driver
	 * @param element
	 */
	public void mouseReleaseOperation(WebDriver driver , WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	/**
	 * Robot class to handle file upload and download
	 * @throws AWTException
	 */
	public void robotenter() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * Javascript click operation
	 * @param driver
	 * @param element
	 */
	public void javascriptclick(WebDriver driver , WebElement element) 
	  {
	  	JavascriptExecutor js=(JavascriptExecutor)driver;
	  	js.executeScript("arguments[0].click()", element); 
	  }
	/**
	 * Javascript click by using the BY class webelement
	 * @param driver
	 * @param element
	 */
	public void javascriptclick(WebDriver driver , By element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	public void explicitwaittitleis(WebDriver driver , String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleIs(title));
	}
	
	public void explicitwaittitleContains(WebDriver driver , String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void explicitwaitUrlContains(WebDriver driver , String url)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.urlContains(url));
	}
	public void explicitwaitVisibilityof(WebDriver driver , WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void explicitwaitvisibilityofelementlocatedbylocator(WebDriver driver , By element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
//	public void hardAssertvalidatetitle(WebDriver driver , String expectedtitle)
//	{
//		String actualTitle=driver.getTitle();
//		String expectedTitle=expectedtitle;
//		Assert.assertEquals(actualTitle, expectedTitle);
//	}
//	
//	public void assertNotEquals(WebDriver driver , String expectedtitle)
//	{
//		String actualTitle=driver.getTitle();
//		String expectedTitle=expectedtitle;
//		Assert.assertNotEquals(actualTitle, expectedTitle);
//	}
//	
//	public void validatetext(WebElement element , String expectedtext)
//	{
//		String actualText=element.getText();
//		String expectedText=expectedtext;
//		Assert.assertEquals(actualText, expectedText);
//	}
	
}

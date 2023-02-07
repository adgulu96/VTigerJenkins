package generics_Utility;

import java.io.File;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClass implements ITestListener
{

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) 
	{
	}

	public void onTestFailure(ITestResult result) 
	{
		TakesScreenshot ts = (TakesScreenshot)BaseClass.driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String name = result.getName();
		java.util.Date date = Calendar.getInstance().getTime();
		String today = date.toString().replace(":", "-");
		File destFile = new File("./failedScreenshot/"+name+today+".png");
		
		try 
		{
			FileUtils.copyFile(srcFile, destFile);	
		} 
		catch (Exception e) {
		}
	}

	public void onTestSkipped(ITestResult result) 
	{	

		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
	}
	
}

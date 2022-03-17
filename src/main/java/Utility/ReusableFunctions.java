package Utility;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class ReusableFunctions 
{
	Reporting report=new Reporting();
	public void enterText(WebElement wbe,String inputText,String reportDescription) throws IOException
	{
		wbe.sendKeys(inputText);
		if(wbe.getAttribute("value").isEmpty())
		report.reports().fail(reportDescription+"not entered");
		else
		report.reports().pass(reportDescription+"entered successfully");
	}
	public void clickAction(WebElement wbe,String expected,String reportDescription)
	{
	wbe.click();
	}
	public void displayVerification(WebElement wbe, String description) throws IOException
	{
	try
	{
		if(wbe.isDisplayed())
			report.reports().pass(wbe+"is displayed");
		report.reports().addScreenCaptureFromPath("ScreenShots/description");
			
	}
	 catch (Exception e) 
	{
		report.reports().fail(wbe+"is not displayed");
	}
	}

}

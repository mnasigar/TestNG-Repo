package Utility;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporting 
{
public  ExtentTest reports() throws IOException
{
ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("Reports/HomePage.html");
	 ExtentReports extent=new ExtentReports();
	 extent.attachReporter(htmlReporter);
	 
	 ExtentTest test=extent.createTest("MyFirstTest", "Sample Description");
	 test.log(Status.INFO, "This step shows usage of log(status,detailes)");
	 test.pass("This step shows usage of info(details)");
	 test.addScreenCaptureFromPath("screenshot.png");
	 
	 extent.flush();
	 return test;
}
}

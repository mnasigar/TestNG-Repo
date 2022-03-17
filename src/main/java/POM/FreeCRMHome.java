package POM;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BrowserInit;
import Utility.ReusableFunctions;

public class FreeCRMHome extends BrowserInit
{
	
	@FindBy(how = How.XPATH, using = "//a[text()=\'Login']")
	WebElement loginLink;
	
	@FindBy(how = How.XPATH, using = "//a[text()=\"Sign Up\"]")
	WebElement signUpLink;
	
	public FreeCRMHome(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	ReusableFunctions allFunc=new ReusableFunctions();
	
public void linksVerify() throws IOException
{
	allFunc.displayVerification(loginLink, "Login Link");
	allFunc.displayVerification(signUpLink, "SignUp Link");
		
}
public void clickLogin()
{
	allFunc.clickAction(loginLink, "Should navigate to credentials entry page", "Clicked on login link");
}
public void login()
{

}
}

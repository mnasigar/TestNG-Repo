package POM;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Utility.DataRead;
import Utility.ReusableFunctions;

public class CredentialsEntry
{
	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	WebElement txtemail;
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	WebElement txtpassword;
	@FindBy(how = How.XPATH, using = "//div[text()=\"Login\"]")
	WebElement btnLogin;
	
	public CredentialsEntry(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	ReusableFunctions allFunc=new ReusableFunctions();
	
//	public CredentialsEntry()
//	{
//		
//	}
	
	public void userNameAndPassword() throws IOException
	{
		DataRead data=new DataRead();
		HashMap<String,String> credentials=data.readExcelFile("Micheal");
		allFunc.enterText(txtemail, credentials.get("email"),"Email id entry");
		allFunc.enterText(txtpassword, credentials.get("password"),"Password entry");
		
	}
	public void clickLogin()
	{
	allFunc.clickAction(btnLogin, "Should redirect to user homepage","Clicked on Login button");
	}
}

package FreeCRMBasicFunctinality;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import BaseClass.BrowserInit;
import POM.CredentialsEntry;
import POM.FreeCRMHome;
import Utility.DataRead;

public class VerifyAllLinksInLoginPage 
{

	@Test
	public void checkLinks() throws IOException
	{
		BrowserInit init=new BrowserInit();
		WebDriver driver=init.initRequiredBrowser("CR");
		init.browserPreConditions(DataRead.readPropertiesFile().getProperty("url"));
		
		FreeCRMHome homepage=new FreeCRMHome(driver);
		homepage.linksVerify();
		homepage.clickLogin();
		

		CredentialsEntry entry=new CredentialsEntry(driver);
		entry.userNameAndPassword();
		entry.clickLogin();
	}
	}
	


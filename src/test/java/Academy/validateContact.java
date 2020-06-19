package Academy;




import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;
//Adding logs
//Downloading html reports
//Screenshot on failure
//Jenkins integration


public class validateContact extends base{
	public WebDriver driver;   //when tests are run in parallel no one over rights the other because we have the driver now locally
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException 
	{
		driver=initializeDriver();                  //this should execute before actual declaration
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	
	public void validateAppContact() throws IOException
	{
		
		LandingPage l=new LandingPage(driver);
		//compare the text from the browser with actual text --Error  Use Assert. for this use assert.assertEquals
		AssertJUnit.assertTrue(l.getContact().isDisplayed());  //argument should always be true if not test will fail
		log.info("Contact is displayed");
				
			
	}
	
	@AfterTest
	public void teardown()      //This closes open browsers
	{
		driver.close();
	}
}

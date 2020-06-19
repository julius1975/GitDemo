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

public class validateTitle extends base{
	public WebDriver driver;   //This help have the initializeDriver locally so that no test is over right when running tests in parallel
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	
	@BeforeTest
	public void initialize() throws IOException 
	{
		driver=initializeDriver();                  //this should execute before actual declaration
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigate to the Home Page");
	}
	
	@Test
	
	public void validateAppTitle() throws IOException
	{
		LandingPage l=new LandingPage(driver);
		//compare the text from the browser with actual text --Error  Use Assert. for this use assert.assertEquals
		AssertJUnit.assertEquals(l.getTitle().getText(), "FEATURED COU123RSES");
		log.info("Successfully validated text message");
		System.out.println("Test Completed");	
	}
	
	@AfterTest
	public void teardown()      //This closes open browsers
	{
		driver.close();
	}
}

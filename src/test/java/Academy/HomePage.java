package Academy;




import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	
	public WebDriver driver;
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException 
	{
		driver=initializeDriver();                  
		
	}
	
	
	@Test(dataProvider="getData")
	
	public void basePageNavigation(String Username,String Password,String text) throws IOException
	{
		driver.get(prop.getProperty("url"));
		LandingPage l=new LandingPage(driver);
		LoginPage lp=l.getLogin();  //the return lp from the landingPage is capture here
	//	LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		//System.out.println(text);
		log.info(text);
		
		lp.getLogin().click();
		ForgotPassword fp=lp.forgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.sendMeInstructions().click();
				
			
	}
	@AfterTest
	public void teardown()      //This closes open browsers
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3];
		//0th row
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="12345";
		data[0][2]="Restricted User";
		//1st row
		data[1][0]="Restricteduser@qw.com";
		data[1][1]="56789";
		data[1][2]="Non restricted User";
		
		return data;
	}
}

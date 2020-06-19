package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	private By signin=By.xpath("//span[contains(text(),'Login')]");
	private By title=By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By contact=By.xpath("//a[contains(text(),'Contact')]");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public LoginPage getLogin()  //we can bring the click here so that after getting the signin we can click into the landing page
	{
		driver.findElement(signin).click();
		LoginPage lp=new LoginPage(driver); //we have lp object which should be return for test cases to use
		return lp;   //return type should be LoginPage
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getContact()
	{
		return driver.findElement(contact);
	}

}

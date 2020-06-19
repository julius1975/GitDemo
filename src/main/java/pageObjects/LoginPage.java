package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	//By email=By.xpath("//input[@id='user_email']");
	By email=By.cssSelector("//input[@id='user_email']");
	By password=By.xpath("//input[@type='password']");
	By login=By.xpath("//input[@name='commit']");
	By forgotPassword =By.xpath("//a[@class='link-below-button']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public ForgotPassword forgotPassword()
	{
		driver.findElement(forgotPassword).click();
		return new ForgotPassword(driver);
	//	ForgotPassword fp=new ForgotPassword(driver);  This two steps can be combine to return new ForgotPassword(driver)
	//	return fp;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
}

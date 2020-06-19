package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalHomePage {

	public WebDriver driver;
	
	//By email=By.xpath("//input[@id='user_email']");
	By searchBox=By.name("query");
	
	
	public portalHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	
	public WebElement getsearchBox()
	{
		return driver.findElement(searchBox);
	}
	
}

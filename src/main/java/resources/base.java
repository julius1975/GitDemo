package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {

	public  WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
 prop= new Properties();
 //System.getProperty("user.dir") gives the directory of your project in your local machine whereas the rest is common to all machines
FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");

prop.load(fis);
//mvn test -Dbrower=chrome
String browserName=System.getProperty("browser"); //code will check in maven if there is any property define with browser.

//String browserName=prop.getProperty("browser");
System.out.println(browserName);

if(browserName.contains("chrome"))
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Downloads\\chromedriver.exe");
	//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");

	ChromeOptions options=new ChromeOptions();
	 if(browserName.contains("headless"))
	 {
 		options.addArguments("headless");
	 }				
	driver= new ChromeDriver(options);
		//execute in chrome driver
	
}
else if (browserName.equals("firefox"))
{
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Owner\\Downloads\\geckodriver.exe");
	 driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("IE"))
{
//	IE code
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;


}

public String getScreenShotPath(String TestCaseName,WebDriver driver) throws IOException  //the TestCaseName will come from the listener
{
	TakesScreenshot ts=(TakesScreenshot) driver; //create variable ts to takescreenshot
	File source=ts.getScreenshotAs(OutputType.FILE); //get the output of the screenshot as a file and store it in source
	//String destinationFile =System.getProperty("user.dir", def)  // gives the directory of you current project
	String destinationFile =System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png";
	//the name of the screenshot equals the name of the test that would fail but how do we know the test that will fail
	FileUtils.copyFile(source,new File(destinationFile));  //it throws an error so copy the apache common io in your pom to eliminate this error
	                                      //https://mvnrepository.com/artifact/commons-io/commons-io/2.6
	
	return destinationFile; //since it stores the image capture and the return makes it available for other classes
}

}

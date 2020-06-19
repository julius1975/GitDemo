package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener {  //extends base for getScreenShotPath to work

	ExtentReports extent=ExtentReporterNG.getReporterObject();
	ExtentTest test;  //making it global
	ThreadLocal<ExtentTest>  extentTest =new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test=extent.createTest(result.getMethod().getMethodName()); //but listener does not know extent so we need to call getReporterObject here
		 extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {  //This block is executed when test is success
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");  
	}

	@Override
	public void onTestFailure(ITestResult result) {  //This block is executed when test fails
		// TODO Auto-generated method stub
		
		extentTest.get().fail(result.getThrowable());  //gets the fail result into your log
		//Screenshot code can be included here
		WebDriver driver =null;
		String testMethodName=result.getMethod().getMethodName();  //gets the name of the fail method
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}catch(Exception e)
		{
			
		}
		
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {    //executed after all your test cases are executed
		// TODO Auto-generated method stub
		extent.flush();
	}

}

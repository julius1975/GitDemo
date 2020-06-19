package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports extent; //since method is static
	
	public static ExtentReports getReporterObject()  //once you make a method static then all the variables in it should also be static
	{
		// ExtentReports , ExtentSparkReporter which provide the path of the extent report.
		//To get the path use user.dir which points to your project path plus the the location you want to create for the report for \\reports\index.html
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Julius Ndasi");
		
		return extent;
		
		
	}
	
}

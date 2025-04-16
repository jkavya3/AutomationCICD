package TestNG;

import org.testng.IClassListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtenReportManager implements IClassListener {
	
	public ExtentSparkReporter sparkReproter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart (ITestContext context)
	{
		sparkReproter = new ExtentSparkReporter (System.getProperty("user.dir")+ "/reports/myReport.html");
		sparkReproter.config().setDocumentTitle("Automation Report");
		sparkReproter.config().setReportName("Functional Testing");
		sparkReproter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReproter);
		extent.setSystemInfo("Computer Name","Local host");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Tester Name","Kavya");
		extent.setSystemInfo("OS","Windows 10");
		extent.setSystemInfo("Browser Name","Chrome");
		
	}
	
	public void onTestSuccess (ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS,"Test case passed is:" +result.getName());
	}
	

	public void onTestFailure (ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL,"Test case passed is:" +result.getName());
		test.log(Status.FAIL,"Test case passed is:" +result.getThrowable());
	}
	
	public void onTestSkipped (ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP,"Test case passed is:" +result.getName());
		
	}
	
	public void onFinish (ITestContext context)
	{
		extent.flush();
	}
	}
	


package FrameWorkDesign.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import FrameWorkDesign.resources.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener {
	
	ExtentTest  test;
	ExtentReports extent = ExtentReportNG.getReportObject();
	ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();
	
	
	public void onTestStart (ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);//unique thread id
	}
	
	public void onTestSuccess (ITestResult result) {
		test.log(Status.PASS,"Test Passed");
	}
	

	public void onTestFailure (ITestResult result) {
		extenttest.get().fail(result.getThrowable());
		try {
		driver= (WebDriver) result.getTestClass().getRealClass().getField("driver")
				.get(result.getInstance());
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String filepath = null;
		try {
			filepath = getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extenttest.get().addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
		
		
	}
	
	
	public void onTestSkipped (ITestResult result) {
		
		
	}
	
	public void onFinish (ITestContext context)
	{
		extent.flush();
	}
}

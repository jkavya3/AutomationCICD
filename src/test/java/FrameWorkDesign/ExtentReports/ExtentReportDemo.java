package FrameWorkDesign.ExtentReports;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtentReportDemo {
	
	
	 ExtentReports extent;
	 WebDriver driver;
	
	@BeforeTest
	public void config()
	{
		//main classes of Extentreport are Extent Reports, ExtentSparkReporter-creates html file amkes configurations
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
	    ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	    reporter.config().setReportName("Web Automation Report");
	    reporter.config().setDocumentTitle("Test Results");
	    
	    extent = new ExtentReports();
	    extent.attachReporter(reporter);
	    extent.setSystemInfo("Tester", "Kavya");
	    
	    
	    
	}
	
	@Test
	public void IntialDemo()

	{
		extent.createTest("Initial Test");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
	    System.out.println(driver.getTitle());
	    //test.fail("Result donot match");
	    extent.flush();
	   
	}
}

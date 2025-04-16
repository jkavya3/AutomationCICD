package TestNG;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class invalidLogin {
	WebDriver driver;
	
	@BeforeSuite
	 void suite()
	 {
		System.out.println("Login Validation Before suite invalid login");
	 }
	

	@AfterSuite
	 void suite1()
	 {
		System.out.println("Login Validation After suite invalid login");
	 }
	
	@BeforeTest
	 void test()
	 {
		System.out.println("Login Validation Before each Test in invalid login");
	 }
	

	@AfterTest
	 void test1()
	 {
		System.out.println("Login Validation After each Test invalid login");
	 }
	
	@BeforeMethod
	 void method()
	 {
		System.out.println("Login Validation Before each method in invalid login");
	 }
	

	@AfterMethod
	 void method1()
	 {
		System.out.println("Login Validation After each method in invalid login");
	 }
	
	@BeforeClass
	public void setUp()
	{
	
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		System.out.println("Browser Invoked before class invalid Login");
		
	}
	
	@Test(priority=3,groups= {"Regression"})
	public void TestLogin1()
	{
		
		LoginLogoutpage lp = new LoginLogoutpage(driver);
		lp.setUsername("incorrectUser");
		lp.setPassword("Password123");
		lp.clickLogin();
		SoftAssert sa= new SoftAssert();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='error']")).getText(),"Your username is invalid!");
		System.out.println("Invalid Login validation successful for username");
		System.out.println("Invalid Login validation successful for username1");
         sa.assertAll();
				}
	
	@Test(priority=4,groups= {"Regression"})
	public void TestLogin2()
	{
		
		LoginLogoutpage lp = new LoginLogoutpage(driver);
		lp.setUsername("student");
		lp.setPassword("incorrectPassword");
		lp.clickLogin();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='error']")).getText(),"Your password is invalid!");
		System.out.println("Invalid Login validation successful for password");
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
		System.out.println("Browser closed after class invalid Login");
	}	
	

}

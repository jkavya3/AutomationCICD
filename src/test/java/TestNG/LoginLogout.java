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

public class LoginLogout {
	
	WebDriver driver;
	
	@BeforeSuite
	 void suite()
	 {
		System.out.println("Login Validation Before suite");
	 }
	

	@AfterSuite
	 void suite1()
	 {
		System.out.println("Login Validation After suite");
	 }
	
	@BeforeTest
	 void test()
	 {
		System.out.println("Login Validation Before each Test");
	 }
	

	@AfterTest
	 void test1()
	 {
		System.out.println("Login Validation After each Test");
	 }
	
	@BeforeMethod
	 void method()
	 {
		System.out.println("Login Validation Before each method");
	 }
	

	@AfterMethod(groups= {"Sanity"})
	 void method1()
	 {
		System.out.println("Login Validation After each method");
	 }
	
	@BeforeClass(groups= {"Sanity"})
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		System.out.println("Browser Invoked before class valid Login");
		
	}
	
	@Test(priority=2,groups= {"Sanity"})
	public void TestLogin()
	{
		
		LoginLogoutpage lp = new LoginLogoutpage(driver);
		lp.setUsername("student");
		lp.setPassword("Password123");
		lp.clickLogin();
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Logged In Successfully']")).getText(),"Logged In Successfully");
		System.out.println("Login validation successful");
		System.out.println("Login validation successful23");
				}
	
	@Test (priority=3,dependsOnMethods = {"TestLogin"},groups= {"Sanity","Functional"})
	public void logout()
	{
		LoginLogoutpage lp = new LoginLogoutpage(driver);
		lp.clickLogout();
		Assert.assertTrue(true);
		System.out.println("Successfully Logged out");
		
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
		System.out.println("Browser closed after class valid Login");
	}
	

}

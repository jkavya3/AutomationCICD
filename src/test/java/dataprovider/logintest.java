package dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestNG.LoginLogoutpage;

public class logintest {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		System.out.println("Browser Invoked before class valid Login");
		
	}
	
	@Test (dataProvider="dp")
	
		void testlogin (String username,String Password)
		{
		
		LoginLogoutpage lp = new LoginLogoutpage(driver);
		lp.setUsername("username");
		lp.setPassword("Password");
		lp.clickLogin();
		boolean status = driver.findElement(By.xpath("//h1[text()='Logged In Successfully']")).equals("Logged In Successfully");
		Assert.assertEquals(status,true);
	
		
		if(status==true)
		{
			lp.clickLogout();
			Assert.assertTrue(true);
			System.out.println("Logged out");
		}
		else {
			Assert.assertEquals(driver.findElement(By.xpath("//div[@id='error']")).getText(),"Your username is invalid!");
			System.out.println("Login not valid");
		}
		
		}
	
	    @AfterClass
	    void teardown()
	    {
	    	driver.quit();
	    }
	    
	    @DataProvider (name="dp")
	    Object[][] logindata()
	    {
	    Object data[][]= {
	    		{"student","Password123"},
	    		{"incorrectUser","Password123"},
	    		{"student","incorrectPassword"},
	    };
	    
	    return data;
	    }
	    
	    

}

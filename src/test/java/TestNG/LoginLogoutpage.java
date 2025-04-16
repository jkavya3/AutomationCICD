package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginLogoutpage  {
	 
	WebDriver driver;
	
	 //Creating constructor that initalizes the driver
	
	public LoginLogoutpage (WebDriver driver){
		   
		   this.driver=driver;
	   }
	
	
	//Locators
	 
	 By username_loc = By.xpath("//input[@id='username']");
	 By Password_loc = By.xpath("//input[@id='password']");
	 By Login_btn =  By.xpath("//button[@id='submit']");
	 By Logout_btn= By.xpath("//a[text()='Log out']");
	 By Login_valid= By.xpath("//h1[text()='Logged In Successfully']");
	 By Login_invalid= By.xpath("//div[@id='error']");
	 
	 	 
	 // Action Methods
	 
			public void setUsername(String user)
		{
			driver.findElement(username_loc).sendKeys(user);
		}
			
			public void setPassword(String pwd)
			{
				driver.findElement(Password_loc).sendKeys(pwd);
			}
			
			public void clickLogin()
			{
				driver.findElement(Login_btn).click();
			}
			public void clickLogout()
			{
				driver.findElement(Logout_btn).click();
			}
			
			public void loginvalidation()
			{
				System.out.println(driver.findElement(Login_valid).getText());
				
				
			}



}

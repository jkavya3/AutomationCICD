package FrameWorkDesign.PageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameWorkDesign.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements (driver,this);  
	}
	
		
	//Landing Page Locators
	
	@FindBy(id="userEmail")
	WebElement username;
	
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public ProductCatalouge loginApplication (String uname,String pwd) {
		
		username.sendKeys(uname);
		password.sendKeys(pwd);
		submit.click();
		ProductCatalouge productcatalouge= new ProductCatalouge (driver);
		return productcatalouge;
	}
	
	public String getErrorMessage() {
		waitForElementToAppear(errorMessage);
		return errorMessage.getText();
	}

	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
		
	}
}

	

package FrameWorkDesign.PageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import FrameWorkDesign.AbstractComponents.AbstractComponent;

public class checkOutPage extends AbstractComponent {

	
		WebDriver driver;
		public checkOutPage (WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements (driver,this);  
		}
		
		@FindBy(xpath="//input[@placeholder='Select Country']")
		WebElement country;
		
		@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
		WebElement SelectCountry;
		
		@FindBy(xpath="//a[contains(@class,'action__submit')]")
		WebElement submit;
		
		By results =  By.xpath("//section[contains(@class,'ta-results')]");
		
		//Action Methods
		
		public void countrySelect(String Countryname) {
			Actions act= new Actions(driver);
			act.sendKeys(country,Countryname).build().perform();				
			waitForElementToAppear(results);					
			SelectCountry.click();
		}
			//placing the order
			
		public ConfirmationPage SubmitOrder() {
			submit.click();
			ConfirmationPage confirmationpage = new ConfirmationPage(driver);
			return confirmationpage;
			
		}
			
		
	}


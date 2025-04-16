package FrameWorkDesign.PageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import FrameWorkDesign.AbstractComponents.AbstractComponent;

public class cartPage extends AbstractComponent{
      
	WebDriver driver;
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements (driver,this);  
	}
	
	@FindBy(xpath="//div[contains(@class,'cartSection')]/h3")
	List <WebElement> cartproducts;
	
	@FindBy(xpath="//li[contains(@class,'totalRow')]/button")
	WebElement checkOutEle;
	
	public boolean verifyProductDisplay(String productname)
	{
		boolean match = false;
		for(WebElement cp:cartproducts)
		{
			match = cp.getText().equalsIgnoreCase(productname);
			 
		}
		
		return match;
	}
	
	public checkOutPage goTocheckOut()
	{
		checkOutEle.click();
		checkOutPage checkoutpage = new checkOutPage(driver);
		return checkoutpage;
	}
	
	}



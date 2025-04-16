package FrameWorkDesign.PageObjectClasses;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameWorkDesign.AbstractComponents.AbstractComponent;

public class ProductCatalouge extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductCatalouge(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements (driver,this);  
	}
	
	//Locators
	
	@FindBy(xpath="//div[contains(@class,'mb-3')]/div[contains(@class,'card')]/div/h5/b")
	List <WebElement> products;
	
	@FindBy(xpath="//div[contains(@class,'mb-3')]/div[contains(@class,'card')]/div/button[contains(@class,'btn w-10 rounded')]")
	List <WebElement> AddCart;
	
	By toastmessage =  By.cssSelector("#toast-container");
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	//ActionMethods
	

	public void AddToCart(String productname) {
		
		for(int i=0;i<=products.size()-1;i++)
		{
		
		String prods = products.get(i).getText();
		
	
		if (productname.contains(prods))
		{
			AddCart.get(i).click();
			
		}
		 		  
		}
		waitForElementToAppear(toastmessage);
		waitForElementToDisappear(spinner);
		
	}
	

	

}


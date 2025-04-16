package FrameWorkDesign.PageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameWorkDesign.AbstractComponents.AbstractComponent;

public class ordersPage extends AbstractComponent {

	WebDriver driver;
	public ordersPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath = "//table[contains(@class,table)]//tr")
	List <WebElement> tablerows;
	
	
	
	public boolean VerifyOrderDisplay(String productname) {
		boolean ordermatch=false;
		
		int rows= tablerows.size();
		
		for(int r=1;r<rows;r++)
		{
		
			ordermatch =  driver.findElement(By.xpath("//table[contains(@class,table)]//tr["+r+"]//td[2]")).getText().equalsIgnoreCase(productname);
			
		}
		return ordermatch;
	}
	
		
	}

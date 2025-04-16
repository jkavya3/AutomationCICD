package FrameWorkDesign.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import FrameWorkDesign.PageObjectClasses.cartPage;
import FrameWorkDesign.PageObjectClasses.ordersPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements (driver,this);  
	}
	
	@FindBy(css= "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css= "[routerlink*='myorders']")
	WebElement ordersHeader;

	public void waitForElementToAppear(By findBy) {
		
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToAppear(WebElement findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		}
	
	public void waitForElementToDisappear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public cartPage goToCart()

	{
		cartHeader.click();
		cartPage cartpage = new cartPage(driver);
		return cartpage;
	}
	
	public ordersPage goToOrdersPage() {
		ordersHeader.click();
		ordersPage orderpage = new ordersPage(driver);
		return orderpage;
	}
}

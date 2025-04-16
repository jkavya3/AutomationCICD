package selday3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mousehover {

	public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
	
	/*//mousehover
	WebElement mousehover = driver.findElement(By.xpath("//div[@class='dropdown']//button[@class='dropbtn']"));
	Thread.sleep(5000);
	Actions act = new Actions(driver);
	act.moveToElement(mousehover).build().perform();
	Thread.sleep(5000);
	WebElement mob = driver.findElement(By.xpath("//div[@class='dropdown-content']//a[contains(text(),'Mobiles')]"));
	act.moveToElement(mob).click();
	act.build().perform();*/
	
	//double click
	WebElement box1 = driver.findElement(By.xpath("//input[@id='field1']"));
	WebElement box2 = driver.findElement(By.xpath("//input[@id='field2']"));
	WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
	
	box1.clear();
	box1.sendKeys("Welcome");
	Actions act = new Actions(driver);
	act.doubleClick(button).perform();
	
	//drag and drop
	WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
	WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
	act.dragAndDrop(drag,drop).perform();
	}

}

package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExpWaitHelper {
	
	public static void main(String[] args) {
	
	WebDriver driver =new ChromeDriver();
	WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
	driver.get("https://testautomationpractice.blogspot.com");
	driver.manage().window().maximize();
	WebElement txt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='wikipedia-search-input']")));
	txt.sendKeys("cakes");
	driver.findElement(By.xpath("//input[@class='wikipedia-search-button' and @type='submit']")).click();
	System.out.println("clicked");
	}
	
}

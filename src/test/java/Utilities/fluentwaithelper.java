package Utilities;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.FluentWait;



public class fluentwaithelper {
	

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		FluentWait <WebDriver> mywait = new FluentWait <WebDriver> (driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)) 
				.ignoring(TimeoutException.class);
		
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
        WebElement txt = mywait.until(new Function<WebDriver,WebElement> (){
        	public WebElement apply(WebDriver driver) {
        
        return driver.findElement(By.xpath("//input[@class='wikipedia-search-input']"));
        	}
        });
    	txt.sendKeys("cakes");
    	driver.findElement(By.xpath("//input[@class='wikipedia-search-button' and @type='submit']")).click();
    	System.out.println("clicked");
	}

}

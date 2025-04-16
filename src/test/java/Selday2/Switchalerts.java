package Selday2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Switchalerts {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.findElement(By.xpath("//div[@class='widget-content']//button[@id='alertBtn']")).click();
	   driver.switchTo().alert().accept();
	   driver.findElement(By.xpath("//div[@class='widget-content']//button[@id='confirmBtn']")).click();
	   driver.switchTo().alert().dismiss();
	   driver.findElement(By.xpath("//div[@class='widget-content']//button[@id='confirmBtn']")).click();
	   driver.switchTo().alert().dismiss();
	   
	 
	}

}

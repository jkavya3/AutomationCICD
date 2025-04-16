package selday1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hiddendropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver =new ChromeDriver();
		//driver.get("https://testautomationpractice.blogspot.com");https://www.flipkart.com/
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("cakes");
		Thread.sleep(5000);
		WebElement option= driver.findElement(By.xpath("//ul[@class='_1sFryS _2x2Mmc']//li//div[contains(@class,'YGcVZO')]"));
		
		System.out.println  (option.getText());
		
		
			}

}

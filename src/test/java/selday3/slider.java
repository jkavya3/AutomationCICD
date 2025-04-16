package selday3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class slider {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Actions act=new Actions(driver);
		
		WebElement min_slider=driver.findElement(By.xpath("//div[@class='ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//span[1]"));
		WebElement max_slider=driver.findElement(By.xpath("//div[@class='ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//span[2]"));
		
		Thread.sleep(5000);
		System.out.println("Location of min slider" +min_slider.getLocation());
		Thread.sleep(5000);
		act.dragAndDropBy(min_slider,974,1973).perform();    
		
		System.out.println("Location of max slider" +max_slider.getLocation());
		Thread.sleep(5000);
		act.dragAndDropBy(max_slider,1097,1973).perform();
	}

}

package practice1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GetCondandbrowsermethods {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
		//System.out.println(driver.getTitle());
		//System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys("kavya");
			
		String att=driver.findElement(By.xpath("//input[@placeholder='Enter EMail']")).getAttribute("placeholder");
		System.out.println(att);
		
		driver.findElement(By.cssSelector("input#male")).click();
		//driver.findElement(By.xpath("//input[@class='form-check-label' and @value='male']")).click();
		
		//driver.findElement(By.cssSelector("input.form-check-input[value='monday']")).click();
		Boolean day = driver.findElement(By.cssSelector("input.form-check-input[value='monday']")).isEnabled();
		System.out.println("enable:"+day);
		
		String dayavail= driver.findElement(By.xpath("//label[@class='form-check-label' and @for='monday']")).getText();
				System.out.println(dayavail);
		
	    String dayavail1= driver.findElement(By.xpath("//label[text()='Wednesday']")).getText();
				System.out.println(dayavail1);
				
		List <WebElement> checkboxtext = driver.findElements(By.xpath("//label[@class='form-check-label' and contains(@for,'day')]"));
		for(int i=0;i<checkboxtext.size();i++)
		
		{
			System.out.println(checkboxtext.get(i).getText());
			
		}
		
		
		
		
  WebElement drpcountryElement = driver.findElement(By.xpath("//select[@id='country']"));
  Select drpcountry=new Select(drpcountryElement);
  drpcountry.selectByIndex(2);
  
  WebElement colorselement = driver.findElement(By.xpath("//select[@id='colors']"));
  Select colorsSelect=new Select(colorselement);
  colorsSelect.selectByIndex(0);
	
		WebElement wiki = driver.findElement(By.className("wikipedia-icon"));
		System.out.println(wiki.isDisplayed());
		System.out.println("Testcase completed");
	
	}
	
	
}

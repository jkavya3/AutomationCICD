package Selday2;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class closespecificbrowser {

	public static void main(String[] args) throws InterruptedException 
	{
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@class='wikipedia-search-input']")).sendKeys("cakes");
    	driver.findElement(By.xpath("//input[@class='wikipedia-search-button' and @type='submit']")).click();
    	Thread.sleep(5000);
    	List <WebElement> link= driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//div//a[@target='_blank']"));
    	
    	System.out.println(link.size());
    	
    	for(int i=0;i<link.size();i++)
    	{
    		System.out.println(link.get(i).getText());
    		link.get(i).click();
    	}
    	
    	Set <String> windowIds= driver.getWindowHandles();
    	for(String winid:windowIds)
    	{
    		String title=driver.switchTo().window(winid).getTitle();
    		System.out.println(title);
    		if(title.equals("Cakes and Ale - Wikipedia"))
    		{
    			driver.close();
    			
    		}
    	}
	}

}

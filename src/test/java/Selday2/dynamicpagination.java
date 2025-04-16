package Selday2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicpagination {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		int rows = driver.findElements(By.xpath("//table[@id='productTable']//tr")).size();
		System.out.println("No. of rows:" + rows);
		
		int columns = driver.findElements(By.xpath("//table[@id='productTable']//th")).size();

		System.out.println("No. of columns:" + columns);
		
		int noofpages = driver.findElements(By.xpath("//ul[@id='pagination']//li")).size();
		System.out.println("No. of pages:" + noofpages);
		
		for(int p=1;p<=noofpages;p++)
			
		{
			if (p>1)
			{
				driver.findElement(By.xpath("//*[@id='pagination']/li["+p+"]/a")).click();			 
			}
		for(int r=1;r<rows;r++)
		{
			for(int c=1;c<=columns-1;c++)
			{
				Thread.sleep(5000);
				String value= driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(value);
				System.out.print("\t");
			}
			System.out.println(" ");
			
				
			driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]//td[4]//input[@type='checkbox']")).click();
			
		
			 		} 
		            
		}			
			
	}

}

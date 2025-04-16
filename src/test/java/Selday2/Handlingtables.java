package Selday2;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Handlingtables {
 
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		int rows=driver.findElements(By.xpath("//table[@id='taskTable']//tr")).size();
		System.out.println("No.of rows:" + rows);
		
		int coloumns=driver.findElements(By.xpath("//table[@id='taskTable']//th")).size();
		System.out.println("No.of coloumns:" + coloumns);
		
		for(int r=2;r<=rows;r++)
			
		{
			for(int c=1;c<=coloumns;c++)
		
		{		
		String value = driver.findElement(By.xpath("//table[@id='taskTable']//tr["+r+"]//td["+c+"]")).getText();
		System.out.print(value);
		System.out.print("\t");
		}
			System.out.println();
	}
		
	}
}

	
		
	



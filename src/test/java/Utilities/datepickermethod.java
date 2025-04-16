package Utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class datepickermethod {
	
	static void selectMonthandYear(WebDriver driver, String year,String month)
	{
		while (true)
		{
			
			String currentmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentyear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			System.out.println(currentmonth);
			System.out.println(currentyear);
			if(currentmonth.equals(month)&&currentyear.equals(year))
			{
				break;
		    }
				
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();//previous
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();//next
			
		}
	}
	
	static void selectdate(WebDriver driver,String date)
	{
List<WebElement> alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		
		for(WebElement dt:alldates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
		
			}
	

	public static void main(String[] args) {
		
WebDriver driver= new ChromeDriver();
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//SWITCHING TO FRAME
		
		driver.switchTo().frame(0);
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("06/08/2024");
		
		String year="2025";
		String month="May";
		String date="28";
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		selectMonthandYear(driver,year,month);
		selectdate(driver,date);
	}

}

package Selday2;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Datepickermethod {
	
	static void selectyear(WebDriver driver, String year)
	{
		WebElement currentyearele = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select currentyear = new Select(currentyearele);
		currentyear.selectByVisibleText(year);
	}
	
	
	static void selectmonth (WebDriver driver,String month)
	{
		WebElement currentmonthele = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select currentmonth = new Select(currentmonthele);
		
		List <WebElement> options= currentmonth.getOptions();
		for(int i=0;i<options.size();i++)
		{
		if(options.get(i).getText().equals(month))	
		{
			options.get(i).click();
			break;
		}
		}
		
	
		/*WebElement currentmonthele = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select currentmonth = new Select(currentmonthele);
		currentmonth.selectByVisibleText(month);*/
	
		
	}
	
	static void selectdate(WebDriver driver,String date)
	{
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
		
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
			
			driver.get("https://testautomationpractice.blogspot.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//input[@id='txtDate']")).click();
			String year = "2017";
			String month="Jun";
			String date="8";
			selectyear(driver,year);
			selectmonth(driver,month);
			selectdate(driver,date);
	}

}

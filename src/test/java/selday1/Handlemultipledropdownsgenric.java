package selday1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Handlemultipledropdownsgenric {
	static WebDriver driver;
	public static void Handlegenricdropdown(WebElement ele,String value)
	{
		Select drp=new Select(ele);
		List <WebElement> alloptions = drp.getOptions();
		for (WebElement op:alloptions)
		{
		if(op.getText().equals(value))
				{
			op.click();
			
				}
		}
 	}
	

	public static void main(String[] args) {
					
				driver=new ChromeDriver();
				
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		   driver.get("https://testautomationpractice.blogspot.com/");
		   driver.manage().window().maximize();
		   
		   WebElement drpcountryele= driver.findElement(By.xpath("//select[@class='form-control' and @id='country']"));
		   Handlegenricdropdown(drpcountryele,"Australia");
		   WebElement drpcolorsele= driver.findElement(By.xpath("//select[@class='form-control' and @id='colors']"));
		   Handlegenricdropdown(drpcolorsele,"Yellow");
		   WebElement drpanimalsele= driver.findElement(By.xpath("//select[@class='form-control' and @id='animals']"));
		   Handlegenricdropdown(drpanimalsele,"Dog");
		   
	}

}

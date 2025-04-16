package selday1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class multiselectdropdown {

	public static void main(String[] args) {
		
WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	   driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
	   driver.manage().window().maximize();
	   
	   driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
	   

	   
	   List <WebElement> options= driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//label"));
	   
	   
	   for(int i=0;i<options.size();i++)
		   
	   {	
		   String option=options.get(i).getText();
		   
		  if(option.equals("jQuery")||option.equals("Bootstrap")||option.equals("Angular")||option.equals("HTML"))
	   {
		   
		   options.get(i).click();
			
	   }
		  
			 
		   }
	 
      
		  
			 
		   
	   
	   
	   }
	

}

package selday1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Bootstrapdropdown {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	   driver.get("https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp");
	   driver.manage().window().maximize();
           
	   driver.findElement(By.xpath("//button[contains(@class,'dropdown-toggle') and @id='menu1']")).click();
	   // single option
	   driver.findElement(By.xpath("//a[@role='menuitem'and text()='CSS']")).click();
	   Thread.sleep(1000);
	   System.out.println("element clicked");
	   
	   
	   //multiple options
	   
	  driver.findElement(By.xpath("//button[contains(@class,'dropdown-toggle') and @id='menu2']")).click();// multiple options
	   List <WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'dropdown-menu') and contains(@aria-labelledby,'menu2')]/li"));
	   
	   
	   for(int i=0;i<options.size();i++)
	   {
		   
		  if(options.get(i).getText().equals("JavaScript"))
		   {
			   System.out.println("element clicked at" + i);
			   options.get(i).click();
				
		   }
		   	   }
	   
	}
}


package selday1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class FirstTestScript {

	public static void main(String[] args) {
	
		//Launch browser (chrome)
		
		//ChromeDriver driver=new ChromeDriver();
		WebDriver driver=new ChromeDriver();
		
		// open url https://demo.opencart.com/
		
		driver.get("https://flipkart.com");
		
		// validate title is Google
		String act_title=driver.getTitle();
	
		if(act_title.equals("Google"))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		
		driver.quit();
		
		}
		
	}


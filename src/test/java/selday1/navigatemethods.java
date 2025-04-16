package selday1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigatemethods {

	public static void main(String[] args) {
	
		WebDriver driver =new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		driver.navigate().forward();
		driver.get("https://www.google.com/");
		driver.navigate().refresh();
		driver.navigate().to("https://www.flipkart.com");
		driver.navigate().back();
	}

}

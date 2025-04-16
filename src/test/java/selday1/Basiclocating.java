package selday1;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Basiclocating {

	public static void main(String[] args) {
	
		WebDriver driver =new ChromeDriver();
		//driver.get("https://testautomationpractice.blogspot.com");https://www.flipkart.com/
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
	// fineELement by classname=	Pke_EE
		driver.findElement(By.className("Pke_EE")).sendKeys("watches");
		driver.findElement(By.xpath("// button[@class= '_2iLD__']")).click();
		

	}

}

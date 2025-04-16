package selday1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class framesprac {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();			
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);		
		
		driver.findElement(By.xpath("//input[@type='text' and @name='mytext1']")).sendKeys("Welcome");
		driver.switchTo().defaultContent();
		
		WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);		
		
		driver.findElement(By.xpath("//input[@type='text' and @name='mytext2']")).sendKeys("Selenium");
	driver.switchTo().defaultContent();
		
		WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);		
		
		driver.findElement(By.xpath("//input[@type='text' and @name='mytext3']")).sendKeys("Java");
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//div[@id='i9']//div//div[@class='AB7Lab Id5V1']")).click();
		driver.findElement(By.xpath("//div[@id='i27']//div[@class='uHMk6b fsHoPb']")).click();
		
		 driver.findElement(By.xpath("//div[@role='listbox']//span")).click();
		List <WebElement> options = driver.findElements(By.xpath("//span[@class='vRMGwf oJeWuf']"));
		System.out.println(options.size());
		
		for(WebElement op:options)
		{
			System.out.println(op.getText());
		}
		
		
		
	}

}

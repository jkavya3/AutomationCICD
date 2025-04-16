package selday1;


import java.util.List;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Checkboxanddropdownmultiple {

	public static void main(String[] args) throws InterruptedException  {
	
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		 List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input'and @type='checkbox']"));
		
		for(int i=1;i<checkboxes.size();i=i+2)
		{
			//System.out.println("Check box is displayed at index" + i);
			checkboxes.get(i).click();
			
	}
		Thread.sleep(5000);
		for (int i=0;i<checkboxes.size();i++)
		{
			if (checkboxes.get(i).isSelected())
			{
				checkboxes.get(i).click();	
			}
			
		
			}
		System.out.println("Check box is unselected");
		
	/*	for(WebElement checkbox:checkboxes)
		{
			checkbox.click();
		}
		*/
		WebElement colorselement =driver.findElement(By.xpath("//select[@class='form-control' and @id='colors']"));
		Select colorsSelect=new Select(colorselement);
		  colorsSelect.selectByIndex(1);
		  
		Actions act= new Actions(driver);
		act.keyDown(Keys.CONTROL).build();
		 colorsSelect.selectByIndex(3);
		 act.keyUp(Keys.CONTROL).perform();
		 
		 WebElement sortedlist=driver.findElement(By.xpath("//select[@class='form-control' and @id='animals']"));
		 Select listselect= new Select(sortedlist);
		 listselect.selectByVisibleText("Cat");
		
		//driver.quit();
    }
}


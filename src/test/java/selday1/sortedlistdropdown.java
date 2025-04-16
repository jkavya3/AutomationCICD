package selday1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class sortedlistdropdown {

			
			public static void main(String[] args) throws InterruptedException  {
			
			WebDriver driver=new ChromeDriver();			
			
			driver.get("https://testautomationpractice.blogspot.com/");
			driver.manage().window().maximize();
			WebElement drpcntryele= driver.findElement(By.xpath("//select[@class='form-control' and @id='animals']"));
			Select drpcntry=new Select(drpcntryele);
			List <WebElement> options= drpcntry.getOptions();
			
			ArrayList originallist= new ArrayList();
			ArrayList templist= new ArrayList();
			
			for(WebElement op:options)
			{
				originallist.add(op.getText());
				templist.add(op.getText());
				
			}
				
				System.out.println("Original list before sort" + originallist);
				System.out.println("Original list before sort" + templist);
				
				Collections.sort(templist);
				
				System.out.println("Original list before sort" + originallist);
				System.out.println("Original list before sort" + templist);
			
			if(originallist.equals(templist))
			{
				System.out.println("Dropdown sorted");
			}
			
			else
			{
				System.out.println("Dropdown not sorted");
			}

	}

}

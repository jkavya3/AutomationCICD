package selday1;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selecydropdownfindoptionsindropdown {

	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
   driver.get("https://testautomationpractice.blogspot.com/");
   driver.manage().window().maximize();
   
   WebElement drpcountryele= driver.findElement(By.xpath("//select[@class='form-control' and @id='country']"));
   Select drpcountry= new Select(drpcountryele);
   drpcountry.selectByIndex(0);
   
  WebElement drpcolorsele= driver.findElement(By.xpath("//select[@class='form-control' and @id='colors']"));
  Select drpcolors= new Select(drpcolorsele);
 List <WebElement> options=drpcolors.getOptions();
 System.out.println(options.size());
 for(int i=0;i<options.size();i++)
 {
	 
	 if(options.get(i).getText().equals("Blue"))
	 {
		 System.out.println("Drop down is displayed at index" + i);
		 options.get(i).click();
		 break;
	 }
	 
 
 }
 
 
 WebElement drpanimalsele= driver.findElement(By.xpath("//select[@class='form-control' and @id='animals']"));
 Select drpanimals=new Select(drpanimalsele);
List <WebElement> options1=drpanimals.getOptions();

            for(WebElement op:options1)
            {
            	String option =op.getText();
            	if(option.equals("Cat")||option.equals("Cheetah")||option.equals("Lion"))
            			{
            		System.out.println("Drop down is displayed");
            		op.click();
            	
            			}
            }
            
 
	}

}

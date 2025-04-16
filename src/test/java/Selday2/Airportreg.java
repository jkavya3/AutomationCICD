package Selday2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Airportreg {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver= new ChromeDriver();
		
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement depcityEle = driver.findElement(By.xpath("//select[@name='fromPort' and @class='form-inline']"));
		Select depcity = new Select(depcityEle);
		depcity.selectByVisibleText("San Diego");
		
		WebElement destcityEle = driver.findElement(By.xpath("//select[@name='toPort' and @class='form-inline']"));
		Select destcity = new Select(destcityEle);
		destcity.selectByVisibleText("London");
		
		driver.findElement(By.xpath("//input[@type='submit' and @value='Find Flights']")).click();
		
		int rows= driver.findElements(By.xpath("//table[@class='table']//tr")).size();
		System.out.println("No. of rows:" +rows);
		
		int cols= driver.findElements(By.xpath("//table[@class='table']//th")).size();
		System.out.println("No. of coloumns:" +cols);
		
		List <WebElement> price = driver.findElements(By.xpath("//table[@class='table']//td[6]"));
		ArrayList <Float> al =new ArrayList <Float>();
		for(int i=0;i<price.size();i++) {
		float pricenew= Float.parseFloat(price.get(i).getText().replace("$", ""));
	        al.add(pricenew);
		}
		
		float minprice = Collections.min(al);
		System.out.println("After sort:" + minprice);
		
		
		for(int r=1;r<rows;r++) {
			String pricenew1= driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//td[6]")).getText();
			float pricenew2= Float.parseFloat(pricenew1.replace("$", ""));
			if(pricenew2==minprice)
			{
				System.out.println("New price:" + pricenew2);
			 driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//td[1]")).click();
			System.out.println("clicked");	
			break;
			}
		}
		
		
		driver.findElement(By.xpath("//*[@id='inputName']")).sendKeys("John Ross");
		driver.findElement(By.xpath("//*[@id='address']")).sendKeys("NY, TT");
		driver.findElement(By.xpath("//*[@id='city']")).sendKeys("NZ");
		driver.findElement(By.xpath("//*[@id='state']")).sendKeys("US");
		driver.findElement(By.xpath("//*[@id='zipCode']")).sendKeys("234543");
		WebElement ele= driver.findElement(By.xpath("//*[@id='cardType']"));
		Select cardType= new Select(ele);
		cardType.selectByVisibleText("American Express");
		driver.findElement(By.xpath("//*[@id='creditCardNumber']")).sendKeys("2345433534656");
		driver.findElement(By.xpath("//*[@id='creditCardMonth']")).sendKeys("10");
		driver.findElement(By.xpath("//*[@id='creditCardYear']")).sendKeys("2045");
		driver.findElement(By.xpath("//*[@id='nameOnCard']")).sendKeys("John Ross");
		driver.findElement(By.xpath("//*/input[@class='btn btn-primary']")).click();
	     
		
		Thread.sleep(5000);
		boolean conf= driver.findElement(By.xpath("//*[contains(@text,'Thank you')]")).isDisplayed();
		
		System.out.println("Reservation SUccessful" +conf);	

				
				
		
		
	}
	
         
      	   
	}
	
      	   
      	      


		    	
		

	
	
	
     
package FrameWorkDesign;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class OrderaProductStandAlone {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		//Login Details
		WebElement username = driver.findElement(By.xpath("//input[@id='userEmail']"));
		username.sendKeys("kavyak@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='userPassword']"));
		password.sendKeys("Kavya@124");
		
		// Login Button
		driver.findElement(By.xpath("//input[@id='login']")).click();
	
		//Validate if cart has required product
				
			
		
		// Adding product to cart
				//driver.findElements(By.xpath("//div[contains(@class,'mb-3')]/div[contains(@class,'card')]/div/h5/b"));
				//driver.findElements(By.xpath("//div[contains(@class,'mb-3')]/div[contains(@class,'card')]/div/button[contains(@class,'btn w-10 rounded')]"));	
		
		
		String productname= "ZARA COAT 3";
		List <WebElement> products = driver.findElements(By.xpath("//div[contains(@class,'mb-3')]/div[contains(@class,'card')]/div/h5/b"));
		for(int i=0;i<=products.size()-1;i++)
		{
		
		String prods = products.get(i).getText();
		
		List itemsneeded = Arrays.asList(productname);
		if (itemsneeded.contains(prods))
		{
			driver.findElements(By.xpath("//div[contains(@class,'mb-3')]/div[contains(@class,'card')]/div/button[contains(@class,'btn w-10 rounded')]")).get(i).click();
		}
		 		  
		}
		
		
		
		//Explicit Wait  to wait till element is visible
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	     
		//Click on Cart
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		
		
		List <WebElement> cartproducts = driver.findElements(By.xpath("//div[contains(@class,'cartSection')]/h3"));
		
		for(WebElement cp:cartproducts)
		{
			boolean match = cp.getText().equalsIgnoreCase(productname);
			Assert.assertTrue(match);
			
		}
		
		//Click on Check out
		driver.findElement(By.xpath("//li[contains(@class,'totalRow')]/button")).click();
		
		//Provide Country name		
			
		Actions act= new Actions(driver);
		act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"india").build().perform();
		
		// Wait till dropdown is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class,'ta-results')]")));
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		
		//placing the order
		
		driver.findElement(By.xpath("//a[contains(@class,'action__submit')]")).click();
		
		// Validating the text message
		String ConfMsg = driver.findElement(By.xpath("//h1[contains(@class,'hero-primary')]")).getText();
		Assert.assertTrue(ConfMsg.equalsIgnoreCase("Thankyou for the order."));
		
		//Click on Cart
		
		driver.findElement(By.cssSelector("[routerlink*='myorders']")).click();
		
		int rows = driver.findElements(By.xpath("//table[contains(@class,table)]//tr")).size();
		System.out.println(rows);
		
		for (int r=1;r<rows;r++)
		{
			String prodct = driver.findElement(By.xpath("//table[contains(@class,table)]//tr["+r+"]//td[2]")).getText();
			System.out.println(prodct);
		}
		
          
	}

}

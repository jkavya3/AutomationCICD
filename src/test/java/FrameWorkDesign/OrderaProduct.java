package FrameWorkDesign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FrameWorkDesign.AbstractComponents.AbstractComponent;
import FrameWorkDesign.PageObjectClasses.ConfirmationPage;
import FrameWorkDesign.PageObjectClasses.LandingPage;
import FrameWorkDesign.PageObjectClasses.ProductCatalouge;
import FrameWorkDesign.PageObjectClasses.cartPage;
import FrameWorkDesign.PageObjectClasses.checkOutPage;
import FrameWorkDesign.PageObjectClasses.ordersPage;
import FrameWorkDesign.TestComponents.BaseTest;


public class OrderaProduct extends BaseTest {

	String productname= "ZARA COAT 3";	
	@Test (dataProvider="getData",groups= {"Purchase"})	
	public void orderaprod(HashMap <String,String> input) throws IOException, InterruptedException {
			
		ProductCatalouge productcatalouge= landingpage.loginApplication (input.get("email"),input.get("password"));
		
		productcatalouge.AddToCart(input.get("productname"));
		cartPage cartpage  = productcatalouge.goToCart();		
		boolean match = cartpage.verifyProductDisplay(input.get("productname"));
		Assert.assertTrue(match);
		checkOutPage checkoutpage = cartpage.goTocheckOut();
		checkoutpage.countrySelect("india");
		ConfirmationPage confirmationpage = checkoutpage.SubmitOrder();
		String ConfirmMessage = confirmationpage.getConfirmationMessage();		
	    Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("Thankyou for the order."));
	    	
	}
	
	@Test(dependsOnMethods={"orderaprod"})
	public void OrderHistory() {
		
		ProductCatalouge productcatalouge= landingpage.loginApplication ("kavyak@gmail.com","Kavya@124");
		ordersPage orderpage = productcatalouge.goToOrdersPage();
		Assert.assertTrue(orderpage.VerifyOrderDisplay(productname));
	}
	
	
		  @DataProvider
       public Object[][] getData() throws IOException {

      List<HashMap <String,String>> data =  getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//FrameWorkDesign//data//purchaseorder.json");
      return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
}
/* sending data in script
 @DataProvider
	public Object[][] getData() {
		
		return new Object[][] {{"kavyak@gmail.com","Kavya@124","ZARA COAT 3"}, {"kavyaki@gmail.com","Kavya@124","ADIDAS ORIGINAL"}};
	}
	
	public Object[][] getData() {
		
		HashMap <String,String> map = new HashMap <String,String> ();
		map.put("email","kavyak@gmail.com");
		map.put("password","Kavya@124");
		map.put("productname","ZARA COAT 3");
		
		HashMap <String,String> map1 = new HashMap <String,String> ();
		map1.put("email","kavyaki@gmail.com");
		map1.put("password","Kavya@124");
		map1.put("productname","ADIDAS ORIGINAL");	
		
		
		return new Object[][] {{map}, {map1}};
	}
 */



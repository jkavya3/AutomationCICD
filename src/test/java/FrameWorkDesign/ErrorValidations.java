package FrameWorkDesign;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import FrameWorkDesign.PageObjectClasses.ConfirmationPage;
import FrameWorkDesign.PageObjectClasses.ProductCatalouge;
import FrameWorkDesign.PageObjectClasses.cartPage;
import FrameWorkDesign.PageObjectClasses.checkOutPage;
import FrameWorkDesign.TestComponents.BaseTest;
import FrameWorkDesign.TestComponents.retry;

public class ErrorValidations extends BaseTest {
	
	@Test(groups= {"ErrorHandling"},retryAnalyzer=retry.class)
	public void LoginErrorValidate() throws IOException, InterruptedException {
	
		ProductCatalouge productcatalouge= landingpage.loginApplication ("kavyak@gmail.com","Kavya@123");
		Assert.assertEquals("Incorrect email or password.",landingpage.getErrorMessage());
	}
	


	@Test
	public void ProductErrorValidate() throws IOException, InterruptedException {
		String productname= "ZARA COAT 33";		
		ProductCatalouge productcatalouge= landingpage.loginApplication ("kavyaki@gmail.com","Kavya@124");
		productcatalouge.AddToCart(productname);
		cartPage cartpage  = productcatalouge.goToCart();		
		boolean match = cartpage.verifyProductDisplay(productname);
		Assert.assertFalse(match);
	
	}

}

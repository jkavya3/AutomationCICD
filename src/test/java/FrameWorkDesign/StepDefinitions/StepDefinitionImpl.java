package FrameWorkDesign.StepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import FrameWorkDesign.PageObjectClasses.ConfirmationPage;
import FrameWorkDesign.PageObjectClasses.LandingPage;
import FrameWorkDesign.PageObjectClasses.ProductCatalouge;
import FrameWorkDesign.PageObjectClasses.cartPage;
import FrameWorkDesign.PageObjectClasses.checkOutPage;
import FrameWorkDesign.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest {
	
	public LandingPage landingpage;
	public ProductCatalouge productcatalouge;
	public cartPage cartpage;
	public ConfirmationPage confirmationpage;
	@Given("I landed on Ecommerce page")
	public void i_landed_on_ecommerce_page() throws IOException  {
		landingpage = LaunchApplication();
	}
	
	    
	@Given("^I want to Login with Username (.+) and Password (.+)$")
	public void i_want_to_login_with_username_and_password(String username,String password) {
	   productcatalouge= landingpage.loginApplication (username,password);
	}

	@When("^I add product (.+) to cart$")
	public void i_add_product_zara_coat_to_cart(String productname) {
		productcatalouge.AddToCart(productname);
	}
	@When("^I Checkout (.+) and submit the order$")
	public void i_checkout_zara_coat_and_submit_the_order(String product) {
		cartpage  = productcatalouge.goToCart();
		boolean match = cartpage.verifyProductDisplay(product);
		Assert.assertTrue(match);
		checkOutPage checkoutpage = cartpage.goTocheckOut();
		checkoutpage.countrySelect("india");
		confirmationpage = checkoutpage.SubmitOrder();
	}

	@Then("{string} message is displayed on Confirmation page")
	public void message_is_displayed_on_confirmation_page(String string) {
		String ConfirmMessage = confirmationpage.getConfirmationMessage();		
	    Assert.assertTrue(ConfirmMessage.equalsIgnoreCase(string));
	    driver.quit();
	}
	
	@Then("I verify {string} message is displayed")
	public void i_verify_message_is_displayed(String string) {
		Assert.assertEquals(string,landingpage.getErrorMessage());
		driver.close();
	}




}

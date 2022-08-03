package stepDefinitions;

import org.junit.Assert;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import pageObjects.ConfirmationPage;

public class ConfirmationPageSteps {
	
	TestContext testContext;
	ConfirmationPage confirmationPage;
	
	public ConfirmationPageSteps(TestContext context) {
		testContext = context;
		confirmationPage =testContext.getPageObjectManager().getConfirmationPage();
		
	}	
	
	@Then("^verify the order details$")
	public void verify_the_order_details(){
		String productName = (String) testContext.getscenarioContext().getContext(Context.PRODUCT_NAME) ;
		System.out.println("ConfirmationPageSteps -- productName =" + productName);
		System.out.println("ConfirmationPageSteps -- confirmationPage.getProductNames().stream().filter(x-> x.contains(productName)) = "+ confirmationPage.getProductNames().stream().filter(x-> x.contains(productName)).findFirst());		
		Assert.assertTrue(confirmationPage.getProductNames().stream().filter(x-> x.contains(productName.toUpperCase())).findFirst().get().length() >0);
	}	
}

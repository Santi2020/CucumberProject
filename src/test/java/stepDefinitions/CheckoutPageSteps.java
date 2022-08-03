package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import testDataTypes.Customer;

public class CheckoutPageSteps {
	TestContext  testContext;
	CheckoutPage checkoutPage;
	//WebDriver driver;
	public CheckoutPageSteps(TestContext  context) {
		System.out.println("CheckoutPageSteps TestRunner initiated");
		testContext = context;
		checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
	}
	
	@When("^enters shipping details$")
	public void enters_shipping_details() throws Throwable {
	    System.out.println("Inside enters_shipping_details");
	}

	@When("^enter \\\"(.*)\\\" personal details on checkout page$")
	public void enter_personal_details_on_checkout_page(String customerName) throws InterruptedException{
		System.out.println("CheckoutPageSteps -- customerName = " + customerName);
		Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
		checkoutPage.fill_PersonalDetails(customer);	
	}
	
	@When("select payment method as {string} payment")
	public void select_payment_method_as_payment(String string) {
		System.out.println("CheckoutPageSteps -- executing select_payment_method_as_payment");
	}
	
	/*
	@When("^select payment method as \"([^\"]*)\" payment$")
	public void select_payment_method_as_payment(String arg1) throws Throwable {
		checkoutPage.fill_PersonalDetails();
	}
	*/
	
	@When("^place the order$")
	public void place_the_order() throws Throwable {
		checkoutPage.check_TermsAndCondition(true);
		checkoutPage.clickOn_PlaceOrder();
	}
}

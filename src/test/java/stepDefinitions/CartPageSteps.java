package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import pageObjects.CartPage;

public class CartPageSteps {
	TestContext  testContext;
	CartPage cartPage;
	
	public CartPageSteps(TestContext  context){
		System.out.println("CartPageSteps TestRunner initiated");
		testContext = context;
		cartPage = testContext.getPageObjectManager().getCartPage();	
	}
	
	@When("^move to checkout from mini cart$")
	public void move_to_checkout_from_mini_cart() throws Throwable {
		System.out.println("inside move_to_checkout_from_mini_cart");
		//cartPage = pageObjectManager.getCartPage();
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout();	
	}
}

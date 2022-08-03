package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.When;
import pageObjects.ProductListingPage;

public class ProductPageSteps {
	TestContext testContext;
	ProductListingPage productListingPage;
	
	
	public ProductPageSteps(TestContext context) {
		System.out.println("ProductPageSteps TestRunner initiated");
		testContext = context;
		productListingPage = testContext.getPageObjectManager().getProductListingPage();
	}
	
	@When("^choose to buy first item$")
	public void choose_to_buy_first_item() throws Throwable {
		
		String productName = productListingPage.getProductname(1);
		testContext.getscenarioContext().setContext(Context.PRODUCT_NAME, productName);
		
		productListingPage.select_Product(1);
		productListingPage.select_Color();
		productListingPage.select_Size();
		
		
		
		productListingPage.clickOn_AddToCart();	
	}
	
	
}

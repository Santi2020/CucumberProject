package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import dataProviders.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;
//import pageObjects.CartPage;
//import pageObjects.CheckoutPage;
import pageObjects.HomePage;
//import pageObjects.ProductListingPage;

public class HomePageSteps {
	WebDriver driver;
	HomePage homePage;
	PageObjectManager pageObjectManager;
	//ConfigFileReader configFileReader;
	WebDriverManager webDriverManager;
	TestContext testContext;
	
	public HomePageSteps(TestContext context) {
		System.out.println("HomePageSteps -- running constructor");
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		System.out.println("HomePageSteps --homepage created-- homePage=" + homePage);
	}
	
	@Given("^User is on home page$")
	public void user_is_on_home_page() throws Throwable {
		System.out.println("Inside  user_is_on_home_page ");
		//webDriverManager = new WebDriverManager();
		//driver = webDriverManager.getDriver();
		
		//pageObjectManager = new PageObjectManager(driver);
		//homePage = pageObjectManager.getHomePage();
		homePage.navigateTo_HomePage();	
	}

	@When("^he searhes for \"([^\"]*)\"$")
	public void he_searhes_for(String product) throws Throwable {
		homePage.perform_Search(product);
	}
}

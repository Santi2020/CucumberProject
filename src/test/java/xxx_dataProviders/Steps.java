package xxx_dataProviders;

import java.util.List;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;

import pageObjects.HomePage;
import pageObjects.ProductListingPage;
import dataProviders.ConfigFileReader;
//import managers.FileReaderManager;

public class Steps {
	//public WebDriver driver;
	WebDriver driver;
	HomePage homePage;
	ProductListingPage productListingPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	PageObjectManager pageObjectManager;
	ConfigFileReader configFileReader;
	WebDriverManager webDriverManager;
/*	
	@Given("^User is on home page$")
	public void user_is_on_home_page() throws Throwable {
		System.out.println("Inside  user_is_on_home_page ");
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		
		//configFileReader = new ConfigFileReader();
		
		//System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		//System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigReader().getDriverPath());
		
		//driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitWait(), TimeUnit.SECONDS);
		
		pageObjectManager = new PageObjectManager(driver);
		homePage = pageObjectManager.getHomePage();
		homePage.navigateTo_HomePage();	
	}

	@When("^he searhes for \"([^\"]*)\"$")
	public void he_searhes_for(String product) throws Throwable {
		homePage.perform_Search(product);
	}

	
	@When("^choose to buy first item$")
	public void choose_to_buy_first_item() throws Throwable {
		productListingPage = pageObjectManager.getProductListingPage();
		productListingPage.select_Product(0);
		productListingPage.select_Color();
		productListingPage.select_Size();
		productListingPage.clickOn_AddToCart();	
	}

	@When("^move to checkout from mini cart$")
	public void move_to_checkout_from_mini_cart() throws Throwable {
		System.out.println("inside move_to_checkout_from_mini_cart");
		cartPage = pageObjectManager.getCartPage();
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout();	
	}
====	
	@When("^enters shipping details$")
	public void enters_shipping_details() throws Throwable {
	    System.out.println("Inside enters_shipping_details");
	}

	@When("^select payment method as \"([^\"]*)\" payment$")
	public void select_payment_method_as_payment(String arg1) throws Throwable {
		//CheckoutPage checkoutPage = new CheckoutPage(driver);
		
		checkoutPage = pageObjectManager.getCheckoutPage();
		checkoutPage.fill_PersonalDetails();
		
	}

	@When("^place the order$")
	public void place_the_order() throws Throwable {
		//CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage = pageObjectManager.getCheckoutPage();
		checkoutPage.check_TermsAndCondition(true, driver);
		checkoutPage.clickOn_PlaceOrder();
	}
	*/
}


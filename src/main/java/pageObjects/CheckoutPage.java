package pageObjects;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testDataTypes.Customer;
 

import selenium.Wait;

public class CheckoutPage {
	WebDriver ldriver;
	public CheckoutPage(WebDriver driver) {
		ldriver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH , using="//*[@id=\"billing_first_name\"]")
	private WebElement txtbx_FirstName;
	
	@FindBy(how=How.XPATH , using="//*[@id=\"billing_last_name\"]")
	private WebElement txtbx_LastName;
	
	
	@FindBy(how=How.NAME , using="billing_country")
	private WebElement drpdwn_CountryDropDownArrow;
	
	@FindBy(how=How.XPATH , using="//*[@id=\"billing_address_1\"]")
	private WebElement txtbx_Address;
	
	@FindBy(how=How.XPATH , using="//*[@id=\"billing_city\"]")
	private WebElement txtbx_City;
	
	
	@FindBy(how=How.XPATH , using="//*[@id=\"billing_postcode\"]")
	private WebElement txtbx_PostCode;
	
	@FindBy(how=How.XPATH , using="//*[@id=\"billing_phone\"]")
	private WebElement txtbx_Phone;
	
	@FindBy(how=How.XPATH , using="//*[@id=\"billing_email\"]")
	private WebElement txtbx_Email;
	
	@FindBy(how=How.XPATH , using="//input[@id='terms']")
	private WebElement chkbx_AcceptTermsAndCondition;
	
	@FindBy(how=How.XPATH , using="//*[@id=\"place_order\"]")
	private WebElement btn_PlaceOrder;
	
	public void enter_Name(String name) {
		txtbx_FirstName.sendKeys(name);
	}
	
	public void enter_LastName(String lastName) {
		txtbx_LastName.sendKeys(lastName);
	}

	public void enter_Email(String email) {
		txtbx_Email.sendKeys(email);
	}
	
	public void enter_Phone(String phone) {
		txtbx_Phone.sendKeys(phone);
	}
	
	public void enter_City(String city) {
		txtbx_City.sendKeys(city);
	}
	
	public void enter_Address(String address) {
		txtbx_Address.sendKeys(address);
	}
	
	public void enter_PostCode(String postCode) {
		txtbx_PostCode.sendKeys(postCode);
	}
	
	public void select_Country(String countryName) throws InterruptedException {
		//drpdwn_CountryDropDownArrow.click();
		
		Select drpCountry = new Select(drpdwn_CountryDropDownArrow);
		drpCountry.selectByVisibleText(countryName);
		//Thread.sleep(3000);
		Wait.untilJqueryIsDone(ldriver);
		System.out.println("Selected Country");
	}
	
	//public void check_TermsAndCondition(boolean value,  WebDriver driver1) {
	public void check_TermsAndCondition(boolean value) {
	//if(value) chkbx_AcceptTermsAndCondition.click();
		
		JavascriptExecutor js =(JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click()", chkbx_AcceptTermsAndCondition);	
		System.out.println("Checked");
	}
	
	public void clickOn_PlaceOrder() {
		btn_PlaceOrder.submit();
		Wait.untilJqueryIsDone(ldriver);
		Wait.untilPageLoadComplete(ldriver);
		
	}
	
	
	public void fill_PersonalDetails(Customer customer) throws InterruptedException {
		//System.out.println("Call enter_name");
		enter_Name(customer.firstName);
		
		//System.out.println("Call enter_name");
		enter_LastName(customer.lastName);
		
		//System.out.println("Call select_Country");
		select_Country(customer.address.country);
		
		//System.out.println("Call enter_Address");
		enter_Address(customer.address.streetAddress);
		
		//System.out.println("Call enter_City");
		enter_City(customer.address.city);
		
		//System.out.println("Call enter_PostCode");
		enter_PostCode(customer.address.postCode);
		
		//System.out.println("Call enter_Phone");
		enter_Phone(customer.phoneNumber.home);
		
		//System.out.println("Call enter_Email");
		enter_Email(customer.emailAddress);
		
		//select_County("Delhi");
		
	}

}

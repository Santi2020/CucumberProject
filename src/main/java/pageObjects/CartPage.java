package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CartPage {
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"nav-menu-item-cart\"]/a/span/i") 
	private WebElement btn_Cart;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"post-6\"]/div/div/div[2]/div[2]/div/a") 
	private WebElement btn_ContinueToCheckout;
	
	
	
	public void clickOn_Cart() {
		System.out.println("Inside clickOn_Cart");
		btn_Cart.click();
	}
	
	public void clickOn_ContinueToCheckout(){
		System.out.println("Inside clickOn_ContinueToCheckout");
		btn_ContinueToCheckout.click();
		try { 
			Thread.sleep(5000);
			//Wait.untilJqueryIsDone(driver);
			}
		catch (InterruptedException e) {}
	}
	
}
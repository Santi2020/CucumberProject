package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//import xxx_dataProviders.ConfigFileReader;

public class ProductListingPage {
	
	public ProductListingPage(WebDriver driver) {
		System.out.println("ProductListingPage -- running constructor");
		PageFactory.initElements(driver, this);
		System.out.println("Inside ProductListingPage ");
	}
	
	
	@FindBy(how=How.XPATH, using ="//*[@id=\"pa_color\"]" )
	private WebElement dropdown_color;
	
	@FindBy(how=How.XPATH, using ="//*[@id=\"pa_size\"]" )
	private WebElement dropdown_size;
								//	"//*[@id=\"product-1467\"]/div[1]/div[2]/form/div/div[2]/button"
								//	"//*[@id=\"product-1467\"]/div[1]/div[2]/div[2]/div/a"
	//button.single_add_to_cart_button
	
	@FindBy(how = How.CSS, using = "button.single_add_to_cart_button")
	private WebElement btn_AddToCart;
	
	//@FindBy(how = How.CSS, using = "button.single_add_to_cart_button") 
	//private WebElement btn_AddToCart;
	
	//original
	//@FindBy(how = How.XPATH, using ="//*[@id=\"product-1473\"]/div[1]/div[2]/form/div/div[2]/button")
	//private WebElement btn_AddToCart;
	
	@FindAll(@FindBy(how = How.XPATH, using ="//div[@class=\"noo-product-inner\"]"))
	private List<WebElement> prd_List;	

	
	public void select_Color() throws InterruptedException {
		try {
		System.out.println("inside Select_color-- getText()=" + dropdown_color.getText() );
		Select clr = new Select(dropdown_color);
		//System.out.println("Select_color -- Creating Select object");
		clr.selectByIndex(1);
		//System.out.println("Select_color -- SeelectByIndex1");
		System.out.println("color selected");
		}
		catch(Exception e) {
			System.out.println("Error Occured"  );
			System.out.println(e);
			
		}
	}
	
	public void select_Size() {
		System.out.println("inside select_Size");
		Select sze = new Select(dropdown_size);
		sze.selectByIndex(1);
		System.out.println("size Selected");
	}
	
	public void clickOn_AddToCart() throws InterruptedException {
		System.out.println("inside clickOn_AddToCart. size prd_List=" + prd_List.size());
		btn_AddToCart.click();
		Thread.sleep(5000);
		System.out.println("Added to cart");
	}
	
	public void select_Product(int productNumber) {
		System.out.println("inside select_Product. prd_List size = " + prd_List.size());
		prd_List.get(productNumber).click();
	}
	
	public String getProductname(int productNumber) {
		//return prd_List.get(productNumber).getText();
		System.out.println("ProductListingPage -- getProductname =" + prd_List.get(productNumber).findElement(By.cssSelector("h3")).getText());
		return prd_List.get(productNumber).findElement(By.cssSelector("h3")).getText();
	}

}
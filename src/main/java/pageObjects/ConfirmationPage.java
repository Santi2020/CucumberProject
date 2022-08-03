package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindAll(@FindBy(how = How.CSS, using=".order_item"))
	private List<WebElement> prd_List;
	
	//@FindAll(@FindBy(how = How.XPATH, using ="//div[@class=\"noo-product-inner\"]"))
	//private List<WebElement> confirmed_prd_List;	
	
	public List<String> getProductNames(){
		List <String> productNames = new ArrayList<>();
		System.out.println("ConfirmationPage -- size of prd_List = " + prd_List.size());
		for (WebElement element : prd_List) {			
			String prd = element.getText().toUpperCase();
			productNames.add(prd);
			System.out.println("ConfirmationPage here it is-- productName prd = ***" + prd +"***");
		}
		return productNames;
	}
	
}

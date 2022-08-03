package seleniumTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class E2E_Test {
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );
		driver.get("https://shop.demoqa.com");
		
		driver.navigate().to("https://shop.demoqa.com/?s="+"dress" + "&post_type=product");
		
		List <WebElement> items = driver.findElements(By.xpath("//div[@class=\"noo-product-inner\"]"));
		if(items.size()>0) {
			items.get(0).click();
			
		}else {
			System.out.println("No products were found matching your selection.");
		
		}
		
		WebElement addToCart = driver.findElement(By.xpath("//button[@class=\"single_add_to_cart_button button alt disabled wc-variation-selection-needed\"]"));
		
		WebElement color = driver.findElement(By.xpath("//*[@id=\"pa_color\"]"));
		
		System.out.print("Selecting color");
		Select clr = new Select(color);
		clr.selectByIndex(1);
		
		System.out.println("Selecting Size");
		WebElement size = driver.findElement(By.xpath("//*[@id=\"pa_size\"]"));
		Select sze = new Select(size);
		sze.selectByIndex(1);
		addToCart.click();
		
		//click on view cart
		System.out.println("View cart");
		driver.findElement(By.xpath("//*[@id=\"nav-menu-item-cart\"]/a/span/i")).click();
		
		//click on checkout
		System.out.println("Proceed to Checking out");
		driver.findElement(By.xpath("//*[@id=\"post-6\"]/div/div/div[2]/div[2]/div/a")).click();
		
		//Adding customer details
		System.out.println("FirstName");
		driver.findElement(By.xpath("//*[@id=\"billing_first_name\"]")).sendKeys("Ketaki");
		
		System.out.println("LastName");
		driver.findElement(By.xpath("//*[@id=\"billing_last_name\"]")).sendKeys("Phadnis");
		
		System.out.println("Selecting Country");	
		WebElement country =driver.findElement(By.name("billing_country"));
		
		Select drpCountry = new Select(country);
		drpCountry.selectByVisibleText("Iceland");
		Thread.sleep(3000);
		System.out.println("Selected Country");
		
		System.out.println("Entering street address");
		WebElement streetAddress= driver.findElement(By.xpath("//*[@id=\"billing_address_1\"]"));
		streetAddress.sendKeys("1111 Central Avenue");
		
		
		System.out.println("Enter Town or City");
		driver.findElement(By.xpath("//*[@id=\"billing_city\"]")).sendKeys("Santa Clara");
		
		
		System.out.println("Enter Zipcode");
		driver.findElement(By.xpath("//*[@id=\"billing_postcode\"]")).sendKeys("580031");
		
		System.out.println("Enter Phone");
		driver.findElement(By.xpath("//*[@id=\"billing_phone\"]")).sendKeys("9998887771");
		
		System.out.println("Enter  email address");
		driver.findElement(By.xpath("//*[@id=\"billing_email\"]")).sendKeys("ketaki@rumba.com");
		
		System.out.println("Check terms and conditions");
		WebElement terms = driver.findElement(By.xpath("//input[@id='terms']"));
		
		Thread.sleep(1000);
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", terms);	
		System.out.println("Checked");
		
		
		//Place order
		System.out.println("Place order");
		driver.findElement(By.xpath("//*[@id=\"place_order\"]")).click();
			
	}

}

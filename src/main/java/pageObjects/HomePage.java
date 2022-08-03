
package pageObjects;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.support.PageFactory;

import dataProviders.ConfigFileReader;
import managers.FileReaderManager;


public class HomePage {
	WebDriver driver;
	ConfigFileReader configFileReader;
	
	public HomePage(WebDriver driver) {
		System.out.println("HomePage - running constructor");
		this.driver = driver;
		PageFactory.initElements(driver, this);
		configFileReader = new ConfigFileReader();
	}
	
	public void perform_Search(String search) {
		System.out.println("inside perform_Search");
		driver.navigate().to( FileReaderManager.getInstance().getConfigReader().getApplicationURL()+"/?s=" + search + "&post_type=product");
	}
	
	
	public void navigateTo_HomePage() {
		System.out.println("navigateTo_HomePage - running");
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationURL());
	}
	
}
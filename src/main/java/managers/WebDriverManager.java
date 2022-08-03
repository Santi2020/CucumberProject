package managers;

import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {

	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY ="webdriver.chrome.driver";
	
	public WebDriverManager() {
		System.out.println("WebDriverManager -- running constructor");
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType= FileReaderManager.getInstance().getConfigReader().getEnvironment();
		System.out.println("driverType =" + driverType);
		System.out.println("environmentType =" + environmentType);
	}
	
	public WebDriver getDriver() {
		System.out.println("Inside getDriver ");
		if ( driver== null) driver=createDriver();
		System.out.println("End getDriver. Driver= " + driver);
		return driver;
		
	}

	public WebDriver createDriver() {
		System.out.println("Inside createDriver ");
		switch (environmentType) {
		case LOCAL: createLocalDriver();
			break;
		case REMOTE : createRemoteDriver();
			break;	
		}
		System.out.println("End createDriver ");
		return driver;
	}
	
	public WebDriver createRemoteDriver() {
		throw new RuntimeException("Remote webriver not defined in the configutation file");
	}
	
	public WebDriver createLocalDriver() {
		System.out.println("Inside createLocalDriver");
		switch(driverType) {
			case FIREFOX: driver = new FirefoxDriver();
				break;
			case MSEDGE: driver = new EdgeDriver();
				break;	
			case CHROME : 
	        	System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
	        	driver = new ChromeDriver();
	    		break;
		}
		
		if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitWait(), TimeUnit.SECONDS);
        System.out.println("End createLocalDriver");
        return driver;
		
	}
	
	public void closeDriver() {
		System.out.println("Inside closeDriver");
		driver.close();
		driver.quit();
	}
	
}

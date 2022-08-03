package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "C:\\Users\\TISHAN1KA\\eclipse-workspace\\CucumberFramework_new\\configs\\Configuation.properties";
	
	public ConfigFileReader() {
		BufferedReader reader;
		//System.out.println("propertyFilePath = " + propertyFilePath);
		try {
			reader = new BufferedReader(new FileReader (propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch(IOException e) {
				e.printStackTrace();
			}			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration property not found at " + propertyFilePath);
		}
	}
	
	
	public String getDriverPath() {
		String driverPath= properties.getProperty("DriverPath");
		if (driverPath != null ) 
			return driverPath;
		else
		{
			throw new RuntimeException("DriverPath not specified in the configuration property file " );
		}
	}
	
	public long getImplicitWait() {
		String implicitWait= properties.getProperty("ImplicitlyWait");
		if (implicitWait != null ) 
			return Long.parseLong(implicitWait) ;
		else
		{
			throw new RuntimeException("ImplicitWait not specified in the configuration property file " );
		}
	}
	
	public String getApplicationURL() {
		String url= properties.getProperty("URL");
		if (url != null ) 
			return url;
		else
		{
			throw new RuntimeException("URL not specified in the configuration property file " );
		}
	}
	
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName==null || browserName.equals("chrome")) return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox")) 
			return DriverType.FIREFOX;
		else if (browserName.equalsIgnoreCase("msedge")) 
			return DriverType.MSEDGE;
		else throw new RuntimeException("Browser Name is not spscified in the configuration file");		
	}
	
	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if (environmentName == null || environmentName.equals("local")) return EnvironmentType.LOCAL;
		else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
		else throw new RuntimeException("Environment is not spscified in the configuration file");
	}
	
	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if (windowSize != null)  
			return Boolean.valueOf(windowSize) ;
		else
			return true;
	}
	
	public String getTestDataResourcesPath() {
		String testDataResourcesPath = properties.getProperty("testDataResourcesPath");
		System.out.println("ConfigFileReader -- testDataResourcesPath =" + testDataResourcesPath);
		if (testDataResourcesPath != null) return testDataResourcesPath;
		else throw new RuntimeException("TestDataResourcesPath is not specified in the configuration file");
	}


	public Long getImplicitlyWait() {
		// TODO Auto-generated method stub
		return (long) 10;
	}
	
	public String getReportConfigPath() {
		String reportConfigPath = properties.getProperty("reportConfigPath");
		System.out.println("getReportConfigPath = " + reportConfigPath );
		if (reportConfigPath != null)
			return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");	
	}
}

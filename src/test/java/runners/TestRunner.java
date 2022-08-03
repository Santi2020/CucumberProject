package runners;

import java.io.*;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features ="src\\test\\resources\\functionalTests"
	,glue= {"stepDefinitions"}
	//,plugin = {"pretty", "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
	,plugin = {"pretty" 
			, "junit:target/cucumber-reports/cucumber.xml"
			, "json:target/cucumber-reports/cucumber_report.json"
			, "html:target/cucumber-reports/cucumber_report.html"
			}
	
	,monochrome = true
	)
 

public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		//System.out.println("TestRunner -- writeExtentReport stsrt");
		//Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		//System.out.println("TestRunner -- writeExtentReport end");
	}
}


/*
package runners;

import java.io.File;



import org.junit.AfterClass;

import org.junit.runner.RunWith;

//import com.aventstack.extentreports.reporter.ExtentXReporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import managers.FileReaderManager;
//import com.cucumber.listener.Reporter;
//import com.aventstack.extentreports.
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/*
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
*/


//com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter

/*
@RunWith(Cucumber.class)
@CucumberOptions(
				//features ="C:\\Users\\TISHAN1KA\\eclipse-workspace\\CucumberFramework_new\\src\\test\\resources\\functionalTests"
				features ="src\\test\\resources\\functionalTests"
				,glue= {"stepDefinitions"}	
				,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
										
		)
*/

/*
 		//,monochrome=true
 		//,plug in = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
				//,plug in = {"pretty" 
				//, "junit:target/cucumber-reports/cucumber.xml"
				//, "json:target/cucumber-reports/cucumber_report.json"
				//, "html:target/cucumber-reports/cucumber_report.html"
				//}
				//,plug in = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
				//,plug in = { "usage"}
				//,dryRun = true
 */

/*
public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		//ExtentReporter Reporter;
		//ExtentXReporter extentXReporter= new ExtentXReporter();
		//Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	    /*
	    Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath())); 
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.7.0");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
		*/
//	}

//}

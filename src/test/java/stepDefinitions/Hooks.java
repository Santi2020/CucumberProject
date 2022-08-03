package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
//import cucumber.api.java.Before;


public class Hooks {
	TestContext testContext;
	
	public Hooks(TestContext context) {
		testContext = context;
	}
	
	
	@Before
	public void BeforeSteps() {
		System.out.println("Hooks -- Executing BeforeSteps");
		/*What all you can perform here
		Starting a webdriver
		Setting up DB connections
		Setting up test data
		Setting up browser cookies
		Navigating to certain page
		or anything before the test
	*/
	}
	
	@Before
	public void BeforeSteps_second_method() {
		System.out.println("Hooks -- Executing BeforeSteps_second_method");
	}
	
	@After
	public void AfterSteps() {
		System.out.println("Close the driver here");
		//testContext.getWebDriverManager().closeDriver();
	}
	
	
	@After
	public void AfterSteps_second_method() {
		System.out.println("Hooks -- AfterSteps_second_method");
		//testContext.getWebDriverManager().closeDriver();
	}
}


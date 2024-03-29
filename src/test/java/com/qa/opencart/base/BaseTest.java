package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterationPage;
import com.qa.opencart.pages.ResultsPage;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;
	public DriverFactory df;
	public LoginPage loginPage;
	public  AccountsPage accPage;
	public ResultsPage resultPage;
	public ProductInfoPage productInfoPage;
	public RegisterationPage registerationPage;
	
	public SoftAssert softAssert;

	
	@Parameters({"browser", "browserversion"})// in test level we are using paarmeter in testng xml file , so we have to give it here
	@BeforeTest
	public void setUp(String browser , String browserVersion ) {
	
		df = new DriverFactory();
		prop = df.initProp();
		
		 //update the config file with the value coming from testng xml parameters
		  if(browser!=null) 
		  { 
			  prop.setProperty("browser", browser);
		      prop.setProperty("browserversion", browserVersion);
		  }
		 
		prop.setProperty("password", System.getProperty("pass"));
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

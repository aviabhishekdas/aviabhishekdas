package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LinksSearchTest extends BaseTest {

	@BeforeClass
	public void linkpagesetup() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		System.out.println("linkpagesetup " + driver.hashCode());
	}

	@Test(priority = 0)
	public void seachlinks() {
		accPage.Searchlinks();
		Assert.assertTrue(true);

	}

	@Description("logout from page linksearchTest....")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void logout() {
		accPage.logoutPage();
		
	}

}

package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 100: Open Cart App - Desgin Login Page")
@Story("US 101: Login page features with some basic modules and functionalities")
public class LoginPageTest extends BaseTest {

	@Description("login page title test....")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=0)
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("act page title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Description("login page url test....")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void loginPageUrlTest() {
		String url = loginPage.getLoginPageUrl();
		System.out.println("act page url is: " + url);
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_VALUE));
	}

	@Description("login page fwd pwd link test....")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=2)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdlinkExist());
	}

	@Description("login page register link test....")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=3)
	public void registerLinkTest() {
		Assert.assertTrue(loginPage.isRegisterlinkExist());
	}

	@Description("login page test....")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=4)
	public void loginTest() {
		accPage= loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		System.out.println("login page "+driver.hashCode());
	}
	
	
	@Description("logout from page....")
	@Severity(SeverityLevel.NORMAL)
	@AfterClass
	public void logout1()
	{   System.out.println("login page logout "+driver.hashCode());
		accPage.logoutPage();
	}

}

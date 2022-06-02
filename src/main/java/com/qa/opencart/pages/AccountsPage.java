package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search span");
	private By logoutLink = By.linkText("Logout");
	private By accSecHeaders = By.cssSelector("div#content h2");
	

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public void Searchlinks()
	{
		List<String> actualurls = new ArrayList<String>();
		List<WebElement> taglist = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = taglist.iterator();
		while(it.hasNext())
		{
			String url = it.next().getAttribute("href");
			if (!(url.isEmpty()) || !(url==null))
			{
				actualurls.add(url);
			}
				
		}
		for(String a :actualurls)
		{
			System.out.println(a);
		}
		
	}

	public String getAccPageTitle() {
		return elementUtil.waitForTitleToBe(Constants.DEFAULT_TIME_OUT, Constants.ACC_PAGE_TITLE);
	}

	public boolean isLogoutLinkExist() {
		return elementUtil.doIsDiplayed(logoutLink);
	}

	public boolean isSeachFieldExist() {
		return elementUtil.doIsDiplayed(search);
	}

	public List<String> getAccountSecList() {
		List<WebElement> secList = elementUtil.getElements(accSecHeaders);
		List<String> secHeaderList = new ArrayList<String>();
		for (WebElement e : secList) {
			secHeaderList.add(e.getText());
		}
		return secHeaderList;
	}
	
	public ResultsPage doSearch(String productName) {
		System.out.println("product name: " + productName);
		elementUtil.doSendKeys(search, productName);
		elementUtil.doClick(searchIcon);
		return new ResultsPage(driver);
	}
	
	public void logoutPage()
	{
		elementUtil.doClick(logoutLink);
	}
	}



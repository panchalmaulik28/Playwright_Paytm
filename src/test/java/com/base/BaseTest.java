package com.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.factory.BrowserFactory;

public class BaseTest{

	@BeforeTest
	public void invokeBrowser() {
		BrowserFactory.init();
	}
	
	@AfterTest
	public void tearDown() {
		BrowserFactory.closeBrowser();
	}
}

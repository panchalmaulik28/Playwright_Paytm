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
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BrowserFactory.closeBrowser();
	}
}

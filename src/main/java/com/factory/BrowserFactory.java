package com.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserFactory {

	static Playwright playwright;
	static Browser browser;
	static BrowserContext bc;
	public static Page page;
	static Properties prop;

	public static void init() {
		prop = configProperties();
		String browserName = (String) prop.get("browser");
		String URL = (String) prop.get("URL");
		
		playwright = Playwright.create();
		
		if (browserName.equals("chrome")) {
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));			
		}
		else if (browserName.equals("firefox")) {
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		} 
		else if (browserName.equals("webkit")) {
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		} 
		else {
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		}

		bc = browser.newContext();
		page = bc.newPage();
		page.navigate(URL);
	}

	public static void closeBrowser() {
		page.close();
	}

	public static Properties configProperties() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("./src/test/resources/config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}

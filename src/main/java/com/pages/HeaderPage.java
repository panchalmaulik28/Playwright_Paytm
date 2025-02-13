package com.pages;

import com.factory.BrowserFactory;
import com.microsoft.playwright.Locator;

public class HeaderPage extends BrowserFactory {

	static String headerMenu = "//ul[@class='_2o4VV']/li";
	static String headerSubMenu = "//ul[@class='_2o4VV']/li/ul/li/a";
	static String headerSubMenu2 = "//li[@class='_2Szju']/ul/li/ul/li/a";

	public static void navigateToMenu(String menu) {
		hover(headerMenu, menu);
	}

	public static void navigateToSubMenu(String menu) {
		hover(headerSubMenu, menu);
	}

	public static void navigateToSubMenu2(String menu) {
		hover(headerSubMenu2, menu);
	}

	public static void hover(String locator, String menu) {
		Locator menuLocator = page.locator(locator);
		for (int i = 0; i <= menuLocator.count(); i++) {
			if (menuLocator.nth(i).innerText().trim().equals(menu)) {
				menuLocator.nth(i).hover();
				menuLocator.nth(i).click();
				break;
			}
		}
	}

}

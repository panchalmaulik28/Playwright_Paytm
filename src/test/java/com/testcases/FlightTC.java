package com.testcases;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.FlightPage;
import com.pages.HeaderPage;

public class FlightTC extends BaseTest{
	
	FlightPage flightPage;
	
	@Test(priority = 1)
	public void searchWithFromTo() {
		flightPage = new FlightPage();
		flightPage.searchFlightWithSoruceDestination("Ahmedabad, Gujarat, India","Mumbai, Maharashtra, India");
	}
	
	@Test
	public void navigateToPage() {
		HeaderPage.navigateToMenu("Payments & Services");
		HeaderPage.navigateToSubMenu("Wealth");
		HeaderPage.navigateToSubMenu2("Paytm Gold");
	}
	
}

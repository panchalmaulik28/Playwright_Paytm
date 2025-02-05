package com.testcases;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.FlightPage;

public class FlightTC extends BaseTest{
	
	FlightPage flightPage;
	
	@Test
	public void launchTheApplication() {
		flightPage = new FlightPage();
		flightPage.searchFlight("Ahmedabad, Gujarat, India","Mumbai, Maharashtra, India");
	}
}

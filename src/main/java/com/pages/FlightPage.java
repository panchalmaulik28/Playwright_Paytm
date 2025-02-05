package com.pages;

import com.factory.BrowserFactory;

public class FlightPage extends BrowserFactory {

	String tripWayRadio = "//div[@class=\"_3Vm7i\"]/span/div/label";
	String fromDD = "//div[@class=\"_2TAdi\"]/div[1]/span[2]";
	String toDD = "//div[@class=\"_2TAdi\"]/div[2]/span[2]";
	String sourceTxt = "//input[@placeholder='Source']";
	String destinationTxt = "//input[@placeholder='Destination']";
	String placeList = "//div[@class=\"_3lt44\"]";
	String calender = "//span[@id='departureDate']";
	String searchFlightBtn = "//button[@id='flightSearch']";

	public void searchFlight(String source, String destination) {
		searchSourceDestination(source,destination);
		page.locator(searchFlightBtn).click();
	}

	public void searchSourceDestination(String source, String destination) {
		page.locator(fromDD).click();
		page.locator(sourceTxt).fill(source);
		int placeCount = page.locator(placeList).count();
		for (int i = 0; i <= placeCount; i++) {
			if(page.locator(placeList).allTextContents().contains(source)) {
				
				page.locator(placeList).nth(i).click();	
				break;
			}
		}
		page.locator(toDD).click();
		page.locator(destinationTxt).fill(destination);
		for (int i = 0; i <= placeCount; i++) {
			if(page.locator(placeList).allTextContents().contains(destination)) {
				page.locator(placeList).nth(i).click();	
				break;
			}
		}
	}

}

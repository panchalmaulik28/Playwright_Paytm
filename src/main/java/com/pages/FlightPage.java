package com.pages;

import com.factory.BrowserFactory;

public class FlightPage extends BrowserFactory {

	String tripWayRadio = "//div[@class='_3Vm7i']/span/div/label";
	String fromDD = "//div[@class='_2TAdi']/div[1]/span[2]";
	String toDD = "//div[@class='_2TAdi']/div[2]/span[2]";
	String sourceTxt = "//input[@placeholder='Source']";
	String destinationTxt = "//input[@placeholder='Destination']";
	String placeList = "//div[@class='_3lt44']";
	String placeName = "//div[@class='Egrgh']/div";
	String calender = "//span[@id='departureDate']";
	String searchFlightBtn = "//button[@id='flightSearch']";

	public void searchFlightWithSoruceDestination(String source, String destination) {
		selectSourcDestination(source, destination);
		page.locator(searchFlightBtn).click();
	}

	public void selectSourcDestination(String source, String destination) {
		page.locator(fromDD).click();
		page.locator(sourceTxt).fill(source);
		clickFromTheList(source);

		page.locator(toDD).click();
		page.locator(destinationTxt).fill(destination);
		clickFromTheList(destination);
	}

	public void clickFromTheList(String value) {
		page.waitForSelector(placeList);
		int placeCount = page.locator(placeList).count();
		for (int i = 0; i <= placeCount; i++)
			if (page.locator(placeList).allTextContents().contains(value)) {
				System.out.println("if loops"+page.locator(placeName).nth(i).textContent());
				page.locator(placeName).nth(i).click();
				break;
			}
	}
}

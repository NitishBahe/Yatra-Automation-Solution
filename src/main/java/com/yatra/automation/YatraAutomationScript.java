package com.yatra.automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YatraAutomationScript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.addArguments("--disable-notifications");

		WebDriver wd = new ChromeDriver(chromeOptions);
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(20));// synchronizing the webdriver

		wd.get("https://www.yatra.com");

		wd.manage().window().maximize();
		
		closePopup(wait);
		
		clickOnDepartureDate(wait);

		WebElement currentMonthWebelement = selectTheMonthFromCalendar(wait, 0);
		WebElement nextMonthWebelement = selectTheMonthFromCalendar(wait, 1);

		System.out.println(currentMonthWebelement);
		System.out.println(nextMonthWebelement);

		Thread.sleep(3000);

		int lowestPriceForCurrentMonth = getLowestPriceInMonth(currentMonthWebelement);
		int lowestPriceForNextMonth = getLowestPriceInMonth(nextMonthWebelement);

		System.out.println(lowestPriceForCurrentMonth);
		System.out.println(lowestPriceForNextMonth);

		compareTwoMonthPrices(lowestPriceForCurrentMonth, lowestPriceForNextMonth);
	}

	public static void clickOnDepartureDate(WebDriverWait wait) {
		By departureDateLocator = By.xpath("//div[@aria-label='Departure Date inputbox' and @role='button']");
		
		WebElement departureDateButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(departureDateLocator));
		departureDateButton.click();
	}

	public static void closePopup(WebDriverWait wait) {
		By popupLocator = By.xpath("//div[contains(@class,'style_popup')][1]");
		By crossButtonLocator = By.xpath(".//img[contains(@alt,'cross')]");
		
		try {
			WebElement popuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(popupLocator));
			WebElement crossButton = popuElement.findElement(crossButtonLocator);
			crossButton.click();
		} catch (Exception e) {
			System.out.println("Popup not shown on the screen");
		}
	}

	public static int getLowestPriceInMonth(WebElement monthWebElement) {
		By priceLocator = By.xpath(".//span[contains(@class,'custom-day-content')]");// include . here else it will take
																						// both months date
		List<WebElement> junePriceList = monthWebElement.findElements(priceLocator);

		int lowestPrice = Integer.MAX_VALUE;
		WebElement priceElement = null;
		for (WebElement price : junePriceList) {

			String priceString = price.getText();

			if (priceString.length() > 0) {
				priceString = priceString.replace("₹", "").replace(",", "");
				int priceInt = Integer.parseInt(priceString);

				if (priceInt < lowestPrice) {
					lowestPrice = priceInt;
					priceElement = price;
				}
			}

		}

		WebElement dateElement = priceElement.findElement(By.xpath("./../.."));
		System.out.println(dateElement.getAttribute("aria-label") + "is having lowest price as" + lowestPrice);
		return lowestPrice;
	}

	public static WebElement selectTheMonthFromCalendar(WebDriverWait wait, int index) {
		By calendarMonthsLocator = By.xpath("//div[@class='react-datepicker__month-container']");
		List<WebElement> calendarMonthsList = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(calendarMonthsLocator));
		System.out.println("Total Months Displayed: " + calendarMonthsList.size());
		WebElement monthCalendarWebelement = calendarMonthsList.get(index);
		return monthCalendarWebelement;
	}

	public static void compareTwoMonthPrices(int current, int next) {

		if (current < next) {
			System.out.println("Lowest price in both the month is: " + current);
		} else if (current == next) {
			System.out.println("Lowest Price is same in both the month:" + current);
		} else {
			System.out.println("Lowest price in both the month is: " + next);
		}

	}

}

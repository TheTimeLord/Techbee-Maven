package techbee.projects.seleniumProject;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebTest {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/dev/Webdrivers/chromedriver.exe");
		
		WebDriver chrome = new ChromeDriver();
		chrome.get("https://www.ebay.com");
		
		WebElement searchBar = chrome.findElement(By.id("gh-ac"));
		WebElement searchButton = chrome.findElement(By.id("gh-btn"));
		
		searchBar.sendKeys("iphone");
		Thread.sleep(500);
		searchButton.click();

		// Get the list of names and prices of iphones from Ebay
		List<WebElement> names = chrome.findElements(By.className("s-item__title"));
		List<WebElement> prices = chrome.findElements(By.className("s-item__price"));
		
		// Should be the same amount of names as prices
		if(names.size() != prices.size()) {
			System.out.println("Error, number of names and prices do not match");
		}
		else {
			// Concatenate names with prices
			for(int i=0; i < names.size(); i++) {
				String txt = names.get(i).getText() + " - " + prices.get(i).getText();
				System.out.println(txt);
			}
		}
	}
}

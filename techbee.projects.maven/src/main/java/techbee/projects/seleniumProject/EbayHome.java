package techbee.projects.seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EbayHome extends Website {
	
	public void connect() {
		driver.get("https://www.ebay.com");
	}
	
	public void search(String item) throws InterruptedException {
		WebElement searchBar = driver.findElement(By.id("gh-ac"));
		WebElement searchButton = driver.findElement(By.id("gh-btn"));
		searchBar.sendKeys(item);
		Thread.sleep(500);
		searchButton.click();
	}
	
	public void clickShoppingCart() {
		WebElement shoppingCart = driver.findElement(By.xpath(""));
		shoppingCart.click();
		
	}
}

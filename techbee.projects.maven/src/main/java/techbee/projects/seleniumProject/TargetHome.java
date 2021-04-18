package techbee.projects.seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TargetHome extends Website {
	
	public void connect() {
		driver.get("https://www.target.com");
	}

	public void search(String item) throws InterruptedException {
		WebElement searchBar = driver.findElement(By.id("search"));
		searchBar.sendKeys(item);
		Thread.sleep(300);
		WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/nav/div/form/button[2]"));
		searchButton.click();
		Thread.sleep(1000);
	}
}

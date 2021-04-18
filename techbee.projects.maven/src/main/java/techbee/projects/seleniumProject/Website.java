package techbee.projects.seleniumProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Website {
	
	
	WebDriver driver = new ChromeDriver();
	
	public List<WebElement> getElements(String type, String id) {
		switch(type) {
			case "class": // className
				return driver.findElements(By.className(id));
			case "css": // CSS selector
				return driver.findElements(By.cssSelector(id));
			case "id": // ID
				return driver.findElements(By.id(id));
			case "name": // name
				return driver.findElements(By.name(id));
			case "xpath": // xpath
				return driver.findElements(By.xpath(id));
			case "link": // Link Text
				return driver.findElements(By.linkText(id));
			case "tag": // Tag name
				return driver.findElements(By.tagName(id));
			default:
				System.out.println("ERROR: getElements() invalid selector type");
				return null;	
		}
	}

	
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
}

package techbee.projects.seleniumProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/dev/Webdrivers/chromedriver.exe");
		
		System.out.println("TEST");
		
		WebDriver chrome = new ChromeDriver();
		chrome.get("https://www.youtube.com");
		

	}
}

package techbee.projects.seleniumProject;


import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebTest {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/dev/Webdrivers/chromedriver.exe");
		
		// Connect to Ebay
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
		
		// Should be the same amount of names as prices, then write them to file
		if(names.size() != prices.size())
			System.out.println("Error, number of names and prices do not match");
		else
			writeToFile(names, prices, "ebay.txt");	
		
		// Connect to Target
		chrome.get("https://www.target.com");
		searchBar = chrome.findElement(By.id("search"));
		searchBar.sendKeys("iphone");
		Thread.sleep(300);
		searchButton = chrome.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/nav/div/form/button[2]"));
		searchButton.click();
		Thread.sleep(2000);
		
		//NOTE: Target website has inconsistencies, I can only get the first 6 items from the page easily
		names = chrome.findElements(By.xpath("//div/div[2]/div/div/div/div[1]/div[1]/a"));
		prices = chrome.findElements(By.xpath("//div/div[2]/div/div/div/div[2]/div/div/span"));
		
		if(names.size() != prices.size())
			System.out.println("Error, number of names and prices do not match");
		else
			writeToFile(names, prices, "Target.txt");	
	}
	
	private static void writeToFile(List<WebElement> names, List<WebElement> prices, String filename) {
		String path = "C:\\Users\\brian\\Desktop\\" + filename;
		System.out.println(path);
		
		// Create a new file
		File myFile = new File(path);
		try {
			if (myFile.createNewFile()) {
			    System.out.println("File created: " + myFile.getName());
			  } else {
			    System.out.println("File already exists.");
			  }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Write to file
		try {
			PrintWriter writer = new PrintWriter(path);
			
			for(int i=0; i < names.size(); i++) {
				String txt = names.get(i).getText() + " - " + prices.get(i).getText() + "\n";
				writer.write(txt);
				System.out.print(txt);
			}
			writer.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

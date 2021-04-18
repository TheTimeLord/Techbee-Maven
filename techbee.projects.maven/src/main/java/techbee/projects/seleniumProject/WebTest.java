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

import org.openqa.selenium.JavascriptExecutor;

public class WebTest {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/dev/Webdrivers/chromedriver.exe");
		
		EbayHome ebay = new EbayHome();
		ebay.connect();
		ebay.search("iphone");

		// Get the list of names and prices of iphones from Ebay
		
		List<WebElement> names = ebay.getElements("class", "s-item__title"); //chrome.findElements(By.className("s-item__title"));
		List<WebElement> prices = ebay.getElements("class", "s-item__price");//chrome.findElements(By.className("s-item__price"));
		
		// Should be the same amount of names as prices, then write them to file
		if(names.size() != prices.size())
			System.out.println("Error, number of names and prices do not match");
		else
			writeToFile(names, prices, "ebay.txt");	
		
		// Connect to Target
		TargetHome target = new TargetHome();
		target.connect();
		target.search("iphone");
		
		//scroll to bottom
		target.scrollDown();
	
		// Get new names and prices
		names = target.getElements("xpath", "//div/div[2]/div/div/div/div[1]/div[1]/a");//chrome.findElements(By.xpath("//div/div[2]/div/div/div/div[1]/div[1]/a"));
		prices = target.getElements("xpath", "//div/div[2]/div/div/div/div[2]/div/div/span");//chrome.findElements(By.xpath("//div/div[2]/div/div/div/div[2]/div/div/span"));
		
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
			e.printStackTrace();
		}
		
	}
	
	private static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
}

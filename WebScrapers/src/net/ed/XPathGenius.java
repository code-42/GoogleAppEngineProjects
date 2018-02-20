package net.ed;

/**
 * source - XPath Genius video tutorial 
 * https://youtu.be/3uktjWgKrtI?list=PLFGoYjJG_fqoY3PNcMLjp4pJZSXUCHeiB&t=1628
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathGenius {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/melocal/Applications/lib/chromedriver");
		
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize(); // maximize chrome browser
		driver.manage().deleteAllCookies(); // exactly what it says
		
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = "https://v4-alpha.getbootstrap.com/components/dropdowns/";
		driver.get(url);
		Thread.sleep(5000);
				
		String xpathElement = "//button[contains(text(),'Dropdown button']";
		driver.findElement(By.xpath(xpathElement)).click();
		
		String xpathString = "//div[@class='dropdown-menu' and @aria-labelledby='dropdownMenuButton']//a";
		@SuppressWarnings("unchecked")
		List<WebElement> list = (List<WebElement>) driver.findElement(By.xpath(xpathString));
		System.out.println(list.size());
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals("Another action")) {
				list.get(i).click();
				break;
			}
		}
		
	}

}

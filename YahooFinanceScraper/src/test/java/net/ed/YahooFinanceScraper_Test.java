package net.ed;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class YahooFinanceScraper_Test {

	static WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		// add support for chrome driver
		String key = "webdriver.chrome.driver";
		String valuex = "/Users/melocal/Applications/lib/chromedriver";
		System.setProperty(key, valuex);
		
		driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize(); // maximize chrome browser
		driver.manage().deleteAllCookies(); // exactly what it says
		
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
  
	@Test(priority = 1)
	public void getURL_Test() {
		try {
			Thread.sleep(500);
			String url = "https://login.yahoo.com";
			driver.get(url);
			Thread.sleep(500);
			String expected = "Yahoo - login";
			String actual = driver.getTitle();
			assertEquals(expected, actual);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

  
	@AfterTest
	public void terminateBrowser() {
		// sleep for a few seconds then close chrome browser
		try {
			Thread.sleep(4000);
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

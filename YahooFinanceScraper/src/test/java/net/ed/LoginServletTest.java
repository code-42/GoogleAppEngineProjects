package net.ed;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginServletTest {
	
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
	
	@Test
	public void doGetTest() {
		
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
		
		// sleep for a few milliseconds then click it
//		try {
//			Thread.sleep(500);
//			driver.findElement(By.name("username")).sendKeys("edev42@yahoo.com"); // fill in the blanks
//			Thread.sleep(500);
//			driver.findElement(By.name("signin")).click();
//			System.out.println("clicked Next button");
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	

	
	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
  
}

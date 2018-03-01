package net.ed;

import static org.testng.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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
	
	
	@Test(priority = 2)
	public void enterUserName_Test() {
		
		// sleep for a few milliseconds then click it
		try {
			Thread.sleep(500);
			driver.findElement(By.name("username")).sendKeys("edev42@yahoo.com"); // fill in the blanks
			Thread.sleep(500);
			driver.findElement(By.name("signin")).click();
			System.out.println("clicked Next button");
			String expected = "Yahoo - login";
			String actual = driver.getTitle();
			assertEquals(expected, actual);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3)
	public void enterPassword_Test() {
		
		// sleep for a few milliseconds then click it
		try {
			Thread.sleep(500);
			// the password is incorrect
			driver.findElement(By.name("password")).sendKeys("incorrect42");
			Thread.sleep(500);
			driver.findElement(By.name("verifyPassword")).click();
			Thread.sleep(500);
			System.out.println("clicked Verify Password button");
			String expected = "Yahoo";
			String actual = driver.getTitle();
			assertEquals(expected, actual);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority = 4)
	public void getCookies_Test() {
		// get cookies
		// tutorial https://www.guru99.com/handling-cookies-selenium-webdriver.html
        // create file named Cookies to store Login Information		
        File file = new File("Cookies.data");
	    try		
	    {	  
	        // Delete old file if exists
			file.delete();		
	        file.createNewFile();			
	        FileWriter fileWrite = new FileWriter(file);							
	        BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
	        	
	        // loop for getting the cookie information 		
	        for(Cookie ck : driver.manage().getCookies())							
	        {			
	            Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									
	            Bwrite.newLine();
	            System.out.println("175. LoginServlet Selenium cookies...");
	            System.out.println(ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure());
	        }			
	        Bwrite.close();			
	        fileWrite.close();	
//	        response.sendRedirect("/YahooFinanceScraper");
//	        exitApp();
			String expected = "Yahoo";
			String actual = driver.getTitle();
			assertEquals(expected, actual);
	    }
	    catch(Exception ex)					
	    {		
	        ex.printStackTrace();			
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

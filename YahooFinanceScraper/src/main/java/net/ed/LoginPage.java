package net.ed;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.apache.http.cookie.Cookie;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	public static void main(String[] args) {

		String key = "webdriver.chrome.driver";
		String value = "/Users/melocal/Applications/lib/chromedriver";
		System.setProperty(key, value);
		
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize(); // maximize chrome browser
		driver.manage().deleteAllCookies(); // exactly what it says
		
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try {
			Thread.sleep(500);
			String url = "https://login.yahoo.com";
			driver.get(url);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// sleep for a few milliseconds then click it
		try {
			Thread.sleep(500);
			driver.findElement(By.name("username")).sendKeys("edev42@yahoo.com"); // fill in the blanks
			Thread.sleep(500);
			driver.findElement(By.name("signin")).click();
			System.out.println("clicked Next button");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// sleep for a few milliseconds then click next button
		try {
			Thread.sleep(500);
			// the password is incorrect
			driver.findElement(By.name("password")).sendKeys("incorrect42");
			Thread.sleep(500);
			driver.findElement(By.name("verifyPassword")).click();
			System.out.println("clicked Verify Password button");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		
		
		
		
		
		
	}

}

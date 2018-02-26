package net.ed;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebScrapper {
	
	public WebDriver driver = new FirefoxDriver();

	/**
	 * Open the test website.
	 */
	public void openTestSite() {
		System.out.println("19. in openTestSite()");
		driver.navigate().to("http://testing-ground.scraping.pro/login");
		System.out.println("21. fin openTestSite()");

	}

	/**
	 * 
	 * @param username
	 * @param Password
	 * 
	 *            Logins into the website, by entering provided username and
	 *            password
	 */
	public void login(String username, String Password) {

		WebElement userName_editbox = driver.findElement(By.id("usr"));
		WebElement password_editbox = driver.findElement(By.id("pwd"));
		WebElement submit_button = driver.findElement(By.xpath("//input[@value='Login']"));

		userName_editbox.sendKeys(username);
		password_editbox.sendKeys(Password);
		submit_button.click();

	}

	/**
	 * grabs the status text and saves that into status.txt file
	 * 
	 * @throws IOException
	 */
	public void getText() throws IOException {
		String text = driver.findElement(By.xpath("//div[@id='case_login']/h3")).getText();
//		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("status.txt"), "utf-8"));
//		writer.write(text);
//		writer.close();

	}

	/**
	 * Saves the screenshot
	 * 
	 * @throws IOException
	 */
	public void saveScreenshot() throws IOException {
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile, new File("screenshot.png"));
	}

	public void closeBrowser() {

		// sleep for a few milliseconds then open YahooFinance homepage
		try {
			Thread.sleep(5000);
			driver.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		
//		String chromekey = "webdriver.chrome.driver";
//		String chromevalue = "/Users/melocal/Applications/lib/chromedriver";
//		System.setProperty(chromekey, chromevalue);
		
		String ffkey = "webdriver.gecko.driver";
		String ffvalue = "/Users/melocal/Applications/lib/geckodriver";
		System.setProperty(ffkey, ffvalue);
		
		WebScrapper webSrcapper = new WebScrapper();
		webSrcapper.openTestSite();
		webSrcapper.login("admin", "12345");
		webSrcapper.getText();
		webSrcapper.saveScreenshot();
		webSrcapper.closeBrowser();
	}
}
package net.ed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpath {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/melocal/Applications/lib/chromedriver");
		
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize(); // maximize chrome browser
		driver.manage().deleteAllCookies(); // exactly what it says
		
//		String url = "https://v4-alpha.getbootstrap.com/components/dropdowns/";
		String url = "https://www.freecrm.com";
		driver.get(url);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.name("username")).sendKeys("naveenk"); // fill in the blanks
		driver.findElement(By.name("password")).sendKeys("test@123");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathSubmit = "//input[@type='submit']";
		driver.findElement(By.xpath(xpathSubmit)).click();
		
		driver.switchTo().frame("mainpanel");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathContacts = "//a[contains(text(),'Contacts']";
		driver.findElement(By.xpath(xpathContacts)).click();
		
		String xpathName = ""
				+ "//a[text()=‘test2 test2’]"
				+ "//parent::td[@class=‘datalistrow’]"
				+ "//preceding-sibling::td[@class=‘datalistrow’]"
				+ "//input[@name=‘contact_id’]";
		
		driver.findElement(By.xpath(xpathName)).click();
	}

}

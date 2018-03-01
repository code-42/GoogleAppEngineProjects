package net.ed;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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
//		driver.manage().deleteAllCookies(); // exactly what it says
		
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
	public void getCookies_Test() {

		// tutorial https://www.guru99.com/handling-cookies-selenium-webdriver.html
		try{
			Thread.sleep(500);
//			driver.get("https://finance.yahoo.com/portfolio/p_0/view/v1");
			// first get the domain
			driver.get("https://finance.yahoo.com");
			Thread.sleep(500);
	        File file = new File("Cookies.data");							
	        FileReader fileReader = new FileReader(file);							
	        BufferedReader Buffreader = new BufferedReader(fileReader);							
	        String strline;			
	        while((strline=Buffreader.readLine())!=null){									
		        StringTokenizer token = new StringTokenizer(strline,";");									
		        while(token.hasMoreTokens()){					
			        String name = token.nextToken();					
			        String value = token.nextToken();					
			        String domain = token.nextToken();					
			        String path = token.nextToken();					
			        Date expiry = null;					
			        		
			        String val;			
			        if(!(val=token.nextToken()).equals("null"))
						{		
				        	expiry = new Date(val);					
				        }		
			        Boolean isSecure = new Boolean(token.nextToken()).								
			        booleanValue();		
			        Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);			
			        System.out.println(ck);
			        Thread.sleep(500);
			        driver.manage().addCookie(ck); // This will add the stored cookie to your current session					

			        Thread.sleep(500);
			        System.out.println("145. LoginServlet Selenium cookies...");
		            System.out.println(ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure());
		            Thread.sleep(5000);
		            
//		            fileReader.close();
//		            Buffreader.close();
		        	}		
		    }
        } catch(Exception ex){					
        		ex.printStackTrace();			
        }
		
		// now go to My Portfolio page after i got my cookies
        driver.get("https://finance.yahoo.com/portfolio/p_0/view/v1");
        
	}
	
	
//	@Test(priority = 3)
	public void getPortfolioURL_Test() {
		try {
			Thread.sleep(500);
			// now that i got my cookies, open to my account page
			String url = "https://finance.yahoo.com/portfolio/p_0/view/v1";
			driver.get(url);
			Thread.sleep(500);
			String expected = "Yahoo Finance - Business Finance, Stock Market, Quotes, News";
			String actual = driver.getTitle();
			assertEquals(expected, actual);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  

	@Test(priority = 4)
	public void scrapeMyTotals_Test() {
		// get certain elements on MyPortfolio page
		try {
			// sleep for a few milliseconds 
			Thread.sleep(500);
			System.out.println("inside Portfolio Page and scrapeMyTotals()");
			
			// Current Market Value element
			String currentMarketValueXpath = "//p[@data-test='currentMarketValue']";
			String currentMarketValue = driver.findElement(By.xpath(currentMarketValueXpath)).getText();
			System.out.println(currentMarketValue);
			Thread.sleep(500);
			
			// Day Gain element
			String dayGainXpath = "//p[contains(@class,'_2ETlv')]";
			String dayGain = driver.findElement(By.xpath(dayGainXpath)).getText();
			System.out.println("Today's Gain: " + dayGain);
			Thread.sleep(500);
	
			// Total Gain element
			String totalGainXpath = "//p[contains(@class,'_2HvXW')]";
			String totalGain = driver.findElement(By.xpath(totalGainXpath)).getText();
			System.out.println(totalGain);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@AfterTest
	public void terminateBrowser() {
		// sleep for a few seconds then close chrome browser
		try {
			Thread.sleep(9000);
//			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

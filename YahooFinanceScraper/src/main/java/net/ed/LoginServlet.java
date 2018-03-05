package net.ed;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import static org.testng.Assert.assertEquals;

import java.io.BufferedWriter;		
import java.io.File;		
import java.io.FileWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;		


/**
 * Servlet implementation class LoginPageServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static WebDriver driver;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		launchBrowser();
		getURL();
		enterUserName();
		enterPassword();
		getCookies();
//		redirectToScraper(response);
		terminateBrowser();
	}
	
		// launch browser
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
		
		// get Yahoo login page
		public void getURL() {
			try {
				Thread.sleep(500);
				String url = "https://login.yahoo.com";
				driver.get(url);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// enter usernmame
		public void enterUserName() {
			// sleep for a few milliseconds then click it
			try {
				Thread.sleep(500);
				driver.findElement(By.name("username")).sendKeys("edev42@yahoo.com"); // fill in the blanks
				Thread.sleep(500);
				driver.findElement(By.name("signin")).click();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// enter password
		public void enterPassword() {
			// sleep for a few milliseconds then click it
			try {
				Thread.sleep(500);
				// the password is incorrect
				driver.findElement(By.name("password")).sendKeys("incorrect42");
				Thread.sleep(500);
				driver.findElement(By.name("verifyPassword")).click();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// get cookies
		public void getCookies() {
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
//		            System.out.println("175. LoginServlet Selenium cookies...");
		            System.out.println(ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure());
		        }			
		        Bwrite.close();			
		        fileWrite.close();	
		    }
		    catch(Exception ex)					
		    {		
		        ex.printStackTrace();			
		    }
		}
		
		public void redirectToScraper(HttpServletResponse response) throws ServletException, IOException {
//			// sleep for a few milliseconds then redirect to homepage 
			try {
				Thread.sleep(500);
				// send user back to start page
				response.sendRedirect("/");
				// then open new browser window for scraping
				response.sendRedirect("/YahooFinanceScraper");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
		// now close the browser
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
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}



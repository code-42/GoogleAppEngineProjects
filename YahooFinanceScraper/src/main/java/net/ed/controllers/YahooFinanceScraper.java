package net.ed.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;

//import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;		
import java.io.BufferedWriter;		
import java.io.File;		
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;		
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import net.ed.LoginPageServlet.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import net.ed.models.*;

import org.openqa.selenium.WebDriver;		


/**
 * Servlet implementation class YahooFinanceScraper
 */
@WebServlet("/YahooFinanceScraper")
public class YahooFinanceScraper extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static WebDriver driver;

	Connection connect = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public YahooFinanceScraper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		launchBrowser();
		getCookies();
		getMyPortfolioPage();
		scrapeMyTotals();
		scrapeMyData();
		response.sendRedirect("/");
//		try {
//			connectToDB();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		terminateBrowser();
		
		// sleep for a few milliseconds then redirect to homepage 
		try {
			Thread.sleep(500);
			// send user back to where he came from
			response.sendRedirect("/");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void launchBrowser() {
		// add support for chrome driver
		String key = "webdriver.chrome.driver";
		String valuex = "/Users/melocal/Applications/lib/chromedriver";
		System.setProperty(key, valuex);
		
		driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize(); // maximize chrome browser
//			driver.manage().deleteAllCookies(); // exactly what it says
		
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	// get cookies
	public void getCookies() {

		// tutorial https://www.guru99.com/handling-cookies-selenium-webdriver.html
		try{
			Thread.sleep(500);
//			driver.get("https://finance.yahoo.com/portfolio/p_0/view/v1");
			// first get the domain
			driver.get("https://finance.yahoo.com");
			Thread.sleep(500);
	        File file = new File("Cookies.data");							
	        FileReader fileReader = new FileReader(file);							
	        BufferedReader buffReader = new BufferedReader(fileReader);							
	        String strline;			
	        while((strline=buffReader.readLine())!=null){									
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
		            System.out.println(ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure());
		            Thread.sleep(5000);
		        }
	        }
            fileReader.close();
            buffReader.close();
        } catch(Exception ex){					
        		ex.printStackTrace();			
        }
	}
	
	// go to My Portfolio page
	public void getMyPortfolioPage() {
		try {
			Thread.sleep(500);
			// now that i got my cookies, open to my account page
			String url = "https://finance.yahoo.com/portfolio/p_0/view/v1";
			driver.get(url);
			Thread.sleep(500);
	        System.out.println("140. opened My Portfolio page");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// scrape my totals
	public void scrapeMyTotals() {
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
	
	// scrape my data
	public void scrapeMyData() {
		try {
			Thread.sleep(500);
//			// now that i got my cookies, open to my account page
//			String contentTableXpath = "//*[@id=\"main\"]/section/section[2]/div[2]/table";
//			String contentTable = driver.findElement(By.xpath(contentTableXpath)).getText();
//			System.out.println(contentTable);
			System.out.println("inside YahooFinanceScraper.scrapeMyData()");
			Thread.sleep(5000);
			// now that i got my cookies, open to my account page
			String contentTableXpath = "//*[@id=\"main\"]/section/section[2]/div[2]/table";
			String contentTable = driver.findElement(By.xpath(contentTableXpath)).getText();
//			System.out.println(contentTable);
			System.out.println("218. fin with printing contentTable");
			System.out.println("219. printing contentTableRowXpath next...");
			
			String contentTableRowXpath = "//tbody/tr";
//			String contentTableColXpath = "//*[@id='main']/section/section[2]/div[2]/table/tbody/tr/td"; // 130
			String contentTableColXpath = "//tbody/tr[2]/td";
			
			int numRows = driver.findElements(By.xpath(contentTableRowXpath)).size();
			System.out.println("211. numRows == " + numRows);
			
			int numCols = driver.findElements(By.xpath(contentTableColXpath)).size();
			System.out.println("214. numCols == " + numCols);
			System.out.println("216. looping through table...");
			
			String[] td = new String[numCols];
			
			String tdData = "";

			for (int row=1; row <= numRows; row++) {
				for (int col = 1; col <= numCols; col++){
					
					tdData = driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[" + col + "]")).getText();

					// remove %, M and B from certain columns
					if(col == 4 || col == 7 || col == 9 || col == 10 || col == 13) {
						String pattern = "[%MB](?!\\d+.\\d+)"; 
						tdData = tdData.replaceAll(pattern,"");
						td[col-1] = tdData;
//						System.out.print(td[col-1] + "\t");
					} else {
						td[col-1] = tdData;
					}
					System.out.print(td[col-1] + "\t");
				}
				System.out.println();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// now close the browser
	public void terminateBrowser() {
		// sleep for a few seconds then close chrome browser
		try {
			Thread.sleep(9000);
			System.out.println("269. now exiting /YahooFinanceScraper");
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
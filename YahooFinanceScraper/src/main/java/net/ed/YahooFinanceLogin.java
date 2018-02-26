package net.ed;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Servlet implementation class YahooFinanceLogin
 */
@WebServlet("/YahooFinanceLogin")
public class YahooFinanceLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YahooFinanceLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String key = "webdriver.chrome.driver";
		String value = "/Users/melocal/Applications/lib/chromedriver";
		System.setProperty(key, value);
		
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize(); // maximize chrome browser
		driver.manage().deleteAllCookies(); // exactly what it says
		
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		// sleep for a few milliseconds then open YahooFinance homepage
		try {
			Thread.sleep(500);
			String url = "https://login.yahoo.com";
			driver.get(url);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// sleep for a few milliseconds then redirect to homepage 
		try {
			Thread.sleep(500);
			// send user back to where he came from
			response.sendRedirect("/");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// find the login button
//		try {
//			Thread.sleep(500);
//			String signInButtonXpath = "//*[@id='uh-signedin']"; // //*[@id="uh-signedin"]
//			driver.findElement(By.xpath(signInButtonXpath)).click();
//			System.out.println("clicked Sign In button");
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
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
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// get cookies
		try {
			Set<Cookie> cookies = driver.manage().getCookies();
			System.out.println("67. Cookies Size: " + cookies.size());
	
			Iterator<Cookie> it = cookies.iterator();
			while(it.hasNext()) {
				Cookie cookie = it.next();
				System.out.println(cookie.getName() + ";\n" +
									cookie.getPath() + ";\n" +
									cookie.getDomain() + ";\n" +
									cookie.getValue() + ";\n" +
									cookie.getExpiry());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} 

		// xpath for the Finance link
		//*[@id="Nav-0-DesktopNav"]/div/div[3]/div/div[1]/ul/li[2]/a
		// sleep for a few milliseconds then click Finance
		try {
			Thread.sleep(500);
			String financeLinkXpath = "//a[text()='Finance']"; // Finance link
			driver.findElement(By.xpath(financeLinkXpath)).click();
			System.out.println("clicked Finance link");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// sleep for a few milliseconds then click My Portfolio
//		try {
//			Thread.sleep(500);
//			String myPortfolioLinkXpath = "//*[@id=\"Nav-0-DesktopNav\"]/div/div[3]/div/div[1]/ul/li[2]/a"; // My Portfolio link
//			driver.findElement(By.xpath(myPortfolioLinkXpath)).click();
//			System.out.println("clicked My Portfolio link");
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// sleep for a few milliseconds then click My Watchlist 
//		try {
//			Thread.sleep(500);
//			String myWatchlistLinkXpath = "//*[@id=\"main\"]/section/section/div[2]/table/tbody/tr/td[1]/a"; // My Watchlist link
//			driver.findElement(By.xpath(myWatchlistLinkXpath)).click();
//			System.out.println("clicked My Watchlist link");
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

		
		// need to get my watchlist https://finance.yahoo.com/portfolio/p_0/view/v1
//        Document doc = Jsoup.connect("https://finance.yahoo.com/portfolio/p_0/view/v1").get();  
//        String title = doc.title();  
//        System.out.println("title is: " + title);

//		boolean yesOk = JsoupScraper.getPortfolio();
//		System.out.println(JsoupScraper.getPortfolio());
		
		// sleep for a few seconds then close chrome browser
//		try {
//			Thread.sleep(500);
//			String url = "https://finance.yahoo.com/portfolio/p_0/view/v1";
//			final Document doc = Jsoup.connect(url).get(); 
//			Elements body = doc.select("body");
//			String sp500 = body.select("span[class=_2K4ek _3Bucv]").text();
//			System.out.println("159. " + sp500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		// sleep for a few seconds then close chrome browser
		try {
			Thread.sleep(7000);
//			driver.quit();
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

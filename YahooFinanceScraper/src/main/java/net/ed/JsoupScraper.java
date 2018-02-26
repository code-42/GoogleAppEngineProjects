package net.ed;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupScraper {

	private static String title;

	public static boolean getSoup() throws IOException {
		
		// need to get my watchlist https://finance.yahoo.com/portfolio/p_0/view/v1
        Document doc = Jsoup.connect("https://finance.yahoo.com/portfolio/p_0/view/v1").get();  
        String title = doc.title();  
        System.out.println("title is: " + title);
        return true;
	}
	
	// xpath for portfolio value $24,908.60
	// //*[@id="main"]/section/header/div[1]/div[2]/p[1]
	public static String getPortfolio() throws IOException {
		
		// sleep for a few milliseconds then open YahooFinance homepage
		try {
			Thread.sleep(500);
			// need to get my watchlist https://finance.yahoo.com/portfolio/p_0/view/v1
			String url = "https://finance.yahoo.com/portfolio/p_0/view/v1";
			final Document doc = Jsoup.connect(url).get(); 
			
			Thread.sleep(500);
	        String title = doc.title();  
	        System.out.println("title is: " + title);
			
//			System.out.println(doc.select("span[class=_3Bucv]").text());
			
//	        String title = doc.title();  
//	        System.out.println("title is: " + title);
//	        return title;
			
//			String cssQuery = "//*[@id=\'main\']/section/header/div[1]/div[2]/p[1]";
			// //*[@id="main"]/section/header/div[1]/div[2]/p[1]
			// data-test="currentMarketValue"
//			Elements currentMarketValue = doc.select("data-test.currentMarketValue");
//			System.out.println("39. portfolioValue == " + currentMarketValue);
			
			//*[@id="main"]/section/section[2]/div[2]/table
			// table._1TagL tr
//			for (Element row : doc.select("table._1TagL tr")) {
//				final String symbol = row.select("._3Bucv").text();
//			}
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return title;

	}
	
	
}

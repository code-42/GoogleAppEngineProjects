package net.ed;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupScraper {

	public static boolean getSoup() throws IOException {
		
		// need to get my watchlist https://finance.yahoo.com/portfolio/p_0/view/v1
        Document doc = Jsoup.connect("https://finance.yahoo.com/portfolio/p_0/view/v1").get();  
        String title = doc.title();  
        System.out.println("title is: " + title);
        return true;
	}
	
}

package net.ed;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupScraper {

//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
////        Document doc = Jsoup.connect("http://www.javatpoint.com").get();  
////        String title = doc.title();  
////        System.out.println("title is: " + title);  
//
//	}
//	public JsoupScraper() {}
	
	public static boolean getSoup() throws IOException {
		
        Document doc = Jsoup.connect("http://www.javatpoint.com").get();  
        String title = doc.title();  
        System.out.println("title is: " + title);
        return true;
	}

	public static String getCoins() throws IOException {
		
        String url = "https://coinmarketcap.com/all/views/all/";
        final Document doc = Jsoup.connect(url)
                .timeout(10000)
                .maxBodySize(0)
                .get();

        final Elements bigTable = doc.select("tbody > tr"); // gets row by row

        for (Element row : bigTable) {

//            System.out.println(row.text() + "\n");
            return row.text();
        }
        return "";
	}
}

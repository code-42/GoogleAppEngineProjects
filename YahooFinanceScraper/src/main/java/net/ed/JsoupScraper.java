package net.ed;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupScraper {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        Document doc = Jsoup.connect("http://www.javatpoint.com").get();  
        String title = doc.title();  
        System.out.println("title is: " + title);
	}

}

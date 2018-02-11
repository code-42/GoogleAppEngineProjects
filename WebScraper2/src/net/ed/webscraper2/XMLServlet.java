package net.ed.webscraper2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;



public class XMLServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("console.log Hello from XMLServlet");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter writer = response.getWriter();
		writer.println("\n<html><body><h3>Hello from Print Writer</h3></body></html>");
		response.getWriter().print("\n<html><body><h3>Hello from XMLServlet</h3></body></html>");
		
        // Downloads the html from wikipedia and parses it
        final Document doc1 = Jsoup.connect("http://en.wikipedia.org/").get();

        // Selects a bunch of a tags
        final Elements newsHeadlines = doc1.select("#mp-itn b a");

        // Print to console
        for (Element headline : newsHeadlines) {
            System.out.println(headline.text());
        }
        System.out.println("\n---------------------------------------------------\n");
//        System.out.println("\n- now writing to csv file ...\n\n");

        // Print the outer html of the page
//        System.out.println(doc.outerHtml());
        
//		PrintWriter csv = new PrintWriter("results.csv");
//		csv.write("output to csv file");
//		csv.close();
        
        String url = "https://coinmarketcap.com/all/views/all/";
        String query = "";

        // Downloads the html from coinmarketcap.com and parses it
        final Document doc = Jsoup.connect(url + URLEncoder.encode(query,"UTF-8"))
//                .userAgent(USER_AGENT)
//                .timeout(20000)
//                .maxBodySize(0)
                .get();
        
        // tbody is first container inside of the first table
        Element table = doc.select("tbody").get(0);

        // Target each row in tbody
        Elements rows = table.select("tr");

        // Target each td inside of each row
        for (int r = 0; r < rows.size(); r++) {
            Element row = rows.get(r);
            Elements cols = row.select("td");

            // print td for each row
            for (int c = 0; c < cols.size(); c++) {
                System.out.print(cols.get(c).text() + "\t");
//                csv.write((cols.get(c).text() + "\t"));
            }

            // empty println is same as \n
            System.out.println();
//            csv.write("\n");
        }
//        csv.close();
        

	}

}

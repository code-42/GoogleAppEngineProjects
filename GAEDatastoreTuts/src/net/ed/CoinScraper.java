package net.ed;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.cloud.Timestamp;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Entity.Builder;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.StringValue;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.Transaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Servlet implementation class CoinScraper
 */
@WebServlet(description = "tutorial https://youtu.be/gU0RebsaFzQ?list=PLE0F6C1917A427E96", urlPatterns = { "/CoinScraper" })
public class CoinScraper extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  // [START build_service]
	  // Create an authorized Datastore service using Application Default Credentials.
	  private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

	  // Create a Key factory to construct keys associated with this project.
	  private final KeyFactory keyFactory = datastore.newKeyFactory().setKind("Coin");
	  // [END build_service]
	  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/plain");

		PrintWriter writer = response.getWriter();
		
	    // Instantiates a client
	    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

        // set up variables
        String rank = "";
        String name = "";
        String symbol = "";
        String marketCap = "";
        String price = "";
        String circSupply = "";
        String vol24h = "";
        String ch1h = "";
        String ch24h = "";
        String ch7d = "";

        // Setup for Jsoup
        String url = "https://coinmarketcap.com/all/views/all/";
        String query1 = "";
        
        // Downloads the html from coinmarketcap.com and parses it
        final Document doc = Jsoup.connect(url + URLEncoder.encode(query1,"UTF-8"))
                .timeout(20000)
                .maxBodySize(0)
                .get();
        
        // tbody is first container inside of the first table
        Element table = doc.select("tbody").get(0);

        // Target each row in tbody
        Elements rows = table.select("tr");

        // Target each td inside of each row
        for (int r = 0; r < rows.size(); r++) {
            Element row = rows.get(r);
            Elements cols = row.select("td");

            // loop through each col and get td for each
            for (int col = 0; col < cols.size(); col++) {
            	
            		// store the td in a variable
            		String td = (cols.get(col).text());

            		switch (col) {
            		case 0:
            			rank = td;
            			break;
            		case 1:
            			name = td;
            			break;
            		case 2:
            			symbol = td;
            			break;
            		case 3:
            			marketCap = td;
            			break;
            		case 4:
            			price = td;
            			break;
            		case 5:
            			circSupply = td;
            			break;
            		case 6:
            			vol24h = td;
            			break;
            		case 7:
            			ch1h = td;
            			break;
            		case 8:
            			ch24h = td;
            			break;
            		case 9:
            			ch7d = td;
            			break;   		            		
            		}
            }

			// while I still have the data for that row...
			// print row to page
			String printRow = rank;
			printRow += " " + name;
			printRow += " " + symbol;
			printRow += " " + marketCap;
			printRow += " " + price;
			printRow += " " + circSupply;
			printRow += " " + vol24h;
			printRow += " " + ch1h;
			printRow += " " + ch24h;
			printRow += " " + ch7d;
			
//			writer.print(printRow);
//			writer.println("");
			
//			var coins = query.filter('Kind', 'Coin').filter('symbol = ', 'BTC');
           		 
//        		// The Cloud Datastore key for the new entity
        		Key coinKey = datastore.allocateId(keyFactory.newKey());
       		
        		// Prepares the new entity
        		Entity coin = Entity.newBuilder(coinKey)
       			.set("created", Timestamp.now())
       			.set("rank", rank)
       		    .set("name", name)
       		    .set("symbol", symbol)
           		.set("marketCap", marketCap)
           		.set("price", price)
           		.set("circSupply", circSupply)
           		.set("vol24h", vol24h)
           		.set("ch1h", ch1h)
           		.set("ch24h", ch24h)
           		.set("ch7d", ch7d)
       		     .build();
       		
       		 // Saves the entity
       		 datastore.put(coin);
       		 
       		 // now done with this row, go get another

        }
        
        // print top 10 coins when finished
        // need to query datastore
//        Query query = new Query("Message");
        
        // clean up after yourself
        writer.close();
        
        // https://stackoverflow.com/questions/20181778/how-to-delete-an-entity-from-appengine-datastore-that-matching-a-query
        // Unfortunately the Java API doesn't provide delete all functionality. 
        // You need to iterate the results of the query and than delete all the entities.


	}

	

}

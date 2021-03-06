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

/**
 * Servlet implementation class WebScraper2
 */
@WebServlet(description = "tutorial https://youtu.be/gU0RebsaFzQ?list=PLE0F6C1917A427E96", urlPatterns = { "/CoinScraper" })
public class CoinScraper extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/plain");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter writer = response.getWriter();
		writer.println("\nThis data shamelessly scraped from CoinMarketCap.com");

        String url = "https://coinmarketcap.com/all/views/all/";
        String query = "";
        
        // Downloads the html from coinmarketcap.com and parses it
        final Document doc = Jsoup.connect(url + URLEncoder.encode(query,"UTF-8"))
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

            // print td for each row
            for (int c = 0; c < cols.size(); c++) {
//            		writer.print(cols.get(c).text() + ",");
//                System.out.print(cols.get(c).text() + "\t");
	        		String datarow = (cols.get(c).text() + ",");
	        		writer.print(datarow);
            }
            // empty println is same as \n
            System.out.println();
            writer.println();
        }
//        writer.println("</body></html>");
        writer.close();
		
	}

}

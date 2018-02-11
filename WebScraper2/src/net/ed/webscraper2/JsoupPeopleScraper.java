package net.ed.webscraper2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JsoupPeopleScraper
 */
@WebServlet(description = "Jsoup People Scraper", urlPatterns = { "/PeopleScraper" })
public class JsoupPeopleScraper extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//public class JsoupPeopleScraper {

    final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36";

//    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

//    public static void main(String[] args) throws UnirestException {

        // Replicate http call with Unirest.get() method
//        final HttpResponse<String> response2 = Unirest.get("https://www.peoplefinders.com/peoplesearch/searchresults?showAnimatedLoadingBar=true&search=People&fn=&ln=Smith&city=New+York&state=NY").asString();

    final Document htmlSnippet = Jsoup.connect("https://www.peoplefinders.com/peoplesearch/searchresults?showAnimatedLoadingBar=true&search=People&fn=&ln=Smith&city=New+York&state=NY").get();

    // Extract query string parameters
        final String lastName = "Smith";
        final String city = "New York";
        final String state = "NY";

//        final HttpResponse<String> response2 = Unirest.get("https://www.peoplefinders.com/GetResults?Latitude=0&Longitude=0&BoundSize=0&MaxRowsSpecified=True&" +
//                "MaxRows=80&Rows=10&Start=1&SearchEngineID=4&SearchEngineIDSpecified=True&SearchType=Peoplefinders.Services.Web.PAWebService.PeopleNameSearchCriteria&search=People&" +
//                "StateDropDownPlaceholder=State&LogMe=True&InvalidPhone=False&IsOptOutRequest=False&Widgets=System.Collections.Generic.Dictionary%602%5BSystem.String%2CSystem.Int32%5D&isVoucher=False&" +
//                "mobileAnimated=False&isBackgroundReport=False&isPhoneReport=False&isPaidSearch=False&poSearch=False")
//                .queryString("ln", lastName)
//                .queryString("LastName", lastName)
//                .queryString("city", city)
//                .queryString("state", state)
//                .asString();

//        System.out.println(response.getBody());

        // Parse the html snippet with Jsoup
//        final Document htmlSnippet = Jsoup.parseBodyFragment(response.getBody());

//        final PrintWriter out = new PrintWriter("results.txt");

//        final List<JsonMaker> resultList = new ArrayList<JsonMaker>();

        // Extract data from htmlSnippet
        for (Element peopleResult : htmlSnippet.select("div.resultRow > div.col-md-12 > div.row > div.col-md-11")) {

            final String name = peopleResult.child(0).selectFirst("a").text();  // good

            final Set<String> AKAnames = new HashSet<>();
            // TODO: extract each AKA from first column
			for (Element AKAResult : htmlSnippet.select("div.resultRow > div.col-md-12 > div.row > div.col-md-11 > div.col-md-3")) {

                for (Element AKAname : peopleResult.child(0).children().select("div")) {
                    AKAnames.add(AKAname.text());
                }
            }

            final String age = peopleResult.child(1).text();

            final Set<String> relatives = new HashSet<String>();

            for (Element relative : peopleResult.child(3).children().select("div > div")) {
                relatives.add(relative.text());
            }

            System.out.println(name + ", AKAs: " + String.join(", ", AKAnames) + ", age: " + age + ", relatives: " + String.join(", ", relatives));

            // Write results to text file
//            out.write(name + ", AKAs: " + String.join(", ", AKAnames) + ", age: " + age + ", relatives: " + String.join(", ", relatives)  + "\n");

//            resultList.add(new JsonMaker(name, AKAnames, age, relatives));

//            JsonMaker jsonPrinter = new JsonMaker(name, AKAnames, age, relatives);
//            jsonPrinter.PrintResults();
        }
    }
}


package net.ed;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class CoinMarketCapServlet
 */
@WebServlet("/CoinMarketCapServlet")
public class CoinMarketCapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoinMarketCapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		
	    response.setContentType("text/html");
	    response.setCharacterEncoding("UTF-8");

	    out.println("<html><body>");
	    out.println("Hello from CoinMarketCapServlet!<br>");
	    
        String url = "https://coinmarketcap.com/all/views/all/";
        final Document doc = Jsoup.connect(url)
                .timeout(10000)
                .maxBodySize(0)
                .get();

        final Elements bigTable = doc.select("tbody > tr"); // gets row by row

        for (Element row : bigTable) {

            out.println(row.text() + "<br>");
            
        }
        System.out.println("</body></html>");
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

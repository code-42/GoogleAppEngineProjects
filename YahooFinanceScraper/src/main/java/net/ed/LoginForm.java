package net.ed;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Servlet implementation class LoginForm
 */
@WebServlet("/LoginForm")
public class LoginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String url = "https://login.yahoo.com";
//		Connection.Response loginForm = (Response) Jsoup.connect(url)
//				.timeout(3000)
//				.method(Connection.Method.GET)
//				.execute();
//		
//		Map<String, String> loginCookies = loginForm.cookies();
//		Connection.Response login = Jsoup.connect(url)
//			    .data("username", "edev42@yahoo.com")
//			    .data("password","incorrect42")
//			    .cookies(loginCookies)
//			    .method(Connection.Method.POST)
//			    .execute(); 
//	
//	loginCookies = login.cookies();
//	
//	Document doc = Jsoup.connect(url)
//		    .cookies(loginCookies)
//		    .get();
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		// source http://www.scrapingauthority.com/2016/08/16/web-scraping-in-java-with-jsoup/
		
		String url = "https://login.yahoo.com";
		
		
//		Connection.Response loginForm = (Response) Jsoup.connect(url)
//				.timeout(3000)
//				.method(Connection.Method.GET)
//				.execute();
//		
//		Map<String, String> loginCookies = loginForm.cookies();
//		Connection.Response login = Jsoup.connect(url)
//			    .data("username", "edev42@yahoo.com")
//			    .data("password","incorrect42")
//			    .cookies(loginCookies)
//			    .method(Connection.Method.POST)
//			    .execute(); 
//	
//		loginCookies = login.cookies();
//		
//		Document doc = Jsoup.connect(url)
//			    .cookies(loginCookies)
//			    .get();
	}

}

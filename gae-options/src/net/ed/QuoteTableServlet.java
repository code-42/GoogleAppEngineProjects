package net.ed;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuoteTableServlet
 */
@WebServlet("/QuoteTableServlet")
public class QuoteTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuoteTableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// step 1: set the content type
		response.setContentType("text/html");
		
		// step 2: get the PrintWriter
		PrintWriter out = response.getWriter();
		
		// step 3: generate HTML content
		// get the parameter from the form
//		String ticker = request.getParameter("ticker");
		out.println("<html><body>");
		out.print("43. " + request.getParameter("ticker"));
//		out.print(QuoteTableDownload.getData(ticker));
		out.println("</body></html>");
//		QuoteTableDownload.getData(ticker);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

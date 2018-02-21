package net.ed;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import  net.ed.JsoupScraper;

/**
 * Servlet implementation class QuoteTableServlet
 */
@WebServlet(
	name = "QuoteTableServlet",
	urlPatterns = {"/QuoteTableServlet"}
)
public class QuoteTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
	      
	    response.setContentType("text/html");
	    response.setCharacterEncoding("UTF-8");

	    out.println("Hello from QuoteTableServlet!\r\n");

	}

}

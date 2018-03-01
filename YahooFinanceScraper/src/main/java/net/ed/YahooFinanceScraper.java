package net.ed;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.io.BufferedReader;		
import java.io.BufferedWriter;		
import java.io.File;		
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;		
import java.util.StringTokenizer;		

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import net.ed.LoginPageServlet.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;		


/**
 * Servlet implementation class YahooFinanceScraper
 */
@WebServlet("/YahooFinanceScraper")
public class YahooFinanceScraper extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public YahooFinanceScraper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

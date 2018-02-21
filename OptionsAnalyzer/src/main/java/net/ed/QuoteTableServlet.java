package net.ed;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuoteTableServlet
 */
@WebServlet(
	name = "QuoteTableServlet",
	urlPatterns = {"/QuoteTableServlet"}
)
public class QuoteTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// help from https://stackoverflow.com/questions/37391845/noclassdeffounderror-with-the-selenium-webdriver
    static WebDriver driver;
    static Wait<WebDriver> wait;
    static PrintWriter out; // = response.getWriter();
    String quoteFile = "/Users/melocal/Downloads/quotedata.dat";
    String ticker = "baba";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		out = response.getWriter();
	      
	    response.setContentType("text/html");
	    response.setCharacterEncoding("UTF-8");

	    out.println("Hello from QuoteTableServlet!<br>");
	    
        String key = "webdriver.chrome.driver";
        String value = "/Users/melocal/Applications/lib/chromedriver";
        System.setProperty(key, value);

        driver = new ChromeDriver(); // launch chrome
//        driver = new FirefoxDriver(); // launch firefox
        wait= new WebDriverWait(driver, 30);

        driver.manage().window().maximize(); // maximize chrome browser
        driver.manage().deleteAllCookies(); // exactly what it says

        // dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // goto url
        String url = "http://www.cboe.com/delayedquote/quote-table-download";
        driver.get(url);
//        boolean result;
        try {
            Thread.sleep(1000); // zzz
 
        // enter the ticker symbol
        String txtTickerID = "ContentTop_C005_txtTicker";
//        String ticker = request.getParameter("ticker");
        driver.findElement(By.id(txtTickerID)).sendKeys(ticker);
        System.out.println("Entered ticker symbol " + ticker.toUpperCase());
        
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        // sleep for 1 second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // press the download button
        String downloadButtonXpath = "ContentTop_C005_cmdSubmit";
        driver.findElement(By.id(downloadButtonXpath)).sendKeys(Keys.ENTER);
        System.out.println("pressed ENTER key");

        // sleep for 7 second
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // put this in a method
        // readFile works
        try {
            int count = countLines(quoteFile);
            System.out.println(count);
            
            readFile(quoteFile);
        }
        catch (IOException e) {
        	System.out.print("err:");
        		e.printStackTrace();
        }
        

        // sleep for 5 second
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        // move and rename quoteFile
        try {
	        	if(MoveAndRenameFile(quoteFile)) {
	                out.println("<br>Quittin' time...");
	                driver.quit();
	        	}
        } catch (IOException e) {
        		e.printStackTrace();
        }
        driver.quit();
	}
	

    public static int countLines (String quoteFile) throws IOException{
        try {

        		System.out.println(quoteFile);
            LineNumberReader reader = new LineNumberReader(new FileReader(quoteFile));
            int count = 0;
            String lineRead = "";
            while ((lineRead = reader.readLine()) != null) {}
            		count = reader.getLineNumber();
            
            reader.close();
            return count;
        }
        catch (IOException e) {
            System.out.println("IO Error: " + e);
        }
        return 0;
    }
    
	public static void readFile (String quoteFile) throws IOException{

		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(quoteFile);
			br = new BufferedReader(fr);
		
	    		String line;
	    		int i = 0;
	    		
	    		while ((line = br.readLine()) != null) {
	    			if ( i < 5) {
	    				// print the first 5 lines in the quote file
	    				out.println(line);
	    				i++;
	    			}
	    		}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public boolean MoveAndRenameFile (String quoteFile) throws IOException{
		
		System.out.println("inside OptionsAnalyzer.QuoteTableServlet.MoveAndRenameFile()");
    	
    		File aFile = new File(quoteFile);
    		
    		System.out.println(aFile.getCanonicalFile());
	    		
  		String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ".csv";
    		
  		File oldFile = aFile;
  		System.out.println("35. " + oldFile.getAbsolutePath());
  		File newFile = new File(newFileName);
  		System.out.println("37. " + newFile.getAbsolutePath());
  		boolean success = oldFile.renameTo(newFile);
  		
    		System.out.println("41. " + newFile.length());
    		System.out.println("42. " + newFile.getCanonicalPath());
    		
    		String fromFile = newFile.getName();
    		out.println("<br>216. " + fromFile);
    		String toFile = "/Users/melocal/Java_Projects/GAEProjects/OptionsAnalyzer/data/" + newFile.getName();
// linux box   		String toFile = "/home/melocal/JavaProjects/eclipse_projects/workspace/GoogleAppEngineProjects/gae-options/resources/" + newFile.getName();
    		out.println("<br>219. " + toFile);
    		
    		
    		FileUtils.moveFile(
    				FileUtils.getFile(fromFile),
    				FileUtils.getFile(toFile)
    		);
    		
    		return true;

    }
	

}

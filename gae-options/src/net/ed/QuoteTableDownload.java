package net.ed;

/**
 * this program downloads a certain options file from cboe every 60 seconds
 * the text file is named quotedata.dat
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class QuoteTableDownload {

    private static String quoteFile;

	public static void main(String[] args) throws IOException {
		
//		getData(ticker);
		System.out.println("hello from main()");
	}
	

	public static boolean getData(String ticker) {
//		String symbol =  ticker;
		
        String key = "webdriver.chrome.driver";
        String value = "/Users/melocal/Applications/lib/chromedriver";
        System.setProperty(key, value);

        WebDriver driver = new ChromeDriver(); // launch chrome
        driver.manage().window().maximize(); // maximize chrome browser
        driver.manage().deleteAllCookies(); // exactly what it says

        // dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // goto url
        String url = "http://www.cboe.com/delayedquote/quote-table-download";
        driver.get(url);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // enter the ticker symbol
        String txtTickerID = "ContentTop_C005_txtTicker";
        driver.findElement(By.id(txtTickerID)).sendKeys(ticker);
        System.out.println("Entered ticker symbol " + ticker.toUpperCase());

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

        
        // readFile works
        // print the first 5 lines in the quote file
        try {
            quoteFile = "/Users/melocal/Downloads/quotedata.dat";
            ReadQuoteData readme = new ReadQuoteData();
            int count = readme.countLines(quoteFile);
            System.out.println(count);
            
            readme.readFile(quoteFile);
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
	        	quoteFile = "/Users/melocal/Downloads/quotedata.dat";
	        	MoveAndRenameFile moveMe = new MoveAndRenameFile(quoteFile);
        } catch (IOException e) {
        		e.printStackTrace();
        }
        
        driver.quit();
        return true;
    }

}


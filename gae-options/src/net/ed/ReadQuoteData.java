package net.ed;

import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadQuoteData {
	
	private static String quoteFile = "/Users/melocal/Downloads/quotedata.dat";
		
    // constructor
    public ReadQuoteData() {}

    
    public static void readFile (String filename) throws IOException{

    		BufferedReader br = null; // new BufferedReader(new FileReader(filename));
    		FileReader fr = null;
    		try {
    			fr = new FileReader(quoteFile);
    			br = new BufferedReader(fr);
    		
	    		String line;
	    		int i = 0;
	    		while ((line = br.readLine()) != null) {
	    			if ( i < 5) {
	    				System.out.println(line);
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
    
    

    public static int countLines (String filename) throws IOException{
        try {

        		System.out.println(filename);
            LineNumberReader reader = new LineNumberReader(new FileReader(filename));
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
}
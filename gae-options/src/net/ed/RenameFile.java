package net.ed;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.*;
import java.text.*;
import java.text.SimpleDateFormat;

public class RenameFile {

	private File file;

	// constructor
    public RenameFile(File file) {
		this.file = file;
	}

    
	public RenameFile (String quoteFile) throws IOException{
    	
    		File aFile = new File(quoteFile);
    		
    		System.out.println(aFile.getCanonicalFile());
	    		
  		String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ".csv";
    		
  		File oldFile = aFile;
  		System.out.println("35. " + oldFile.getAbsolutePath());
  		File newFile = new File(newFileName);
  		System.out.println("37. " + newFile.getAbsolutePath());
  		boolean success = oldFile.renameTo(newFile);
  		
//  		this.file.renameTo(new File("mynewname.csv"));
    		System.out.println("41. " + newFile.length());
    		System.out.println("42. " + newFile.getCanonicalPath());
	
    }

}

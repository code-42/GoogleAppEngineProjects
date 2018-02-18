package net.ed;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.*;
import java.text.*;
import java.text.SimpleDateFormat;

public class RenameFile {

	private static File file;

    /**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

    public RenameFile (File file) throws IOException{
    	
    		this.file = file;    		
    		System.out.println(this.file.getCanonicalFile());
	    		
  		String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ".csv";
    		
  		
  		File oldFile = file;
  		System.out.println("35. " + oldFile.getAbsolutePath());
  		File newFile = new File(newFileName);
  		System.out.println("37. " + newFile.getAbsolutePath());
  		boolean success = oldFile.renameTo(newFile);
  		
//  		this.file.renameTo(new File("mynewname.csv"));
    		System.out.println("41. " + newFile.length());
    		System.out.println("42. " + newFile.getCanonicalPath());
	
    }

}

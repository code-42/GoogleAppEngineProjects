package net.ed;

import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import com.google.common.io.Files;

import java.util.*;
import java.text.*;
import java.text.SimpleDateFormat;

public class MoveAndRenameFile {

	private File file;

	// constructor
    public MoveAndRenameFile(File file) {
		this.file = file;
	}

    
	public MoveAndRenameFile (String quoteFile) throws IOException{
		
		System.out.println("inside MoveAndRenameFile()");
    	
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
    		
//    		Path from = FileSystems.getDefault().getPath(newFile.getName());
//    		Path to = FileSystems.getDefault().getPath("/Users/melocal/Java_Projects/GAEProjects/gae-options/resources/", newFile.getName());
//    		Path dir = FileSystems.getDefault().getPath("/Users/melocal/Java_Projects/GAEProjects/gae-options/resources/");
//    		try {
//    			Files.move(from, to, StandardCopyOption.REPLACE_EXISTING);
//    		} catch (IOException e) {
//    			System.err.println(e);
//    		}
    		
    		String fromFile = newFile.getName();
//    		String toFile = "/Users/melocal/Java_Projects/GAEProjects/gae-options/resources/" + newFile.getName();
    		String toFile = "/home/melocal/JavaProjects/eclipse_projects/workspace/GoogleAppEngineProjects/gae-options/resources/" + newFile.getName();
    		
    		
    		
    		FileUtils.moveFile(
    				FileUtils.getFile(fromFile),
    				FileUtils.getFile(toFile)
    		);
    		
//    		System.out.println("52. " + from);
//    		System.out.println("53. " + to);
    }

}

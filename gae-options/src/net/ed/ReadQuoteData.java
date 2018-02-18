package net.ed;

import java.io.LineNumberReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadQuoteData {

    // constructor
    public ReadQuoteData() {}

    public static int countLines (String filename) throws IOException{
        try {

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


/*
        try {
            Stream<String> stream = Files.lines(Paths.get(filename), Charset.defaultCharset());
            stream.forEach(System.out::println);
        }
    }
    catch (IOException e) {
        System.out.println("Error: " + e);
        }

 */
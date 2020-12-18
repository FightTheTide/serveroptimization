package edu.ucl.nima.content;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.unix4j.Unix4j;
import org.unix4j.line.Line;
import org.unix4j.unix.Grep;

//import reference to Unix4j class

public class ReadCsv {

    //static Path p = Paths.get("example.csv");
    // Path folder = p.getParent();
    private static final String address = "example.csv";
    
    File csvFile;
    //TODO Create an instance variable for the csv file

    public ReadCsv () {
        this.csvFile=new File(ReadCsv.address);
    //TODO Add a constructor for ReadCsv that accepts a String path for the csv file

    // (Optional) add aconstructor that accepts a File object for csv file

    }
    public List<Line> read(String regex) {
        //TODO reference the instance variable csv file here and grep it
        // string newaddress=this.csvFile.getPath() + "src\main\java\edu\ ucl\nima\content\example.csv";
        List<Line> lines = Unix4j.grep(regex, this.csvFile ).toLineList();
        

        String str=String.join("\n", lines);
		
        System.out.println("String is " + str);
        
        //List<Line> lines = Unix4j.grep("NINETEEN", file).toLineList();         
        
        // How should the return value look?
        return lines;
    }
}

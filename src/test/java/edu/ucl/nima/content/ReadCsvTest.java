package edu.ucl.nima.content;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.unix4j.line.Line;

public class ReadCsvTest {

    @Test
    public void shouldRequireADataFile()
    {
        ReadCsv csv = new ReadCsv();

        assertTrue( csv!=null );
    }

    @Test
    public void shouldSearchFileForMatchingLines()
    {
        // Instantiate ReadCsv
        ReadCsv csv = new ReadCsv();
        List<Line> a= csv.read("MEEP");
        // Verify a basic search of the csv file
        
        assertEquals(1, a.size());
    }

    @Test
    public void shouldSearchFileForMatchingLinesUsingRegex()
    {
        // Instantiate ReadCsv
        ReadCsv csv = new ReadCsv();
        List<Line> a = csv.read("M[E]{2,3}P");
        
        assertEquals(2, a.size());
    }

}
package converter.converter.corelogic;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class WriterOmaTest {

    private WriterOma kirjuri;
    private ArrayList<Integer> compounds = new ArrayList();
    private Reader lukija;
    private ArrayList<DataSet> results;

    @Before
    public void setUp() {
        ArrayList<File> filut = new ArrayList<>();
        filut.add(new File("150910Hyde056.D/results.txt"));
        filut.add(new File("150910Hyde057.D/results.txt"));
        filut.add(new File("150910Hyde058.D/results.txt"));

        this.lukija = new Reader();
        this.lukija.setFiles(filut);
        this.results = this.lukija.dataList();
        this.kirjuri = new WriterOma("test");
    }

    @Test
    public void testNewSheet() {
        this.kirjuri.newSheet(this.results);
        ArrayList<String[]> rivit = readResults();

        assertTrue("The file should only include file names!", rivit.size() == 3);
    }

    @Test
    public void testPrintConcAllLenght() {
        this.kirjuri.newSheet(this.results);
        this.kirjuri.printConcAll();
        ArrayList<String[]> rivit = readResults();

        assertTrue("There should be 53 rows!", rivit.size() == 53);
    }

    @Test
    public void testPrintConcAll() {
        this.kirjuri.newSheet(this.results);
        this.kirjuri.printConcAll();
        ArrayList<String[]> rivit = readResults();

        assertTrue("Nopinone concentration should be 27.35!", rivit.get(52)[3].equals("27.35"));
    }

    @Test
    public void testPrintResponseAllLenght() {
        this.kirjuri.newSheet(this.results);
        this.kirjuri.printResponseAll();
        ArrayList<String[]> rivit = readResults();

        assertTrue("There should be 53 rows!", rivit.size() == 53);
    }

    @Test
    public void testPrintResponseAll() {
        this.kirjuri.newSheet(this.results);
        this.kirjuri.printResponseAll();
        ArrayList<String[]> rivit = readResults();

        assertTrue("Nopinone response should be 6100!", rivit.get(52)[3].equals("6100"));
    }

    private ArrayList<String[]> readResults(){
        this.kirjuri.jobDone();
        ArrayList<String[]> rivit = new ArrayList<>();

        try {
            BufferedReader bfReader = new BufferedReader(new FileReader(new File("C:/Users/Toni T/Documents/Converter/Converter/test.csv")));
            String line = null;
            try {
                line = bfReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            while (line != null) {
                rivit.add(line.split(","));
                try {
                    line = bfReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return rivit;
    }

}

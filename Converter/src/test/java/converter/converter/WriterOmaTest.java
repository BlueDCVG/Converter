//package converter.converter;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.File;
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//
//public class WriterOmaTest {
//
//    private WriterOma kirjuri;
//    private ArrayList<Integer> compounds = new ArrayList();
//    private Reader lukija;
//
//    @Before
//    public void setUp() {
//        ArrayList<File> filut = new ArrayList<>();
//        filut.add(new File("150910Hyde056.D/results.txt"));
//        filut.add(new File("150910Hyde057.D/results.txt"));
//        filut.add(new File("150910Hyde058.D/results.txt"));
//
//        this.lukija = new Reader(filut);
//        this.kirjuri = new WriterOma("test.csv");
//        this.kirjuri.newSheet(this.lukija.dataList());
//    }
//
//    @Test
//    public void testprintConcAll() {
//        this.kirjuri.printConcAll();
//        this.kirjuri.jobDone();
//
//    }
//
//    @Test
//    public void testprintResponseAll() {
//        this.kirjuri.printResponseAll();
//        this.kirjuri.jobDone();
//    }
//
//}

package converter.converter;

import converter.converter.corelogic.DataSet;
import converter.converter.corelogic.Reader;
import converter.converter.corelogic.WriterOma;
import converter.converter.userinterface.UserInterface;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Main {

    /**
     * Main here just for testing the software.
     * @param args no idea
     */

    public static void main(String[] args) {
        UserInterface kayttoliittyma = new UserInterface();
        SwingUtilities.invokeLater(kayttoliittyma);



//        ArrayList<File> filut = new ArrayList<>();
//        filut.add(new File("150910Hyde056.D/results.txt"));
//        filut.add(new File("150910Hyde057.D/results.txt"));
//        filut.add(new File("150910Hyde058.D/results.txt"));
//
//        Reader lukija = new Reader(filut);
//        ArrayList<DataSet> tulokset = lukija.dataList();
//        WriterOma kirjuri = new WriterOma("testConcentration");
//        kirjuri.newSheet(tulokset);
//        kirjuri.printConcAll();
//        kirjuri.jobDone();
//
//        WriterOma kirjuri2 = new WriterOma("testResponce");
//        kirjuri2.newSheet(tulokset);
//        kirjuri2.printResponseAll();
//        kirjuri2.jobDone();

    }
}

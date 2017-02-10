package converter.converter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<File> filut = new ArrayList<>();
        filut.add(new File("150910Hyde056.D/results.txt"));
        filut.add(new File("150910Hyde057.D/results.txt"));
        filut.add(new File("150910Hyde058.D/results.txt"));

        Reader lukija = new Reader(filut);
        ArrayList<DataSet> tulokset = lukija.dataList();
        WriterOma kirjuri = new WriterOma("testConcentration");
        kirjuri.newSheet(tulokset);
        kirjuri.printConcAll();
        kirjuri.jobDone();

        WriterOma kirjuri2 = new WriterOma("testResponce");
        kirjuri2.newSheet(tulokset);
        kirjuri2.printResponseAll();
        kirjuri2.jobDone();

        System.out.println(tulokset.size());
        System.out.println(tulokset.get(0).getCompounds().get(0));
        System.out.println(tulokset.get(1).getCompounds().get(1));

        System.out.println(tulokset.get(0).getResponse().get(0));
        System.out.println(tulokset.get(1).getResponse().get(1));

        System.out.println(tulokset.get(0).getConcentration().get(0));
        System.out.println(tulokset.get(1).getConcentration().get(1));

        System.out.println(tulokset.get(0).getFileName());
        System.out.println(tulokset.get(1).getFileName());

        System.out.println(tulokset.get(0).getDate());
        System.out.println(tulokset.get(1).getDate());

        System.out.println(tulokset.get(0).getTime());
        System.out.println(tulokset.get(1).getTime());

        System.out.println(tulokset.get(0).getMultiplier());
        System.out.println(tulokset.get(1).getMultiplier());
    }
}

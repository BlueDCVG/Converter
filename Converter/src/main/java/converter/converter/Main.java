package converter.converter;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        Reader lukija = new Reader(new File("150910Hyde056.D/results.txt"));
        System.out.println(lukija.dataList().size());

        WriterOma kirjuri = new WriterOma();
        kirjuri.newSheet("test20170201");
    }
}

package converter.converter.corelogic;

import java.io.File;
import java.util.ArrayList;

import converter.converter.corelogic.DataSet;
import converter.converter.corelogic.Reader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReaderTest {

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
    }

    @Test
    public void setDate() {
        assertTrue("The date should be 15 Sep 2015", this.results.get(0).getDate().equals("15 Sep 2015"));
    }

    @Test
    public void setTime() {
        assertTrue("The time should be 20:23", this.results.get(0).getTime().equals("20:23"));
    }

    @Test
    public void setMultiplier() {
        assertTrue("The time should be 555", this.results.get(0).getMultiplier().equals("555"));
    }

    @Test
    public void addCompoundsFirst() {
        assertTrue("The first compound should be propanal", this.results.get(0).getCompounds().get(0).equals("1] Propanal"));
    }

    @Test
    public void addCompoundsLast() {
        assertTrue("The last compound should be nopinone", this.results.get(0).getCompounds().get(49).equals("50] Nopinone"));
    }

    @Test
    public void addResponseFirst() {
        assertTrue("The first compound should be 12819m", this.results.get(0).getResponse().get(0).equals("12819m"));
    }

    @Test
    public void addResponseLast() {
        assertTrue("The last compound should be 3205m", this.results.get(0).getResponse().get(49).equals("3205m"));
    }

    @Test
    public void addConcentrationFirst() {
        assertTrue("The first compound should be 249.4", this.results.get(0).getConcentration().get(0).equals("249.40"));
    }

    @Test
    public void addConcentrationLast() {
        assertTrue("The last compound should be 14.37", this.results.get(0).getConcentration().get(49).equals("14.37"));
    }

    @Test
    public void setFileName() {
        assertTrue("There first compound should be 150910Hyde056.D", this.results.get(0).getFileName().equals("150910Hyde056.D"));
    }

}

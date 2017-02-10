package converter.converter;

import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReaderTest {

    //Reader lukija = new Reader(new File("150910Hyde056.D/results.txt"));
   // ArrayList<String[]> result = lukija.dataList();

    public ReaderTest() {
    }


    @Test
    public void testDataListLenght() {
       // assertTrue("There should be exactly 76 rows on the model data", result.size() == 76);
    }

    @Test
    public void testDataListContent() {
      //  assertTrue("There shouldn't be to spaces never side by side", testSpaces());

    }

    public boolean testSpaces() {
        //for (int i = 0; i < result.size(); i++) {
          //  for (int j = 0; j < result.get(i).length; j++) {
            //    if (result.get(i)[j].contains("  ")) {
              //      return false;
              //  }
           // }
       // }
        return true;
    }
}

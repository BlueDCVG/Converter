package converter.converter.corelogic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class DataSetTest {

    private DataSet dataSet = new DataSet();

    @Before
    public void setUp(){
        dataSet.setDate("11");
        dataSet.setTime("22");
        dataSet.setMultiplier("33");
        dataSet.setFileName("44");
        dataSet.addCompounds("55");
        dataSet.addResponse("66");
        dataSet.addConcentration("77");
    }

    @Test
    public void getDate(){
        assertTrue("The date should be 11", dataSet.getDate().equals("11"));
    }

    @Test
    public void getTime(){
        assertTrue("The time should be 22", dataSet.getTime().equals("22"));
    }

    @Test
    public void getMultiplier(){
        assertTrue("The multiplier should be 33", dataSet.getMultiplier().equals("33"));
    }

    @Test
    public void getCompounds(){
        assertTrue("The compound should be 55", dataSet.getCompounds().get(0).equals("55"));
        assertTrue("There should be only one input", dataSet.getCompounds().size() == 1);
    }

    @Test
    public void getResponse() {
        assertTrue("The response should be 66", dataSet.getResponse().get(0).equals("66"));
        assertTrue("There should be only one input", dataSet.getResponse().size() == 1);
    }

    @Test
    public void getConcentration() {
        assertTrue("The concentration should be 77", dataSet.getConcentration().get(0).equals("77"));
        assertTrue("There should be only one input", dataSet.getConcentration().size() == 1);
    }

    @Test
    public void getFileName() {
        assertTrue("The filename should be 44", dataSet.getFileName().equals("44"));
    }

}
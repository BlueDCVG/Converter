package converter.converter.corelogic;

import java.util.ArrayList;

/**
 * DataSet is to specify a single measurement. It has all the data from single result file.
 */

public class DataSet {
    private String  date;
    private String  time;
    private String multiplier;
    private String fileName;
    private ArrayList<String> compounds;
    private ArrayList<String> responses;
    private ArrayList<String> concentrations;

    /**
     * DataSet generator. The multiplier is set by default to 1.
     * Note that fileName is not the read file name thus it is not called results every time.
     */

    public DataSet() {
        this.date = "";
        this.time = "";
        this.multiplier = "1";
        this.fileName = "";
        this.compounds = new ArrayList<>();
        this.responses = new ArrayList<>();
        this.concentrations = new ArrayList<>();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(String multiplier) {
        this.multiplier = multiplier;
    }

    public ArrayList<String> getCompounds() {
        return compounds;
    }

    /**
     * Adds a compound to the list.
     * @param compound is the compounds name added to the list
     */

    public void addCompounds(String compound) {
        this.compounds.add(compound);
    }

    public ArrayList<String> getResponse() {
        return responses;
    }

    /**
     * Adds a response to the list.
     * @param response is the compounds response added to the list
     */

    public void addResponse(String response) {
        this.responses.add(response);
    }

    public ArrayList<String> getConcentration() {
        return concentrations;
    }

    /**
     * Adds a concentration to the list.
     * @param concentration is the compounds concentration added to the list
     */

    public void addConcentration(String concentration) {
        this.concentrations.add(concentration);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}

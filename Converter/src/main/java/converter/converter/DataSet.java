package converter.converter;

import java.util.ArrayList;

public class DataSet {
    private String  date;
    private String  time;
    private String multiplier;
    private String fileName;
    private ArrayList<String> compounds;
    private ArrayList<String> responses;
    private ArrayList<String> concentrations;

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

    public void addCompounds(String compound) {
        this.compounds.add(compound);
    }

    public ArrayList<String> getResponse() {
        return responses;
    }

    public void addResponse(String response) {
        this.responses.add(response);
    }

    public ArrayList<String> getConcentration() {
        return concentrations;
    }

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

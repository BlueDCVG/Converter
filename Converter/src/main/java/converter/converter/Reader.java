package converter.converter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private ArrayList<File> files;
    private ArrayList<DataSet> dataSets;

    public Reader(ArrayList<File> files) {
        this.files = files;
        this.dataSets = new ArrayList<>();
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }

    public ArrayList<DataSet> dataList() {
        ArrayList<DataSet> dataSets = new ArrayList<>();

        for (File file : files) {

            try {
                BufferedReader bfReader = new BufferedReader(new FileReader(file));
                ArrayList<String[]> rivit = new ArrayList<>();
                String line = null;
                try {
                    line = bfReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                while (line != null) {
                    rivit.add(line.split("  +"));
                    try {
                        line = bfReader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                dataFiguration(rivit);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return this.dataSets;
    }

    private void dataFiguration(ArrayList<String[]> dataList) {
        DataSet dataPiste = new DataSet();
        int target = 0;

        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).length > 1) {
                if (dataList.get(i)[1].equals("Target Compounds")) {
                    target = i + 1;
                    break;
                }
                if (dataList.get(i)[1].startsWith("Data File :")) {
                    String[] fileNameRow = dataList.get(i)[1].split(" ");
                    dataPiste.setFileName(fileNameRow[fileNameRow.length - 1]);
                }
                if (dataList.get(i)[1].startsWith("Acq On")) {
                    String[] fileDate = dataList.get(i)[2].split(": ");
                    dataPiste.setDate(fileDate[fileDate.length - 1]);
                    dataPiste.setTime(dataList.get(i)[3]);
                }
                if (dataList.get(i).length > 3) {
                    if (dataList.get(i)[3].startsWith("Sample Multiplier:")) {
                        String[] fileMult = dataList.get(i)[3].split(" ");
                        dataPiste.setMultiplier(fileMult[fileMult.length - 1]);
                    }
                }
            }
        }

        for (int k = target; k < dataList.size(); k++) {
            if (dataList.get(k).length >= 2) {
                if (dataList.get(k)[1].contains("-----")) {
                    break;
                }
            }
            if (dataList.get(k).length >= 2) {
                dataPiste.addCompounds(dataList.get(k)[1]);
            }
            if (dataList.get(k).length >= 5) {
                if (dataList.get(k)[4].contains("N.D.")) {
                    dataPiste.addConcentration("0");
                    dataPiste.addResponse("0");
                } else {
                    dataPiste.addConcentration(dataList.get(k)[5]);
                    dataPiste.addResponse(dataList.get(k)[4]);
                }

            }

        }
        this.dataSets.add(dataPiste);
    }

}

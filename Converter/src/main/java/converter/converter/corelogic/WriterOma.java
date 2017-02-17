package converter.converter.corelogic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * WriterOma writes the csv file. It now writes two different types of files.
 * You have to make two files if you want all the data.
 * The file is written row by row. This is the easiest way to write a cvs document.
 */

public class WriterOma {
    private FileWriter writer;
    private ArrayList<DataSet> dataList;
    private ArrayList<String> compounds;

    /**
     * Opens the writer.
     * @param name  is the filename that is created.
     */

    public WriterOma(String name) {

        try {
            this.writer = new FileWriter(name + ".csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints the top three rows which contains filenames, measurements times and dates and multipliers.
     * @param dataList is the data given by the reader.
     */

    public void newSheet(ArrayList<DataSet> dataList) {
        this.dataList = dataList;
        printFileName();
        printDateNTime();
        printMult();

    }

    /**
     * Prints all the DataSets fileNames in a row.
     */

    private void printFileName() {
        try {
            writer.append(" " + ",");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (DataSet dataPiste : dataList) {
            try {
                writer.append(dataPiste.getFileName() + ",");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            writer.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints all the DataSets Dates and times in a row.
     */

    private void printDateNTime() {
        try {
            writer.append(" " + ",");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (DataSet dataPiste : dataList) {
            try {
                writer.append(dataPiste.getDate() + " " + dataPiste.getTime() + ",");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            writer.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints all the DataSets multipliers in a row.
     */

    private void printMult() {
        try {
            writer.append(" " + ",");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (DataSet dataPiste : dataList) {
            try {
                writer.append(dataPiste.getMultiplier() + ",");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            writer.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the writer.
     */

    public void jobDone() {
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Prints all the DataSets compounds and their concentrations in a rows.
     */

    public void printConcAll() {

        for (int i = 0; i < this.dataList.get(0).getCompounds().size() - 1; i++) {

            try {
                writer.append(this.dataList.get(0).getCompounds().get(i) + ",");
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (DataSet dataPiste : this.dataList) {
                try {
                    writer.append(dataPiste.getConcentration().get(i) + ",");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                writer.append('\n');
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Prints all the DataSets compounds and their responses in a rows.
     */

    public void printResponseAll() {

        for (int i = 0; i < this.dataList.get(0).getCompounds().size() - 1; i++) {

            try {
                writer.append(this.dataList.get(0).getCompounds().get(i) + ",");
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (DataSet dataPiste : this.dataList) {
                try {
                    writer.append(dataPiste.getResponse().get(i) + ",");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                writer.append('\n');
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

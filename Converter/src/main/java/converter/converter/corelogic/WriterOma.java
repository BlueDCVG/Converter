package converter.converter.corelogic;

import javax.swing.*;
import java.io.File;
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

    /**
     * Opens the writer.
     * @param name  is the filename that is created.
     */

    public WriterOma(File dir, String name) {

        try {
            File fileToWrite = new File(dir.getPath(), name + ".csv");
            this.writer = new FileWriter(fileToWrite);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error writing file!", JOptionPane.ERROR_MESSAGE);
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error writing file names!", JOptionPane.ERROR_MESSAGE);
        }

        for (DataSet dataPiste : dataList) {
            try {
                writer.append(dataPiste.getFileName() + ",");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error writing file names!", JOptionPane.ERROR_MESSAGE);
            }
        }

        try {
            writer.append('\n');
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error writing file names!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Prints all the DataSets Dates and times in a row.
     */

    private void printDateNTime() {
        try {
            writer.append(" " + ",");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (DataSet dataPiste : dataList) {
            try {
                writer.append(dataPiste.getDate() + " " + dataPiste.getTime() + ",");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error writing file date and time!", JOptionPane.ERROR_MESSAGE);
            }
        }

        try {
            writer.append('\n');
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error writing file date and time!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Prints all the DataSets multipliers in a row.
     */

    private void printMult() {
        try {
            writer.append(" " + ",");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error writing file multiplier!", JOptionPane.ERROR_MESSAGE);
        }

        for (DataSet dataPiste : dataList) {
            try {
                writer.append(dataPiste.getMultiplier() + ",");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error writing file multiplier!", JOptionPane.ERROR_MESSAGE);
            }
        }

        try {
            writer.append('\n');
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error writing file multiplier!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Closes the writer.
     */

    public void jobDone() {
        try {
            writer.flush();
            writer.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error in stopping writing file!", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Prints all the DataSets compounds and their concentrations in a rows.
     */

    public void printConcAll() {

        for (int i = 0; i < this.dataList.get(0).getCompounds().size() - 1; i++) {

            try {
                writer.append(this.dataList.get(0).getCompounds().get(i) + ",");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error writing file compounds names!", JOptionPane.ERROR_MESSAGE);
            }

            for (DataSet dataPiste : this.dataList) {
                try {
                    writer.append(dataPiste.getConcentration().get(i) + ",");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error writing file concentrations! Error in file: " + dataPiste.getFileName(), "Error writing file concentrations!", JOptionPane.ERROR_MESSAGE);
                }
            }

            try {
                writer.append('\n');
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error writing file concentrations!", JOptionPane.ERROR_MESSAGE);
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
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error writing file compounds names!", JOptionPane.ERROR_MESSAGE);
            }
            for (DataSet dataPiste : this.dataList) {
                try {
                    writer.append(dataPiste.getResponse().get(i) + ",");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error writing file responses! Error in file: " + dataPiste.getFileName(), "Error writing file responses!", JOptionPane.ERROR_MESSAGE);
                }
            }
            try {
                writer.append('\n');
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error writing file responses!", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}

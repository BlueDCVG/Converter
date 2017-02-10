package converter.converter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriterOma {

    private FileWriter writer;
    private ArrayList<DataSet> dataList;
    private ArrayList<String> compounds;

    public WriterOma(String name) {

        try {
            this.writer = new FileWriter(name + ".csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newSheet(ArrayList<DataSet> dataList) {
        this.dataList = dataList;

        printFileName();
        printDateNTime();
        printMult();

    }

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

    public void jobDone() {
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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

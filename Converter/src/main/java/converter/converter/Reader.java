
package converter.converter;
import java.io.*;
import java.util.ArrayList;

public class Reader {
    private BufferedReader bfReader;
    private StringBuilder sb;

    public Reader(File luettava) {
        try {
            this.bfReader = new BufferedReader(new FileReader(luettava));
            this.sb = new StringBuilder();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void setFile(File luettava) {
        try{
            this.bfReader = new BufferedReader(new FileReader(luettava));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String[]> dataList() {
        try {
            ArrayList<String[]> rivit = new ArrayList<>();
            String line = bfReader.readLine();

            while (line != null){
                rivit.add(line.split("  +"));
                line = bfReader.readLine();
            }
            return rivit;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}

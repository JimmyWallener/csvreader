package csvreader.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    CSVReader reader = null;
    private final String file = "sample.csv";
    String[] data;
    ArrayList<String[]> compiledData = new ArrayList<>();

    public ArrayList<String[]> csvParser(){

        try {
            reader = new CSVReader(new FileReader(file));

            while((data = reader.readNext()) != null) {
                compiledData.add(data);
            }

            reader.close();
        }catch(IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return compiledData;
    }
}

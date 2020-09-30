package sample;

import com.csvreader.CsvReader;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;



public class Controller {



    public Controller() {



    }

    // Allow the user to upload csv file for read/write and save. If no file is added, a default from sample is used
    public void filePathWay(Stage stage) {

        FileChooser fc = new FileChooser();
        fc.setTitle("CSV File Path");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV", "*.csv"));

        File file = fc.showOpenDialog(stage);
        if (file != null) {
            csvData(new File(String.valueOf(file)));
        } else {
            csvData(new File("src/sample.csv"));
        }


    }

    // Handling CSV data.
    // TODO: Handle data based on header count, regex for replacing chars. Set all values to List, try working with Object in Model/Constructor.
    public void csvData(File filePath) {
        try {
            CsvReader reader = new CsvReader(String.valueOf(filePath));
            reader.readHeaders();

            while (reader.readRecord()) {
                System.out.println(reader.getHeaderCount());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

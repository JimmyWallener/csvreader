package csvreader;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import csvreader.model.DataModel;
import csvreader.utils.FileManager;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    public TableColumn<DataModel,String> orderDate;
    @FXML
    public TableColumn<DataModel,String> region;
    @FXML
    public TableColumn<DataModel,String> rep1;
    @FXML
    public TableColumn<DataModel,String> rep2;
    @FXML
    public TableColumn<DataModel,String> item;
    @FXML
    public TableColumn<DataModel,String> units;
    @FXML
    public TableColumn<DataModel,String> unitCost;
    @FXML
    public TableColumn<DataModel,String> total;
    @FXML
    public MenuItem close;
    @FXML

    private TableView<DataModel> table;
    private ObservableList<DataModel> dm = FXCollections.observableArrayList();
    ArrayList<String[]> csvData = new ArrayList<>();
    FileManager fm = new FileManager();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    @FXML
    public void initialize(){

        orderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        orderDate.setOnEditCommit((td) -> {
            td.getTableView().getItems().get(td.getTablePosition().getRow()).setOrderDate(td.getNewValue());
        });

        region.setCellValueFactory(new PropertyValueFactory<>("region"));
        region.setOnEditCommit((td) -> {
            td.getTableView().getItems().get(td.getTablePosition().getRow()).setRegion(td.getNewValue());
        });

        rep1.setCellValueFactory(new PropertyValueFactory<>("rep1"));
        rep1.setOnEditCommit((td) -> {
            td.getTableView().getItems().get(td.getTablePosition().getRow()).setRep1(td.getNewValue());
        });

        rep2.setCellValueFactory(new PropertyValueFactory<>("rep2"));
        rep2.setOnEditCommit((td) -> {
            td.getTableView().getItems().get(td.getTablePosition().getRow()).setRep2(td.getNewValue());
        });

        item.setCellValueFactory(new PropertyValueFactory<>("item"));
        item.setOnEditCommit((td) -> {
            td.getTableView().getItems().get(td.getTablePosition().getRow()).setItem(td.getNewValue());
        });

        units.setCellValueFactory(new PropertyValueFactory<>("units"));
        units.setOnEditCommit((td) -> {
            td.getTableView().getItems().get(td.getTablePosition().getRow()).setUnits(td.getNewValue());
        });

        unitCost.setCellValueFactory(new PropertyValueFactory<>("unitCost"));
        unitCost.setOnEditCommit((td) -> {
            td.getTableView().getItems().get(td.getTablePosition().getRow()).setUnitCost(td.getNewValue());
        });

        total.setCellValueFactory(new PropertyValueFactory<>("total"));
        total.setOnEditCommit((td) -> {
            td.getTableView().getItems().get(td.getTablePosition().getRow()).setTotal(td.getNewValue());
        });

        table.setItems(getData());
        table.setOnMouseClicked((e) -> {
            if(e.getClickCount() == 2){
                dm.add(new DataModel("","","","","","","",""));
            }
        });

    }

    public ObservableList<DataModel> getData() {
        csvData = fm.csvParser();

        csvData.stream().skip(1).forEach(items -> {
            String date = items[0];
            String region = items[1];
            String rep1 = items[2];
            String rep2 = items[3];
            String item = items[4];
            String units = items[5];
            String unitCost = items[6];
            String total = items[7];
            dm.add(new DataModel(date,region,rep1,rep2,item,units,unitCost,total));

        });
        return dm;
    }



}


package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/* TODO: Figure out a way to change size of screen depending on amount of columns. Or restrict amount of columns
 * TODO: Build UI > Try using fxml
 * TODO:
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("CSV Database");

        Button fileButton = new Button("Attach File");
        GridPane gridPane = new GridPane();


        GridPane.setConstraints(fileButton, 0,0);
        Pane paneBox = new VBox(12);

        gridPane.getChildren().addAll(fileButton);
        paneBox.getChildren().addAll(gridPane);
        primaryStage.setScene(new Scene(paneBox, 800, 775));

        fileButton.setOnAction(actionEvent -> {
            Controller controller = new Controller();
            controller.filePathWay(primaryStage);
        });
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}

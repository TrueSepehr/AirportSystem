package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Airplane;
import data.Database;
import java.net.URL;
import java.util.ResourceBundle;

public class AirplaneController implements Initializable {

    @FXML TextField airplaneIdFLD;
    @FXML TextField seatsFLD;
    @FXML Button addBTN;
    @FXML TableView<Airplane> airplaneTBL;
    @FXML TableColumn<Airplane, String> airplaneIdCLM;
    @FXML TableColumn<Airplane, String> seatsCLM;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        addBTN.setOnAction(event -> {

            Airplane airplane = new Airplane(airplaneIdFLD.getText(), seatsFLD.getText());
            Database database = new Database();
            database.addAirplane(airplane);

        });

    }
}

package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Airplane;
import data.Database;
import java.net.URL;
import java.util.ResourceBundle;

public class AddFlightController implements Initializable {

    @FXML TextField flightIdFLD;
    @FXML TextField fromToFLD;
    @FXML TextField timeFLD;
    @FXML TextField durationFLD;
    @FXML TextField soldFLD;
    @FXML DatePicker datePCK;
    @FXML ChoiceBox<Airplane> airplaneCHB;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Database database = new Database();

        ObservableList<Airplane> airplanes = database.getAirplanes();

        airplaneCHB.setItems(airplanes);

    }
}

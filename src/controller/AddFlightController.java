package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Airplane;
import data.Database;
import model.Flight;

import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.ResourceBundle;

public class AddFlightController implements Initializable {

    @FXML TextField flightIdFLD;
    @FXML TextField fromToFLD;
    @FXML TextField timeFLD;
    @FXML TextField durationFLD;
    @FXML TextField soldFLD;
    @FXML DatePicker datePCK;
    @FXML ChoiceBox<Airplane> airplaneCHB;
    @FXML Button addBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Database database = new Database();
        ObservableList<Airplane> airplanes = database.getAirplanes();

        airplaneCHB.setItems(airplanes);

        addBTN.setOnAction(event -> {


            String[] timeSpilt = timeFLD.getText().split(":");

            Time time = new Time(Integer.parseInt(timeSpilt[0]), Integer.parseInt(timeSpilt[1]), Integer.parseInt(timeSpilt[2]));

            Flight flight = new Flight(Integer.parseInt(flightIdFLD.getText()), airplaneCHB.getValue(),
                    fromToFLD.getText(), Date.valueOf(datePCK.getValue()), time, soldFLD.getText(),
                    durationFLD.getText());

            database.addFlight(flight);

        });

    }
}

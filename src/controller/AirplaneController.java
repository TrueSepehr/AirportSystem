package controller;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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

    public static ObservableList<Airplane> data;
    public static TableView.TableViewSelectionModel<Airplane> selectionModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Database database = new Database();
        data = database.getAirplanes();
        selectionModel = airplaneTBL.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        airplaneIdCLM.setCellValueFactory(new PropertyValueFactory<>("id"));
        seatsCLM.setCellValueFactory(new PropertyValueFactory<>("seats"));

        airplaneTBL.setItems(data);

        data.addListener((ListChangeListener<Airplane>) c -> airplaneTBL.refresh());

        addBTN.setOnAction(event -> {

            Airplane airplane = new Airplane(airplaneIdFLD.getText(), seatsFLD.getText());
            database.addAirplane(airplane);
            data.add(airplane);

        });

    }

    public Airplane gatAirplaneById(String id) {

        for (Airplane datum : data) {
            if (datum.getId().equalsIgnoreCase(id)) {
                return datum;
            }
        }

        return null;
    }

}

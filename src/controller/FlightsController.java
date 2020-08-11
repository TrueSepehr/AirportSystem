package controller;

import data.Database;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Flight;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FlightsController implements Initializable {

    @FXML Button addBTN;
    @FXML Button removeBTN;
    @FXML Button editBTN;
    @FXML Button exitBTN;
    @FXML TableView<Flight> flightTBL;
    @FXML TableColumn<Flight, String> idCLM;
    @FXML TableColumn<Flight, String> airplaneCLM;
    @FXML TableColumn<Flight, String> fromToCLM;
    @FXML TableColumn<Flight, String> dateCLM;
    @FXML TableColumn<Flight, String> timeCLM;
    @FXML TableColumn<Flight, String> soldTicketsCLM;
    @FXML TableColumn<Flight, String> durationCLM;
    @FXML TableColumn<Flight, String> statusCLM;

    public static ObservableList<Flight> data;
    public static TableView.TableViewSelectionModel<Flight> selectionModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Database database = new Database();
        data = database.getFlights();
        selectionModel = flightTBL.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        idCLM.setCellValueFactory(new PropertyValueFactory<>("id"));
        airplaneCLM.setCellValueFactory(new PropertyValueFactory<>("airplane"));
        fromToCLM.setCellValueFactory(new PropertyValueFactory<>("fromTo"));
        dateCLM.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeCLM.setCellValueFactory(new PropertyValueFactory<>("time"));
        soldTicketsCLM.setCellValueFactory(new PropertyValueFactory<>("soldTickets"));
        durationCLM.setCellValueFactory(new PropertyValueFactory<>("duration"));
        statusCLM.setCellValueFactory(new PropertyValueFactory<>("status"));

        flightTBL.setItems(data);

        data.addListener((ListChangeListener<Flight>) c -> flightTBL.refresh());

        addBTN.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("../view/AddFlightScene.fxml"));
            try {

                loader.load();
                Stage dashboardStage = new Stage();
                dashboardStage.setScene(new Scene(loader.getRoot()));
                dashboardStage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

    }
}

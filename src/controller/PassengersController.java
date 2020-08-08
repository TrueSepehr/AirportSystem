package controller;

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
import model.Passenger;
import data.Database;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PassengersController implements Initializable {

    @FXML Button addBTN;
    @FXML Button editBTN;
    @FXML Button removeBTN;
    @FXML Button exitBTN;
    @FXML TableView<Passenger> passengersTBL;
    @FXML TableColumn<Passenger, String> idCLM;
    @FXML TableColumn<Passenger, String> nameCLM;
    @FXML TableColumn<Passenger, String> familyCLM;
    @FXML TableColumn<Passenger, String> usernameCLM;
    @FXML TableColumn<Passenger, String> phoneCLM;
    @FXML TableColumn<Passenger, String> addressCLM;
    @FXML TableColumn<Passenger, String> emailCLM;
    @FXML TableColumn<Passenger, String> creditCLM;

    public static ObservableList<Passenger> data;
    public static TableView.TableViewSelectionModel<Passenger> selectionModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Database database = new Database();
        data = database.getPassengers();
        selectionModel = passengersTBL.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        idCLM.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCLM.setCellValueFactory(new PropertyValueFactory<>("name"));
        familyCLM.setCellValueFactory(new PropertyValueFactory<>("family"));
        usernameCLM.setCellValueFactory(new PropertyValueFactory<>("username"));
        phoneCLM.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressCLM.setCellValueFactory(new PropertyValueFactory<>("address"));
        emailCLM.setCellValueFactory(new PropertyValueFactory<>("email"));
        creditCLM.setCellValueFactory(new PropertyValueFactory<>("credit"));

        passengersTBL.setItems(data);

        data.addListener(new ListChangeListener<Passenger>() {
            @Override
            public void onChanged(Change<? extends Passenger> c) {
                passengersTBL.refresh();
            }
        });

        addBTN.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(PassengersController.class.getResource("../view/AddPassengerScene.fxml"));

            try {

                loader.load();
                Stage signUpStage = new Stage();
                signUpStage.setScene(new Scene(loader.getRoot()));
                signUpStage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        editBTN.setOnAction(event -> {



        });

        editBTN.setOnAction(event -> {

        });

        exitBTN.setOnAction(event -> {

            exitBTN.getScene().getWindow().hide();

        });

    }

    static Passenger getPassenger() {
        return selectionModel.getSelectedItem();
    }


}

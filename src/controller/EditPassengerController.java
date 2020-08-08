package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Passenger;
import data.Database;
import java.net.URL;
import java.util.ResourceBundle;

public class EditPassengerController implements Initializable {

    @FXML TextField nameFLD;
    @FXML TextField familyFLD;
    @FXML TextField usernameFLD;
    @FXML TextField passwordFLD;
    @FXML TextField idFLD;
    @FXML TextField addressFLD;
    @FXML TextField phoneFLD;
    @FXML TextField emailFLD;
    @FXML TextField creditFLD;
    @FXML Button acceptBTN;
    @FXML Button cancelBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Passenger passenger = PassengersController.getPassenger();

        nameFLD.setText(passenger.getName());
        familyFLD.setText(passenger.getFamily());
        usernameFLD.setText(passenger.getUsername());
        passwordFLD.setText(passenger.getPassword());
        idFLD.setText(passenger.getId());
        addressFLD.setText(passenger.getAddress());
        phoneFLD.setText(passenger.getPhone());
        emailFLD.setText(passenger.getEmail());
        creditFLD.setText(passenger.getCredit());

        acceptBTN.setOnAction(event -> {

            Passenger newPassenger = new Passenger(idFLD.getText(), nameFLD.getText(), familyFLD.getText(),
                    usernameFLD.getText(), passwordFLD.getText(), phoneFLD.getText(), addressFLD.getText(),
                    emailFLD.getText(), creditFLD.getText());

            Database database = new Database();
            database.replacePassenger(newPassenger, passenger);

            acceptBTN.getScene().getWindow().hide();

        });

    }
}

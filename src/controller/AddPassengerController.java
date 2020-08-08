package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Passenger;
import data.Database;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPassengerController implements Initializable {

    @FXML TextField nameFLD;
    @FXML TextField familyFLD;
    @FXML TextField usernameFLD;
    @FXML PasswordField passwordFLD;
    @FXML PasswordField CPasswordFLD;
    @FXML TextField idFLD;
    @FXML TextField addressFLD;
    @FXML TextField phoneFLD;
    @FXML TextField emailFLD;
    @FXML TextField creditFLD;
    @FXML Button addBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        addBTN.setOnAction(event -> {

            if (!nameIsValid() && !familyIsValid() && !usernameIsValid() && !passwordIsValid() && !idIsValid() &&
                    !addressIsValid() && !emailIsValid() && !phoneIsValid() && !creditIsValid()){

                if (passwordFLD.getText().equals(CPasswordFLD.getText())){

                    Passenger passenger = new Passenger(idFLD.getText(), nameFLD.getText(), familyFLD.getText(),
                            usernameFLD.getText(), passwordFLD.getText(), phoneFLD.getText(), addressFLD.getText(),
                            emailFLD.getText(), creditFLD.getText());

                    Database database = new Database();
                    database.addPassenger(passenger);

                    addBTN.getScene().getWindow().hide();

                }
            }
        });
    }

    public boolean nameIsValid() {
        return nameFLD.getText().isEmpty();
    }

    public boolean familyIsValid() {
        return familyFLD.getText().isEmpty();
    }

    public boolean usernameIsValid() {
        return usernameFLD.getText().isEmpty();
    }

    public boolean passwordIsValid() {
        return passwordFLD.getText().isEmpty();
    }

    public boolean idIsValid() {
        return idFLD.getText().isEmpty();
    }

    public boolean addressIsValid() {
        return addressFLD.getText().isEmpty();
    }

    public boolean emailIsValid() {
        return emailFLD.getText().isEmpty();
    }

    public boolean phoneIsValid() {
        return phoneFLD.getText().isEmpty();
    }

    public boolean creditIsValid() {
        return creditFLD.getText().isEmpty();
    }



}

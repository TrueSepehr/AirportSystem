package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Passenger;
import data.Database;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

                if (phoneRegex(phoneFLD.getText())){

                    if (emailRegex(emailFLD.getText())){

                        if (passwordFLD.getText().equals(CPasswordFLD.getText())){

                            Passenger passenger = new Passenger(idFLD.getText(), nameFLD.getText(), familyFLD.getText(),
                                    usernameFLD.getText(), passwordFLD.getText(), phoneFLD.getText(), addressFLD.getText(),
                                    emailFLD.getText(), creditFLD.getText());

                            Database database = new Database();
                            database.addPassenger(passenger);

                            addBTN.getScene().getWindow().hide();

                        } else {
                            Alert alert = new Alert(Alert.AlertType.NONE);
                            alert.setAlertType(Alert.AlertType.ERROR);
                            alert.setContentText("Passwords not equal!");
                            alert.show();
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.NONE);
                        alert.setAlertType(Alert.AlertType.ERROR);
                        alert.setContentText("Your email is invalid!");
                        alert.show();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("Your phone number is invalid!");
                    alert.show();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Fill all Fields...");
                alert.show();
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

    public boolean emailRegex(String email) {

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

    public boolean phoneRegex(String phone) {

        String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();

    }



}

package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeDashboardController implements Initializable {

    @FXML Button profileBTN;
    @FXML Button passengersBTN;
    @FXML Button flightsBTN;
    @FXML Button messagesBTN;
    @FXML Button exitBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        profileBTN.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("../view/ProfileScene.fxml"));

            try {
                loader.load();
                Stage profileStage = new Stage();
                profileStage.setScene(new Scene(loader.getRoot()));
                profileStage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        passengersBTN.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("../view/PassengersScene.fxml"));

            try {
                loader.load();
                Stage passengersStage = new Stage();
                passengersStage.setScene(new Scene(loader.getRoot()));
                passengersStage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        flightsBTN.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("../view/FlightsScene.fxml"));

            try {
                loader.load();
                Stage flightStage = new Stage();
                flightStage.setScene(new Scene(loader.getRoot()));
                flightStage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        messagesBTN.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("../view/MessageScene.fxml"));

            try {
                loader.load();
                Stage messageStage = new Stage();
                messageStage.setScene(new Scene(loader.getRoot()));
                messageStage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        exitBTN.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("../view/LoginScene.fxml"));

            try {
                loader.load();
                Stage employeeStage = new Stage();
                employeeStage.setScene(new Scene(loader.getRoot()));
                employeeStage.show();
                exitBTN.getScene().getWindow().hide();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
    }
}

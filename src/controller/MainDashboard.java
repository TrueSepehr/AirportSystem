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

public class MainDashboard implements Initializable {

   @FXML Button profileBTN;
   @FXML Button passengersBTN;
   @FXML Button employeesBTN;
   @FXML Button airplanesBTN;
   @FXML Button flightsBTN;
   @FXML Button ticketsBTN;
   @FXML Button messagesBTN;
   @FXML Button exitBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        passengersBTN.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(MainDashboard.class.getResource("../view/PassengersScene.fxml"));

            try {
                loader.load();
                Stage passengersStage = new Stage();
                passengersStage.setScene(new Scene(loader.getRoot()));
                passengersStage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        employeesBTN.setOnAction(event ->{

            FXMLLoader loader = new FXMLLoader(MainDashboard.class.getResource("../view/EmployeesScene.fxml"));

            try {
                loader.load();
                Stage employeeStage = new Stage();
                employeeStage.setScene(new Scene(loader.getRoot()));
                employeeStage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        airplanesBTN.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(MainDashboard.class.getResource("../view/airplaneScene.fxml"));

            try {
                loader.load();
                Stage airplaneScene = new Stage();
                airplaneScene.setScene(new Scene(loader.getRoot()));
                airplaneScene.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        flightsBTN.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(MainDashboard.class.getResource("../view/FlightsScene.fxml"));

            try {
                loader.load();
                Stage flightStage = new Stage();
                flightStage.setScene(new Scene(loader.getRoot()));
                flightStage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        profileBTN.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(MainDashboard.class.getResource("../view/ProfileScene.fxml"));

            try {
                loader.load();
                Stage employeeStage = new Stage();
                employeeStage.setScene(new Scene(loader.getRoot()));
                employeeStage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        messagesBTN.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(MainDashboard.class.getResource("../view/ShowMessageScene.fxml"));

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

            FXMLLoader loader = new FXMLLoader(MainDashboard.class.getResource("../view/LoginScene.fxml"));

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

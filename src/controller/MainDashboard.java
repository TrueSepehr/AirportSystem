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

   @FXML Button passengersBTN;
   @FXML Button employeesBTN;
   @FXML Button airplanesBTN;
   @FXML Button flightsBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        passengersBTN.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("../view/PassengersScene.fxml"));

            try {

                loader.load();
                Stage dashboardStage = new Stage();
                dashboardStage.setScene(new Scene(loader.getRoot()));
                dashboardStage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }


        });

        employeesBTN.setOnAction(event ->{

            FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("../view/EmployeesScene.fxml"));
            try {

                loader.load();
                Stage dashboardStage = new Stage();
                dashboardStage.setScene(new Scene(loader.getRoot()));
                dashboardStage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        airplanesBTN.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("../view/airplaneScene.fxml"));
            try {

                loader.load();
                Stage dashboardStage = new Stage();
                dashboardStage.setScene(new Scene(loader.getRoot()));
                dashboardStage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        flightsBTN.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("../view/FlightsScene.fxml"));
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

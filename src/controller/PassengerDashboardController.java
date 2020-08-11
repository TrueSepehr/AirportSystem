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

public class PassengerDashboardController implements Initializable {

    @FXML Button profileBTN;
    @FXML Button buyBTN;
    @FXML Button creditBTN;
    @FXML Button purchasesBTN;
    @FXML Button messagesBTN;
    @FXML Button exitBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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



    }
}

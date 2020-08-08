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

public class FlightsController implements Initializable {

    @FXML Button addBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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

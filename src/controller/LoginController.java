package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import data.Database;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML TextField usernameFLD;
    @FXML TextField passwordFLD;
    @FXML Button loginBTN;
    @FXML Button signUpBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loginBTN.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("../view/MainDashboardScene.fxml"));

            try {
                loader.load();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            //check
            Database database = new Database();
            String password = database.getPasswordByUsername(usernameFLD.getText());

            if (!passwordIsValid() && !usernameIsValid()){

                if (passwordFLD.getText().equals(password)){

                    Stage dashboardStage = new Stage();
                    dashboardStage.setScene(new Scene(loader.getRoot()));
                    dashboardStage.show();
                    loginBTN.getScene().getWindow().hide();

                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("Your username or password is wrong!");
                    alert.show();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Fill all Fields...");
                alert.show();
            }
        });

        signUpBTN.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("../view/SignUpScene.fxml"));

            try {

                loader.load();
                Stage signUpStage = new Stage();
                signUpStage.setScene(new Scene(loader.getRoot()));
                signUpStage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
    }

    public boolean usernameIsValid() {
        return usernameFLD.getText().isEmpty();
    }

    public boolean passwordIsValid() {
        return passwordFLD.getText().isEmpty();
    }

}

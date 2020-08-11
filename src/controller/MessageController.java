package controller;

import data.Database;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import model.Message;
import java.net.URL;
import java.util.ResourceBundle;

public class MessageController implements Initializable {

    @FXML TextArea subjectArea;
    @FXML TextArea messageArea;
    @FXML Button sendBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Database database = new Database();

        sendBTN.setOnAction(event -> {

            Message message = new Message(subjectArea.getText(), messageArea.getText());
            database.addMessage(message);

            sendBTN.getScene().getWindow().hide();

        });

    }
}

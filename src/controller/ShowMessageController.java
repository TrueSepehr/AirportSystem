package controller;

import data.Database;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Message;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowMessageController implements Initializable {

    @FXML TableView<Message> messagesTBL;
    @FXML TableColumn<Message, String> subjectCLM;
    @FXML TableColumn<Message, String> messageCLM;

    public static ObservableList<Message> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Database database = new Database();
        data = database.getMessages();

        subjectCLM.setCellValueFactory(new PropertyValueFactory<>("subject"));
        messageCLM.setCellValueFactory(new PropertyValueFactory<>("message"));

        data.addListener((ListChangeListener<Message>) c -> messagesTBL.refresh());

        messagesTBL.setItems(data);

    }
}

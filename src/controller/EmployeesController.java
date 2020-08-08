package controller;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Employee;
import data.Database;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeesController implements Initializable {

    @FXML Button addBTN;
    @FXML Button removeBTN;
    @FXML Button editBTN;
    @FXML Button exitBTN;
    @FXML TableView<Employee> employeesTBL;
    @FXML TableColumn<Employee, String> idCLM;
    @FXML TableColumn<Employee, String> nameCLM;
    @FXML TableColumn<Employee, String> familyCLM;
    @FXML TableColumn<Employee, String> usernameCLM;
    @FXML TableColumn<Employee, String> phoneCLM;
    @FXML TableColumn<Employee, String> addressCLM;
    @FXML TableColumn<Employee, String> emailCLM;
    @FXML TableColumn<Employee, String> incomeCLM;

    public static ObservableList<Employee> data;
    public static TableView.TableViewSelectionModel<Employee> selectionModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Database database = new Database();
        data = database.getEmployees();
        selectionModel = employeesTBL.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        idCLM.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCLM.setCellValueFactory(new PropertyValueFactory<>("name"));
        familyCLM.setCellValueFactory(new PropertyValueFactory<>("family"));
        usernameCLM.setCellValueFactory(new PropertyValueFactory<>("username"));
        phoneCLM.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressCLM.setCellValueFactory(new PropertyValueFactory<>("address"));
        emailCLM.setCellValueFactory(new PropertyValueFactory<>("email"));
        incomeCLM.setCellValueFactory(new PropertyValueFactory<>("income"));
        employeesTBL.setItems(data);

        data.addListener(new ListChangeListener<Employee>() {
            @Override
            public void onChanged(Change<? extends Employee> c) {
                employeesTBL.refresh();
            }
        });

        addBTN.setOnAction(event ->{

            FXMLLoader loader = new FXMLLoader(EmployeesController.class.getResource("../view/AddEmployeeScene.fxml"));

            try {
                loader.load();
                Stage signUpStage = new Stage();
                signUpStage.setScene(new Scene(loader.getRoot()));
                signUpStage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        editBTN.setOnAction(event ->{

            FXMLLoader loader = new FXMLLoader(EmployeesController.class.getResource("../view/EditEmployeeScene.fxml"));

            try {

                loader.load();
                Stage signUpStage = new Stage();
                signUpStage.setScene(new Scene(loader.getRoot()));
                signUpStage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        removeBTN.setOnAction(event -> {

            database.removeEmployee(getEmployee());
            data.remove(getEmployee());

        });

        exitBTN.setOnAction(event -> {

            exitBTN.getScene().getWindow().hide();

        });

    }

    static Employee getEmployee() {
        return selectionModel.getSelectedItem();
    }
}

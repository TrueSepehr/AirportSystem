package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Employee;
import data.Database;
import java.net.URL;
import java.util.ResourceBundle;

public class EditEmployeeController implements Initializable {

    @FXML TextField nameFLD;
    @FXML TextField familyFLD;
    @FXML TextField usernameFLD;
    @FXML TextField passwordFLD;
    @FXML TextField idFLD;
    @FXML TextField addressFLD;
    @FXML TextField phoneFLD;
    @FXML TextField emailFLD;
    @FXML TextField incomeFLD;
    @FXML Button acceptBTN;
    @FXML Button cancelBTN;
    @FXML Label incomeLBL;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Employee employee = EmployeesController.getEmployee();

        nameFLD.setText(employee.getName());
        familyFLD.setText(employee.getFamily());
        usernameFLD.setText(employee.getUsername());
        passwordFLD.setText(employee.getPassword());
        idFLD.setText(employee.getId());
        addressFLD.setText(employee.getAddress());
        phoneFLD.setText(employee.getPhone());
        emailFLD.setText(employee.getEmail());
        incomeFLD.setText(employee.getIncome());

        acceptBTN.setOnAction(event -> {

            Employee newEmployee = new Employee(idFLD.getText(), nameFLD.getText(), familyFLD.getText(),
                    usernameFLD.getText(), passwordFLD.getText(), phoneFLD.getText(), addressFLD.getText(),
                    emailFLD.getText(), incomeFLD.getText());

            Database database = new Database();
            database.replaceEmployee(newEmployee, employee);

            acceptBTN.getScene().getWindow().hide();

        });

        cancelBTN.setOnAction(event -> cancelBTN.getScene().getWindow().hide());


    }
}

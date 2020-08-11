package controller;

import data.Database;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Employee;
import model.Passenger;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

    @FXML Button saveBTN;
    @FXML Button cancelBTN;
    @FXML TextField nameFLD;
    @FXML TextField familyFLD;
    @FXML TextField usernameFLD;
    @FXML TextField phoneFLD;
    @FXML TextField emailFLD;
    @FXML TextField addressFLD;
    @FXML PasswordField currentPasswordFLD;
    @FXML PasswordField newPasswordFLD;
    @FXML PasswordField cNewPasswordFLD;
    @FXML CheckBox passwordCheckBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Database database = new Database();

        String username = LoginController.loginUsername;

        if (database.getTypeByUsername(username).equalsIgnoreCase("employee")) {

            Employee employee = database.getEmployeeByUsername(username);

            nameFLD.setText(employee.getName());
            familyFLD.setText(employee.getFamily());
            usernameFLD.setText(employee.getUsername());
            phoneFLD.setText(employee.getPhone());
            emailFLD.setText(employee.getEmail());
            addressFLD.setText(employee.getAddress());

        } else if (database.getTypeByUsername(username).equalsIgnoreCase("passenger")) {

            Passenger passenger = database.getPassengerByUsername(username);

            nameFLD.setText(passenger.getName());
            familyFLD.setText(passenger.getFamily());
            usernameFLD.setText(passenger.getUsername());
            phoneFLD.setText(passenger.getPhone());
            emailFLD.setText(passenger.getEmail());
            addressFLD.setText(passenger.getAddress());

        } else if (database.getTypeByUsername(username).equalsIgnoreCase("admin")) {

            Employee employee = database.getEmployeeByUsername(username);

            nameFLD.setText(employee.getName());
            familyFLD.setText(employee.getFamily());
            usernameFLD.setText(employee.getUsername());
            phoneFLD.setText(employee.getPhone());
            emailFLD.setText(employee.getEmail());
            addressFLD.setText(employee.getAddress());

        }

        saveBTN.setOnAction(event -> {

            if (database.getTypeByUsername(username).equalsIgnoreCase("employee") &&
            database.getTypeByUsername(username).equalsIgnoreCase("admin")) {

                String id = database.getEmployeeByUsername(username).getId();

                Employee employee = new Employee(null, nameFLD.getText(), familyFLD.getText(), usernameFLD.getText(),
                        null, phoneFLD.getText(), emailFLD.getText(), addressFLD.getText());

                database.editEmployeeProfile(employee, id);


            } else if (database.getTypeByUsername(username).equalsIgnoreCase("passenger")) {

                String id = database.getPassengerByUsername(username).getId();

                Passenger passenger = new Passenger(null, nameFLD.getText(), familyFLD.getText(), usernameFLD.getText(),
                        null, phoneFLD.getText(), emailFLD.getText(), addressFLD.getText());

                database.editPassengerProfile(passenger, id);

            }

            if (passwordCheckBox.isSelected()) {



            }

        });

        cancelBTN.setOnAction(event -> {

            cancelBTN.getScene().getWindow().hide();

        });

    }
}

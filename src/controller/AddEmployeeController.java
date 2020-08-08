package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Employee;
import data.Database;
import java.net.URL;
import java.util.ResourceBundle;

public class AddEmployeeController implements Initializable {

    @FXML TextField nameFLD;
    @FXML TextField familyFLD;
    @FXML TextField usernameFLD;
    @FXML PasswordField passwordFLD;
    @FXML PasswordField CPasswordFLD;
    @FXML TextField idFLD;
    @FXML TextField addressFLD;
    @FXML TextField phoneFLD;
    @FXML TextField emailFLD;
    @FXML TextField incomeFLD;
    @FXML Button addBTN;
    @FXML Label incomeLBL;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        addBTN.setOnAction(event ->{

            if (!nameIsValid() && !familyIsValid() && !usernameIsValid() && !passwordIsValid() && !idIsValid() &&
                    !addressIsValid() && !emailIsValid() && !phoneIsValid() && !incomeIsValid()){

                if (passwordFLD.getText().equals(CPasswordFLD.getText())){

                    Employee employee = new Employee(idFLD.getText(), nameFLD.getText(), familyFLD.getText(), usernameFLD.getText(),
                            passwordFLD.getText(), phoneFLD.getText(), addressFLD.getText(), emailFLD.getText(), incomeFLD.getText());

                    Database database = new Database();
                    database.addEmployee(employee);

                }
            }
        });
    }

    public boolean nameIsValid() {
        return nameFLD.getText().isEmpty();
    }

    public boolean familyIsValid() {
        return familyFLD.getText().isEmpty();
    }

    public boolean usernameIsValid() {
        return usernameFLD.getText().isEmpty();
    }

    public boolean passwordIsValid() {
        return passwordFLD.getText().isEmpty();
    }

    public boolean idIsValid() {
        return idFLD.getText().isEmpty();
    }

    public boolean addressIsValid() {
        return addressFLD.getText().isEmpty();
    }

    public boolean emailIsValid() {
        return emailFLD.getText().isEmpty();
    }

    public boolean phoneIsValid() {
        return phoneFLD.getText().isEmpty();
    }

    public boolean incomeIsValid() { return incomeFLD.getText().isEmpty(); }

}

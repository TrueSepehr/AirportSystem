package data;

import controller.EmployeesController;
import controller.PassengersController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Airplane;
import model.Employee;
import model.Passenger;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    static private Connection connection;
    static private Statement query;
    static private ResultSet resultSet;

    static public Statement createConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/airportDB", "root", "");

            query = connection.createStatement();

            System.out.println("Connected to Database");

            return query;

        }catch (ClassNotFoundException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        catch (SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return null;
    }

    public String getPasswordByUsername(String username) {

        try {

            query = createConnection();
            if (query != null) {
                resultSet = query.executeQuery("SELECT * FROM employees");
            }

            while (resultSet.next()) {
                String data = resultSet.getString("username");

                if (username.equalsIgnoreCase(data)){
                    return resultSet.getString("password");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            closeConnection();
        }

        return "";
    }

    public void addPassenger(Passenger passenger) {

        try {
            query = createConnection();
            if (query != null) {
                query.executeUpdate("INSERT INTO passengers VALUES ( '"
                        + passenger.getName() + "', '"
                        + passenger.getFamily() + "', '"
                        + passenger.getUsername()  + "', '"
                        + passenger.getPassword() + "', '"
                        + passenger.getId() + "', '"
                        + passenger.getPhone() + "', '"
                        + passenger.getAddress() + "', '"
                        + passenger.getEmail() + "', '"
                        + passenger.getCredit() + "')"
                );
            }
            if (PassengersController.data!=null){
                PassengersController.data.add(passenger);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            closeConnection();
        }

    }

    public void addEmployee(Employee employee) {

        try {
            query = createConnection();
            if (query != null) {
                query.executeUpdate("INSERT INTO employees VALUES ('"
                        + employee.getName() + "', '"
                        + employee.getFamily() + "', '"
                        + employee.getUsername()  + "', '"
                        + employee.getPassword() + "', '"
                        + employee.getId() + "', '"
                        + employee.getPhone() + "', '"
                        + employee.getAddress() + "', '"
                        + employee.getEmail() + "', '"
                        + employee.getIncome() + "', "
                        + "'employee'" + ")"
                );
            }

            EmployeesController.data.add(employee);

        } catch (SQLException e) {
            e.printStackTrace();

            if (e.getMessage().toLowerCase().contains("duplicate") && e.getMessage().toUpperCase().contains("PRIMARY")){

            }

        } finally {
            closeConnection();
        }

    }

    public ObservableList<Passenger> getPassengers() {

        ObservableList<Passenger> data = FXCollections.observableArrayList();

        try {

            query = createConnection();
            if (query != null) {
                resultSet = query.executeQuery("SELECT * FROM passengers");
            }

            while (resultSet.next()) {

                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String family = resultSet.getString("family");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String credit = resultSet.getString("credit");

                Passenger passenger = new Passenger(id, name, family, username, password, phone, address, email, credit);
                data.add(passenger);

            }

            return data;

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            closeConnection();
        }

        return null;
    }

    public ObservableList<Employee> getEmployees() {

        ObservableList<Employee> data = FXCollections.observableArrayList();

        try {

            query = createConnection();
            if (query != null) {
                resultSet = query.executeQuery("SELECT * FROM employees WHERE job = 'employee'");
            }

            while (resultSet.next()) {

                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String family = resultSet.getString("family");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String income = resultSet.getString("income");

                Employee employee = new Employee(id, name, family, username, password, phone, address, email, income);
                data.add(employee);

            }

            return data;

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            closeConnection();
        }

        return null;
    }

    public ObservableList<Airplane> getAirplanes() {

        ObservableList<Airplane> data = FXCollections.observableArrayList();

        try {
            query = createConnection();
            if (query != null) {
                resultSet = query.executeQuery("SELECT * FROM airplanes");
            }

            while (resultSet.next()) {

                String airplaneId = resultSet.getString("airplaneId");
                String seats = resultSet.getString("seats");

                Airplane airplane = new Airplane(airplaneId, seats);
                data.add(airplane);

            }

            return data;

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            closeConnection();
        }

        return null;
    }

    public void replaceEmployee(Employee employee1, Employee employee2) {

        query = createConnection();

        try {
            if (query != null) {
                query.executeUpdate("UPDATE employees SET " +
                        "name = '" + employee1.getName() + "', " +
                        " family = '" + employee1.getFamily() + "', " +
                        "username = '" + employee1.getUsername() + "', " +
                        "password = '" + employee1.getPassword() + "', " +
                        "id = '" + employee1.getId() + "', " +
                        "phone = '" + employee1.getPhone() + "', " +
                        "address = '" + employee1.getAddress() + "', " +
                        "email = '" + employee1.getEmail() + "', " +
                        "income = '" + employee1.getIncome() + "'" +
                        "WHERE id = '" + employee2.getId() + "'");
            }

            int index = EmployeesController.data.indexOf(employee2);
            EmployeesController.data.remove(index);
            EmployeesController.data.add(index, employee1);

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            closeConnection();
        }

    }

    public void replacePassenger(Passenger passenger1, Passenger passenger2) {

        query = createConnection();

        try {
            if (query != null) {
                query.executeUpdate("UPDATE passengers SET " +
                        "name = '" + passenger1.getName() + "', " +
                        " family = '" + passenger1.getFamily() + "', " +
                        "username = '" + passenger1.getUsername() + "', " +
                        "password = '" + passenger1.getPassword() + "', " +
                        "id = '" + passenger1.getId() + "', " +
                        "phone = '" + passenger1.getPhone() + "', " +
                        "address = '" + passenger1.getAddress() + "', " +
                        "email = '" + passenger1.getEmail() + "', " +
                        "credit = '" + passenger1.getCredit() + "'" +
                        "WHERE id = '" + passenger2.getId() + "'");
            }

            int index = PassengersController.data.indexOf(passenger2);
            PassengersController.data.remove(index);
            PassengersController.data.add(index, passenger1);

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            closeConnection();
        }

    }

    public void addAirplane(Airplane airplane) {

        try {
            query = createConnection();
            if (query != null) {
                query.executeUpdate("CREATE TABLE " + airplane.getId() +
                        " (airplaneId varchar(45)," +
                        " seats varchar(45)," +
                        " PRIMARY KEY (airplaneId))");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

    }

    public void removeEmployee(Employee employee) {

        query = createConnection();

        try {
            if (query != null) {
                query.executeUpdate("DELETE FROM employees WHERE id = '" + employee.getId() + "'");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    void closeConnection() {

        try {
            connection.close();
            System.out.println("Disconnect from Database");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

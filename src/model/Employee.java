package model;

public class Employee extends Person implements Showable {

    private String income;

    public Employee(String id, String name, String family, String username, String password,
                    String phone, String address, String email, String income) {
        super(id, name, family, username, password, phone, address, email);
        this.income = income;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    @Override
    public void show() {

    }
}

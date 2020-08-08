package model;

public class Manager extends Person implements Showable {

    public Manager(String id, String name, String family, String username, String password,
                   String phone, String address, String email) {
        super(id, name, family, username, password, phone, address, email);
    }

    @Override
    public void show() {

    }
}

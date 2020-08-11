package model;

public class Passenger extends Person implements Showable {

    private String credit;

    public Passenger(String id, String name, String family, String username, String password,
                     String phone, String address, String email) {
        super(id, name, family, username, password, phone, address, email);
        this.credit = "0";
        show();
    }

    public Passenger(String id, String name, String family, String username, String password,
                     String phone, String address, String email, String credit) {
        super(id, name, family, username, password, phone, address, email);
        this.credit = credit;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @Override
    public void show() {
        System.out.println("new object : ");
        System.out.println(getId() + " - " + getName() + " - " + getFamily() + " - " + getUsername());
        System.out.println(getEmail());
        System.out.println(getAddress());
        System.out.println(getPhone());
    }
}

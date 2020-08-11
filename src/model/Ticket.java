package model;

public class Ticket implements Showable {

    private String id;
    private String price;
    private String penaltyRate;

    public Ticket(String id, String price, String penaltyRate) {
        this.id = id;
        this.price = price;
        this.penaltyRate = penaltyRate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPenaltyRate() {
        return penaltyRate;
    }

    public void setPenaltyRate(String penaltyRate) {
        this.penaltyRate = penaltyRate;
    }

    @Override
    public void show() {

    }

    @Override
    public String toString() {
        return getId();
    }
}

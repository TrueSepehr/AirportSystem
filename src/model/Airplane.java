package model;

import java.util.ArrayList;

public class Airplane implements Showable {

    private String id;
    private String seats;
    private ArrayList<Flight> flights;

    public Airplane(String id, String seats) {
        this.id = id;
        this.seats = seats;
        this.flights = new ArrayList<Flight>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    @Override
    public void show() {

    }

    @Override
    public String toString() {
        return getId();
    }
}

package model;

import javafx.collections.ObservableList;

public class Airplane implements Showable {

    private String id;
    private String seats;
    private ObservableList<Flight> flights;

    public Airplane(String id, String seats) {
        this.id = id;
        this.seats = seats;
    }

    public ObservableList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ObservableList<Flight> flights) {
        this.flights = flights;
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

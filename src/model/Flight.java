package model;

import java.util.ArrayList;

public class Flight implements Showable {

    private String id;
    private Airplane airplane;
    private Ticket ticket;
    private ArrayList<Passenger> passengers;
    private String fromTo;
    private String date;
    private String time;
    private String soldTickets;
    private String duration;
    private enum status {done, undone, flying}

    public Flight(String id, Airplane airplane, Ticket ticket, String fromTo, String date, String time,
                  String soldTickets, String duration) {
        this.id = id;
        this.airplane = airplane;
        this.ticket = ticket;
        this.passengers = new ArrayList<Passenger>();
        this.fromTo = fromTo;
        this.date = date;
        this.time = time;
        this.soldTickets = soldTickets;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromTo() {
        return fromTo;
    }

    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(String soldTickets) {
        this.soldTickets = soldTickets;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public void show() {

    }
}

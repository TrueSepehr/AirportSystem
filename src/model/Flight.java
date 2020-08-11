package model;

import javafx.collections.ObservableList;
import java.sql.Date;
import java.sql.Time;

public class Flight implements Showable {

    private int id;
    private Airplane airplane;
    private Ticket ticket;
    private ObservableList<Passenger> passengers;
    private String fromTo;
    private Date date;
    private Time time;
    private String soldTickets;
    private String duration;
    private enum status {done, undone, flying}

    public Flight(int id, Airplane airplane, Ticket ticket, String fromTo, Date date, Time time, String soldTickets,
                  String duration) {

        this.id = id;
        this.airplane = airplane;
        this.ticket = ticket;
        this.fromTo = fromTo;
        this.date = date;
        this.time = time;
        this.soldTickets = soldTickets;
        this.duration = duration;
    }

    public Flight(int id, Airplane airplane, String fromTo, Date date, Time time, String soldTickets, String duration) {

        this.id = id;
        this.airplane = airplane;
        this.fromTo = fromTo;
        this.date = date;
        this.time = time;
        this.soldTickets = soldTickets;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ObservableList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ObservableList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getFromTo() {
        return fromTo;
    }

    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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

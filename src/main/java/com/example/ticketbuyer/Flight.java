package com.example.ticketbuyer;

public class Flight {
    private String username;

    public Flight(String username, String id, String destination, String date, int people) {
        this.username = username;
        this.id = id;
        this.destination = destination;
        this.date = date;
        this.people = people;
    }

    private String id;
    private String destination;
    private String date;
    private int people;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (people != flight.people) return false;
        if (id != null ? !id.equals(flight.id) : flight.id != null) return false;
        if (destination != null ? !destination.equals(flight.destination) : flight.destination != null) return false;
        return date != null ? date.equals(flight.date) : flight.date == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + people;
        return result;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public int getPeople() {
        return people;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id +
                "," + destination  +
                "," + date  +
                "," + people;
    }

    public Flight(String id, String destination, String date, int people) {
        this.id = id;
        this.destination = destination;
        this.date = date;
        this.people = people;
    }
}

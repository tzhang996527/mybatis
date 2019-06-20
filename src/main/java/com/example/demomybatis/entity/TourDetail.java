package com.example.demomybatis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
@JsonIgnoreProperties(value = {"handler"})
public class TourDetail extends Tour implements Serializable {
    //Tour item
    private List<TourItem> tourItem;
    //Planned Stops
//    private List<PlannedStop> plannedStops;
    private List<PlannedStopDetail> plannedStopsDetail;
    //Actual Stops
    private List<ActualStop> actualStops;
    //Event
    private List<Event> events;
    //Notification
    private List<Notification> notifications;
    //reservation
    private List<Reservation> reservations;
    //tour type
    private TourType tourtype;
    //source location
    private Location sourceLoc;
    private Location destloc;
    //Vehicle
    private Asset vehicle;
    //Customer
    private Customer soldto;
    private Customer shipto;
    //Driver
    private Driver driver;

//    public List<PlannedStop> getPlannedStops() {
//        return plannedStops;
//    }

//    public void setPlannedStops(List<PlannedStop> plannedStops) {
//        this.plannedStops = plannedStops;
//    }

    public List<TourItem> getTourItem() {
        return tourItem;
    }

    public void setTourItem(List<TourItem> tourItem) {
        this.tourItem = tourItem;
    }

    public List<ActualStop> getActualStops() {
        return actualStops;
    }

    public void setActualStops(List<ActualStop> actualStops) {
        this.actualStops = actualStops;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Location getSourceLoc() {
        return sourceLoc;
    }

    public void setSourceLoc(Location sourceLoc) {
        this.sourceLoc = sourceLoc;
    }

    public Location getDestloc() {
        return destloc;
    }

    public void setDestloc(Location destloc) {
        this.destloc = destloc;
    }

    public Asset getVehicle() {
        return vehicle;
    }

    public void setVehicle(Asset vehicle) {
        this.vehicle = vehicle;
    }

    public Customer getSoldto() {
        return soldto;
    }

    public void setSoldto(Customer soldto) {
        this.soldto = soldto;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public TourType getTourtype() {
        return tourtype;
    }

    public void setTourtype(TourType tourtype) {
        this.tourtype = tourtype;
    }

    public Customer getShipto() {
        return shipto;
    }

    public void setShipto(Customer shipto) {
        this.shipto = shipto;
    }

    public List<PlannedStopDetail> getPlannedStopsDetail() {
        return plannedStopsDetail;
    }

    public void setPlannedStopsDetail(List<PlannedStopDetail> plannedStopsDetail) {
        this.plannedStopsDetail = plannedStopsDetail;
    }
}

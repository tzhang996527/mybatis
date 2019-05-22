package com.example.demomybatis.entity;

import java.util.List;

public class TourDetail extends Tour {

    private Customer customer;

    private List<PlannedStops> plannedStops;

    private List<ActualStop> actualStops;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<PlannedStops> getPlannedStops() {
        return plannedStops;
    }

    public void setPlannedStops(List<PlannedStops> plannedStops) {
        this.plannedStops = plannedStops;
    }

    public List<ActualStop> getActualStops() {
        return actualStops;
    }

    public void setActualStops(List<ActualStop> actualStops) {
        this.actualStops = actualStops;
    }
}

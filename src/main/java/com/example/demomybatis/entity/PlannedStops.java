package com.example.demomybatis.entity;

import java.util.Date;

public class PlannedStops {

    private String tourid;
    private int seq;
    private String lat;
    private String lng;
    private String addr;
    private Date plannedDep;

    public String getTourid() {
        return tourid;
    }

    public void setTourid(String tourid) {
        this.tourid = tourid;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Date getPlannedDep() {
        return plannedDep;
    }

    public void setPlannedDep(Date plannedDep) {
        this.plannedDep = plannedDep;
    }
}

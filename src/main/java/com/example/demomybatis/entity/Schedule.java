package com.example.demomybatis.entity;

import java.util.Date;

public class Schedule {
    private String schId;

    private String schType;

    private String sourceLocid;

    private String destLocid;

    private String vehicleId;

    private String driverId;

    private String shipTo;

    private Date startDt;

    private Date endDt;

    private String status;

    private String custId;

    private String mon;
    private String tue;
    private String wed;
    private String thu;
    private String fri;
    private String sat;
    private String sun;

    private Date createdOn;

    private String createdBy;

    private String del;

    public String getSchId() {
        return schId;
    }

    public void setSchId(String schId) {
        this.schId = schId == null ? null : schId.trim();
    }

    public String getSchType() {
        return schType;
    }

    public void setSchType(String schType) {
        this.schType = schType == null ? null : schType.trim();
    }

    public String getSourceLocid() {
        return sourceLocid;
    }

    public void setSourceLocid(String sourceLocid) {
        this.sourceLocid = sourceLocid == null ? null : sourceLocid.trim();
    }

    public String getDestLocid() {
        return destLocid;
    }

    public void setDestLocid(String destLocid) {
        this.destLocid = destLocid == null ? null : destLocid.trim();
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId == null ? null : vehicleId.trim();
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    public String getShipTo() {
        return shipTo;
    }

    public void setShipTo(String shipTo) {
        this.shipTo = shipTo == null ? null : shipTo.trim();
    }

    public Date getStartDt() {
        return startDt;
    }

    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    public Date getEndDt() {
        return endDt;
    }

    public void setEndDt(Date endDt) {
        this.endDt = endDt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del == null ? null : del.trim();
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getTue() {
        return tue;
    }

    public void setTue(String tue) {
        this.tue = tue;
    }

    public String getWed() {
        return wed;
    }

    public void setWed(String wed) {
        this.wed = wed;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getFri() {
        return fri;
    }

    public void setFri(String fri) {
        this.fri = fri;
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }
}
package com.example.demomybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {
    private String resvId;

    private String resvType;

    private String sourceLocid;

    private String destLocid;

    private String vehicleId;

    private String driverId;

    private String shipTo;

    private Date planDepart;

    private Date planArr;

    private Date actDepart;

    private Date actArr;

    private String status;

    private String custId;

    private Date createdOn;

    private String createdBy;

    private String text;

    private String del;

    private String tourId;

    public String getResvId() {
        return resvId;
    }

    public void setResvId(String resvId) {
        this.resvId = resvId == null ? null : resvId.trim();
    }

    public String getResvType() {
        return resvType;
    }

    public void setResvType(String resvType) {
        this.resvType = resvType == null ? null : resvType.trim();
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

    public Date getPlanDepart() {
        return planDepart;
    }

    public void setPlanDepart(Date planDepart) {
        this.planDepart = planDepart;
    }

    public Date getPlanArr() {
        return planArr;
    }

    public void setPlanArr(Date planArr) {
        this.planArr = planArr;
    }

    public Date getActDepart() {
        return actDepart;
    }

    public void setActDepart(Date actDepart) {
        this.actDepart = actDepart;
    }

    public Date getActArr() {
        return actArr;
    }

    public void setActArr(Date actArr) {
        this.actArr = actArr;
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
        this.createdBy = createdBy;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del == null ? null : del.trim();
    }

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }
}
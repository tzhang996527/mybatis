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
}
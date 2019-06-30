package com.example.demomybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class Tour implements Serializable {
    private String tourid;

    private String tourType;

    private String sourceLocid;

    private String destLocid;

    private String vehicleId;

    private String driverId;

    private String shipTo;

    private Date planDepart;

    private Date planArr;

    private Date actDepart;

    private Date actArr;

    private Date eta;

    private String exeStatus;

    private String custId;

    private Date createdOn;

    private String createdBy;

    private String del;

    //source location
    private Location sourceLoc;
    private Location destLoc;

    public String getTourid() {
        return tourid;
    }

    public void setTourid(String tourid) {
        this.tourid = tourid == null ? null : tourid.trim();
    }

    public String getTourType() {
        return tourType;
    }

    public void setTourType(String tourType) {
        this.tourType = tourType == null ? null : tourType.trim();
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

    public Date getEta() {
        return eta;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }

    public String getExeStatus() {
        return exeStatus;
    }

    public void setExeStatus(String exeStatus) {
        this.exeStatus = exeStatus == null ? null : exeStatus.trim();
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

    public Location getSourceLoc() {
        return sourceLoc;
    }

    public void setSourceLoc(Location sourceLoc) {
        this.sourceLoc = sourceLoc;
    }

    public Location getDestLoc() {
        return destLoc;
    }

    public void setDestLoc(Location destLoc) {
        this.destLoc = destLoc;
    }
}
package com.example.demomybatis.entity;

import com.example.demomybatis.validator.VIN;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
public class Asset implements Serializable {


    private static final long serialVersionUID = -8775702135479138695L;
    private String assetId;

    private String assetType;

    @NotEmpty(message = "Please provide plate number")
    private String platenumber;

    private String make;

    private String model;

    @VIN
    @NotEmpty(message = "Please provide a VIN")
    private String vin;

    private int year;

    private String hardware;

    private String location;

    private String createdBy;

    private Date createdOn;

    private String del;

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId == null ? null : assetId.trim();
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType == null ? null : assetType.trim();
    }

    public String getPlatenumber() {
        return platenumber;
    }

    public void setPlatenumber(String platenumber) {
        this.platenumber = platenumber == null ? null : platenumber.trim();
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make == null ? null : make.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware == null ? null : hardware.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del == null ? null : del.trim();
    }
}
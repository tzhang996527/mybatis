package com.example.demomybatis.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TourItem extends TourItemKey implements Serializable {
    private String container;

    private BigDecimal quan;

    private String quanUom;

    private String commodity;

    private String location;

    private String status;

    private String del;

    private String createdBy;

    private Date createdOn;

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container == null ? null : container.trim();
    }

    public BigDecimal getQuan() {
        return quan;
    }

    public void setQuan(BigDecimal quan) {
        this.quan = quan;
    }

    public String getQuanUom() {
        return quanUom;
    }

    public void setQuanUom(String quanUom) {
        this.quanUom = quanUom == null ? null : quanUom.trim();
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity == null ? null : commodity.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del == null ? null : del.trim();
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
}
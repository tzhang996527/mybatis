package com.example.demomybatis.entity;

import java.util.Date;

public class PlannedStop extends PlannedStopKey {
    private String locid;

    private Date planDepart;

    private Date planArr;

    private Date actDepart;

    private Date actArr;

    private Date estDepart;

    private Date estArr;

    private Date eta;

    private String status;

    private String del;

    public String getLocid() {
        return locid;
    }

    public void setLocid(String locid) {
        this.locid = locid == null ? null : locid.trim();
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

    public Date getEstDepart() {
        return estDepart;
    }

    public void setEstDepart(Date estDepart) {
        this.estDepart = estDepart;
    }

    public Date getEstArr() {
        return estArr;
    }

    public void setEstArr(Date estArr) {
        this.estArr = estArr;
    }

    public Date getEta() {
        return eta;
    }

    public void setEta(Date eta) {
        this.eta = eta;
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
}
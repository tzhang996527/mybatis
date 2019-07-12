package com.example.demomybatis.entity;

import java.util.Date;

public class SchStop extends SchStopKey {
    private String locid;

    private Date planDepart;

    private Date planArr;

    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}
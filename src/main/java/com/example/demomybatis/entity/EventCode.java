package com.example.demomybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class EventCode implements Serializable {
    private String eventCode;

    private String eventText;

    private String createdBy;

    private Date createdOn;

    private String del;

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode == null ? null : eventCode.trim();
    }

    public String getEventText() {
        return eventText;
    }

    public void setEventText(String eventText) {
        this.eventText = eventText == null ? null : eventText.trim();
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
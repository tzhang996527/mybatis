package com.example.demomybatis.entity;

import java.util.Date;

public class SchType {
    private String schType;

    private String text;

    private String createdBy;

    private Date createdOn;

    public String getSchType() {
        return schType;
    }

    public void setSchType(String schType) {
        this.schType = schType == null ? null : schType.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
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
package com.example.demomybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class ResvType implements Serializable {
    private String resvType;

    private String text;

    private String createdBy;

    private Date createdOn;

    public String getResvType() {
        return resvType;
    }

    public void setResvType(String resvType) {
        this.resvType = resvType == null ? null : resvType.trim();
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
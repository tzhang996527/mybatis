package com.example.demomybatis.entity;

import java.io.Serializable;

public class CustomerKey implements Serializable {
    private String custId;

    private String type;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}
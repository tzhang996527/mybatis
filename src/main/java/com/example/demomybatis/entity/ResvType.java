package com.example.demomybatis.entity;

import java.io.Serializable;

public class ResvType implements Serializable {
    private String resvType;

    private String text;

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
}
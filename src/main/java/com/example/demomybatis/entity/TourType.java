package com.example.demomybatis.entity;

import java.io.Serializable;

public class TourType implements Serializable {
    private String tourType;

    private String text;

    public String getTourType() {
        return tourType;
    }

    public void setTourType(String tourType) {
        this.tourType = tourType == null ? null : tourType.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }
}
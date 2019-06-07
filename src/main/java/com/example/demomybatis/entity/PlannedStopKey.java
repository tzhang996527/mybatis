package com.example.demomybatis.entity;

import java.io.Serializable;

public class PlannedStopKey implements Serializable {
    private String tourid;

    private Integer seq;

    public String getTourid() {
        return tourid;
    }

    public void setTourid(String tourid) {
        this.tourid = tourid == null ? null : tourid.trim();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
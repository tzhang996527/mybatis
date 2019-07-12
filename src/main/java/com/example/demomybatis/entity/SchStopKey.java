package com.example.demomybatis.entity;

public class SchStopKey {
    private String schId;

    private Integer seq;

    public String getSchId() {
        return schId;
    }

    public void setSchId(String schId) {
        this.schId = schId == null ? null : schId.trim();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
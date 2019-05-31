package com.example.demomybatis.entity;

public class ResvItemKey {
    private String resvId;

    private Integer seq;

    public String getResvId() {
        return resvId;
    }

    public void setResvId(String resvId) {
        this.resvId = resvId == null ? null : resvId.trim();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
package com.example.demomybatis.entity;

import java.util.Date;

public class AssetStatus {
    private String assetId;

    private String status;

    private String changedBy;

    private Date changedOn;

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId == null ? null : assetId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy == null ? null : changedBy.trim();
    }

    public Date getChangedOn() {
        return changedOn;
    }

    public void setChangedOn(Date changedOn) {
        this.changedOn = changedOn;
    }
}
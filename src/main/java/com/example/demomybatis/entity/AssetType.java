package com.example.demomybatis.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class AssetType implements Serializable {
    private String assetType;

    @NotEmpty
    private String assetText;

    private String createdBy;

    private Date createdOn;

    private String del;

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType == null ? null : assetType.trim();
    }

    public String getAssetText() {
        return assetText;
    }

    public void setAssetText(String assetText) {
        this.assetText = assetText == null ? null : assetText.trim();
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
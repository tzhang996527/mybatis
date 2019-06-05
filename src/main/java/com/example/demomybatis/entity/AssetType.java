package com.example.demomybatis.entity;

import org.apache.ibatis.annotations.Mapper;

public class AssetType {
    private String assetType;

    private String assetText;

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

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del == null ? null : del.trim();
    }
}
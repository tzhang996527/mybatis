package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Asset;

public interface AssetMapper {
    int deleteByPrimaryKey(String assetId);

    int insert(Asset record);

    int insertSelective(Asset record);

    Asset selectByPrimaryKey(String assetId);

    int updateByPrimaryKeySelective(Asset record);

    int updateByPrimaryKey(Asset record);
}
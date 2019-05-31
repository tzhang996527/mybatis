package com.example.demomybatis.dao;

import com.example.demomybatis.entity.AssetType;

public interface AssetTypeMapper {
    int deleteByPrimaryKey(String assetType);

    int insert(AssetType record);

    int insertSelective(AssetType record);

    AssetType selectByPrimaryKey(String assetType);

    int updateByPrimaryKeySelective(AssetType record);

    int updateByPrimaryKey(AssetType record);
}
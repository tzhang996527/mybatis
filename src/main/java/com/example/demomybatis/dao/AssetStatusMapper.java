package com.example.demomybatis.dao;

import com.example.demomybatis.entity.AssetStatus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AssetStatusMapper {
    int deleteByPrimaryKey(String assetId);

    int insert(AssetStatus record);

    int insertSelective(AssetStatus record);

    AssetStatus selectByPrimaryKey(String assetId);

    int updateByPrimaryKeySelective(AssetStatus record);

    int updateByPrimaryKey(AssetStatus record);
}
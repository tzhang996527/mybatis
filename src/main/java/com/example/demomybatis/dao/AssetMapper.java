package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Asset;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AssetMapper {
    int deleteByPrimaryKey(String assetId);

    int insert(Asset record);

    int insertSelective(Asset record);

    Asset selectByPrimaryKey(String assetId);

    int updateByPrimaryKeySelective(Asset record);

    int updateByPrimaryKey(Asset record);
}
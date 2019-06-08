package com.example.demomybatis.dao;

import com.example.demomybatis.entity.AssetType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssetTypeMapper {
    int deleteByPrimaryKey(String assetType);

    int insert(AssetType record);

    int insertSelective(AssetType record);

    AssetType selectByPrimaryKey(String assetType);

    int updateByPrimaryKeySelective(AssetType record);

    int updateByPrimaryKey(AssetType record);

    List<AssetType> selectAll();

    List<AssetType> selectByField(String assetType, String assetText);
}
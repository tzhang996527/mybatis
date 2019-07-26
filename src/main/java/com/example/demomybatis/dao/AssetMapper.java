package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Asset;
import com.example.demomybatis.entity.AssetDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssetMapper {
    int deleteByPrimaryKey(String assetId);

    int insert(Asset record);

    int insertSelective(Asset record);

    Asset selectByPrimaryKey(String assetId);

    int updateByPrimaryKeySelective(Asset record);

    int updateByPrimaryKey(Asset record);

    List<Asset> selectAll();

    List<Asset> selectByField(Asset asset);

    List<AssetDetail> selectAssetDetail(AssetDetail assetDetail);
}
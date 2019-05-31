package com.example.demomybatis.dao;

import com.example.demomybatis.entity.TourType;

public interface TourTypeMapper {
    int deleteByPrimaryKey(String tourType);

    int insert(TourType record);

    int insertSelective(TourType record);

    TourType selectByPrimaryKey(String tourType);

    int updateByPrimaryKeySelective(TourType record);

    int updateByPrimaryKey(TourType record);
}
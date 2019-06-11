package com.example.demomybatis.dao;

import com.example.demomybatis.entity.TourItem;
import com.example.demomybatis.entity.TourItemKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TourItemMapper {
    int deleteByPrimaryKey(TourItemKey key);

    int insert(TourItem record);

    int insertSelective(TourItem record);

    TourItem selectByPrimaryKey(TourItemKey key);

    int updateByPrimaryKeySelective(TourItem record);

    int updateByPrimaryKey(TourItem record);
}
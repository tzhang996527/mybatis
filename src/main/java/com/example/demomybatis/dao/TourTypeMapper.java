package com.example.demomybatis.dao;

import com.example.demomybatis.entity.TourType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TourTypeMapper {
    int deleteByPrimaryKey(String tourType);

    int insert(TourType record);

    int insertSelective(TourType record);

    List<TourType> selectByPrimaryKey(TourType tourType);

    int updateByPrimaryKeySelective(TourType record);

    int updateByPrimaryKey(TourType record);
}
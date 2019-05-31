package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Tour;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TourMapper {

    List<Tour> selectAllTour();

    int deleteByPrimaryKey(String tourid);

    int insert(Tour record);

    int insertSelective(Tour record);

    Tour selectByPrimaryKey(String tourid);

    int updateByPrimaryKeySelective(Tour record);

    int updateByPrimaryKey(Tour record);
}
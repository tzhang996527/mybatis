package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Tour;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TourMapper {

    int deleteByPrimaryKey(String tourid);

    int insert(Tour record);

    int insertSelective(Tour record);

    List<Tour> selectByPrimaryKey(Tour tour);

    int updateByPrimaryKeySelective(Tour record);

    int updateByPrimaryKey(Tour record);

    long getNextTourId();
    long getNextResvId();
}
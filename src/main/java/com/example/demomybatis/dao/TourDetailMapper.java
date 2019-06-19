package com.example.demomybatis.dao;

import com.example.demomybatis.entity.TourDetail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TourDetailMapper {
    List<TourDetail> getTourDetail(String tourid);

    List<TourDetail> findTourTest();
}

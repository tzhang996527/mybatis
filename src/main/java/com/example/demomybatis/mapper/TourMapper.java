package com.example.demomybatis.mapper;

import com.example.demomybatis.entity.Tour;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TourMapper {
    List<Tour> selectTour();
}

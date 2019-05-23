package com.example.demomybatis.dao;

import com.example.demomybatis.entity.ActualStop;
import com.example.demomybatis.entity.PlannedStops;
import com.example.demomybatis.entity.Tour;
import com.example.demomybatis.entity.TourDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TourMapper {

    List<Tour> selectTour();

    List<PlannedStops> selectPlannedStops();

    List<ActualStop> selectActStops();

    Tour findTourById(String tourId);

    void updateTourStatus(Tour tour);

    void deleteTour(String tourid);

    void createTour(Tour tour);

    List<TourDetail> getTourDetails();
}

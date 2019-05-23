package com.example.demomybatis.service.Impl;

import com.example.demomybatis.entity.Tour;
import com.example.demomybatis.dao.TourMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tourService")
public class TourServiceImpl implements TourService {

    private TourMapper tourMapper;

    @Autowired
    public TourServiceImpl(TourMapper tourMapper) {
        this.tourMapper = tourMapper;
    }

    @Override
    public List<Tour> getAllTours() {
        return tourMapper.selectTour();
    }
}


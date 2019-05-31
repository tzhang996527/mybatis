package com.example.demomybatis.service;

import com.example.demomybatis.dao.TourMapper;
import com.example.demomybatis.entity.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("tourService2")
public class TourServiceImpl2 implements TourService {

    private TourMapper tourMapper;

    @Autowired
    public TourServiceImpl2(TourMapper tourMapper) {
        this.tourMapper = tourMapper;
    }

    @Override
    public List<Tour> getAllTours() {

        List<Tour> tlist = new ArrayList<>();

        Tour test1 = new Tour();
//        test1.setTourid("12321321");
//        test1.setStatus("1");
//        tlist.add(test1);

        return tlist;
    }
}


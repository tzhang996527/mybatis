package com.example.demomybatis.controller;

import com.example.demomybatis.entity.Tour;
import com.example.demomybatis.service.Impl.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v2/")
public class TestController2 {

    private TourService tourService;

    @Autowired
    public TestController2(@Qualifier("tourService2") TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping(path = "getTour2")
    public List<Tour> getAllTours(){
        return this.tourService.getAllTours();
    }
}
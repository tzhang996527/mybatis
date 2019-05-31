package com.example.demomybatis.controller;

import com.example.demomybatis.entity.Tour;
import com.example.demomybatis.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v2/")
public class TestController {

    private TourService tourService;

    @Autowired
    public TestController(@Qualifier("tourService") TourService tourService) {
        this.tourService = tourService;
    }

//    @GetMapping(path = "getTour")
//    public List<Tour> getAllTours(){
//        return this.tourService.getAllTours();
//    }
}

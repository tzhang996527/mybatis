package com.example.demomybatis.controller;

import com.example.demomybatis.entity.Tour;
import com.example.demomybatis.entity.TourDetail;
import com.example.demomybatis.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/")
public class TestController {

    @Autowired
    private TourService tourService;

    @GetMapping(path = "tours")
    public List<Tour> getAllTours(){
        return this.tourService.getTour();
    }

    @PostMapping(path = "tour")
    public String create(@RequestBody TourDetail tourDetail){
        return this.tourService.saveTour(tourDetail);
    }
//    private TourService tourService;
//
//    @Autowired
//    public TestController(@Qualifier("tourService") TourService tourService) {
//        this.tourService = tourService;
//    }

//    @GetMapping(path = "getTour")
//    public List<Tour> getAllTours(){
//        return this.tourService.getAllTours();
//    }


}

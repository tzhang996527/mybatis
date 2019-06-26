package com.example.demomybatis.controller;

import com.example.demomybatis.dao.*;
import com.example.demomybatis.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("api/v1/")
public class TourController {

    private final AssetTypeMapper assetTypeMapper;

    private final TourMapper tourMapper;

    private final TourDetailMapper tourDetailMapper;

    private final TourItemMapper tourItemMapper;

    private final ActualStopMapper actualStopMapper;

    @Autowired
    public TourController(AssetTypeMapper assetTypeMapper, TourMapper tourMapper, TourDetailMapper tourDetailMapper, TourItemMapper tourItemMapper, ActualStopMapper actualStopMapper){
        this.assetTypeMapper = assetTypeMapper;
        this.tourMapper = tourMapper;
        this.tourDetailMapper = tourDetailMapper;
        this.tourItemMapper = tourItemMapper;
        this.actualStopMapper = actualStopMapper;
    }

    @GetMapping(path="tour")
    public List<Tour> getTour(){
        return this.tourMapper.selectAllTour();
    }

    @GetMapping(path="tourDetail")
    public TourDetail getTourDetail(@Param("tourid") String tourid){
        TourDetail tourDetail = this.tourDetailMapper.getTourDetail(tourid);
        //get actual stops
        tourDetail.setActualStops(this.actualStopMapper.selectByTourId(tourid));

        return tourDetail;
    }

    @GetMapping(path="actStop")
    public List<ActualStop> getActualStops(@Param("tourid") String tourid){
        return this.actualStopMapper.selectByTourId(tourid);
    }

    @PostMapping(path="actualStop")
    public ActualStop reportPos(@RequestBody ActualStop actualStop){
        //get max seq of current tour
        int seq = this.actualStopMapper.selectMaxSeq(actualStop.getTourid()) + 1;

        actualStop.setSeq(seq);
        actualStop.setRepTime(new Date());
        //insert current postion
        this.actualStopMapper.insertSelective(actualStop);
        return actualStop;
    }
//    @GetMapping(path="plannedStops")
//    public  List<PlannedStop> getPlannedStops(){
//        return this.tourMapper.selectPlannedStops();
//    }
//
//    @GetMapping(path="actStops")
//    public  List<ActualStop> getActStops(){
//        return this.tourMapper.selectActStops();
//    }
//
//    @GetMapping(path = "tour/{id}")
//    public Tour getTourById(@PathVariable(name="id") String tourid){
//        return this.tourMapper.findTourById(tourid);
//    }
//
//    //tour/2?status=2
//    @PutMapping(path = "tour/{id}")
//    public String updateTourStatus(@PathVariable(name="id") String tourid,@RequestParam(name="status") String status){
//
//        Tour tourUpd = new Tour();
//
//        tourUpd.setTourid(tourid);
//        tourUpd.setStatus("2");
//        this.tourMapper.updateTourStatus(tourUpd);
//
//        return "Update successfully";
//    }
//
//    @DeleteMapping(path="tour/{id}")
//    public String deleteTour(@PathVariable(name="id") String tourid){
//
//        this.tourMapper.deleteTour(tourid);
//
//        return String.format("Tour %s is deleted.",tourid);
//    }
//
//    @PostMapping(path="tour")
//    public String createTour(@RequestBody Tour tour){
//        this.tourMapper.createTour(tour);
//
//        return String.format("Tour %s created.",tour.getTourid());
//    }
//
//    @GetMapping(path="tourDetails")
//    public List<TourDetail> getTourDetails(){
//        return this.tourMapper.getTourDetails();
//    }
}

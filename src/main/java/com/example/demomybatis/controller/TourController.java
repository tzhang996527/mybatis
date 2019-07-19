package com.example.demomybatis.controller;

import com.example.demomybatis.dao.*;
import com.example.demomybatis.entity.*;
import com.example.demomybatis.service.TourService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("api/v1/")
public class TourController {

    @Autowired
    private TourService tourService;

    private final TourMapper tourMapper;

    private final TourDetailMapper tourDetailMapper;

    private final ActualStopMapper actualStopMapper;

    private final PlannedStopMapper plannedStopMapper;

    @Autowired
    public TourController(TourMapper tourMapper, TourDetailMapper tourDetailMapper, ActualStopMapper actualStopMapper, PlannedStopMapper plannedStopMapper){
        this.tourMapper = tourMapper;
        this.tourDetailMapper = tourDetailMapper;
        this.actualStopMapper = actualStopMapper;
        this.plannedStopMapper = plannedStopMapper;
    }

    @GetMapping(path="tour")
    public List<Tour> getTour(@Param("Tour") Tour tour){
        List<Tour> t = this.tourMapper.selectByPrimaryKey(tour);
        return this.tourMapper.selectByPrimaryKey(tour);
    }

    @PostMapping(path = "tour")
    public String create(@RequestBody TourDetail tourDetail){
        //Creat tour
        return this.tourService.saveTour(tourDetail);
    }

    @PutMapping(path = "tour")
    public List<Tour> update(@RequestBody Tour tour){
        this.tourMapper.updateByPrimaryKeySelective(tour);
        return this.tourMapper.selectByPrimaryKey(null);
    }
    @DeleteMapping(path="tour/{id}")
    public List<Tour> delete(@PathVariable(name="id") String id){
        this.tourMapper.deleteByPrimaryKey(id);
        return this.tourMapper.selectByPrimaryKey(null);
    }
    //tour detail
    @GetMapping(path="tourDetail")
    public TourDetail getTourDetail(@Param("tourid") String tourid){
        TourDetail tourDetail = this.tourDetailMapper.getTourDetail(tourid);
        //get actual stops
        tourDetail.setActualStops(this.actualStopMapper.selectByTourId(tourid));

        if(tourDetail.getVehicle() == null){
            tourDetail.setVehicle(new Asset());
        }

        if(tourDetail.getSoldto() == null){
            tourDetail.setSoldto(new Customer());
        }

        if(tourDetail.getShipto() == null){
            tourDetail.setShipto(new Customer());
        }

        if(tourDetail.getDriver() == null){
            tourDetail.setDriver(new Driver());
        }
        return tourDetail;
    }

    //Actual stop
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

    @GetMapping(path="nextTourId")
    public String getNextTourId(){
        long nextId = this.tourMapper.getNextTourId();
        return Long.toString(nextId);
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

package com.example.demomybatis.controller;

import com.example.demomybatis.dao.CityDao;
import com.example.demomybatis.entity.*;
import com.example.demomybatis.mapper.HotelMapper;
import com.example.demomybatis.mapper.TourMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/")
public class CityController {

    private final CityDao cityDao;

    private final HotelMapper hotelMapper;

    private final TourMapper tourMapper;

    @Autowired
    public CityController(CityDao cityDao, HotelMapper hotelMapper, TourMapper tourMapper){
        this.cityDao = cityDao;
        this.hotelMapper = hotelMapper;
        this.tourMapper = tourMapper;
    }

    @GetMapping(path="city")
    public List<City> getAllCities(){
        return this.cityDao.getAllCities();
    }

    @GetMapping(path="hotel")
    public Hotel selectHotelById(@RequestParam(name="id") int id){
        return this.hotelMapper.selectByCityId(id);
    }

    @GetMapping(path="tour")
    public List<Tour> getTour(){
        return this.tourMapper.selectTour();
    }


    @GetMapping(path="plannedStops")
    public  List<PlannedStops> getPlannedStops(){
        return this.tourMapper.selectPlannedStops();
    }

    @GetMapping(path="actStops")
    public  List<ActualStop> getActStops(){
        return this.tourMapper.selectActStops();
    }

    @GetMapping(path = "tour/{id}")
    public Tour getTourById(@PathVariable(name="id") String tourid){
        return this.tourMapper.findTourById(tourid);
    }

    //tour/2?status=2
    @PutMapping(path = "tour/{id}")
    public String updateTourStatus(@PathVariable(name="id") String tourid,@RequestParam(name="status") String status){

        Tour tourUpd = new Tour();

        tourUpd.setTourid(tourid);
        tourUpd.setStatus("2");
        this.tourMapper.updateTourStatus(tourUpd);

        return "Update successfully";
    }

    @DeleteMapping(path="tour/{id}")
    public String deleteTour(@PathVariable(name="id") String tourid){

        this.tourMapper.deleteTour(tourid);

        return String.format("Tour %s is deleted.",tourid);
    }

    @PostMapping(path="tour")
    public String createTour(@RequestBody Tour tour){
        this.tourMapper.createTour(tour);

        return String.format("Tour %s created.",tour.getTourid());
    }
}

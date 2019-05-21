package com.example.demomybatis.controller;

import com.example.demomybatis.dao.CityDao;
import com.example.demomybatis.entity.City;
import com.example.demomybatis.entity.Hotel;
import com.example.demomybatis.entity.Tour;
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
}

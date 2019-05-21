package com.example.demomybatis.controller;

import com.example.demomybatis.dao.CityDao;
import com.example.demomybatis.entity.City;
import com.example.demomybatis.entity.Hotel;
import com.example.demomybatis.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/")
public class CityController {

    private final CityDao cityDao;

    private final HotelMapper hotelMapper;

    @Autowired
    public CityController(CityDao cityDao, HotelMapper hotelMapper){
        this.cityDao = cityDao;
        this.hotelMapper = hotelMapper;
    }

    @GetMapping(path="city")
    public List<City> getAllCities(){
        return this.cityDao.getAllCities();
    }

    @GetMapping(path="hotel")
    public Hotel selectHotelById(@RequestParam(name="id") int id){
        return this.hotelMapper.selectByCityId(id);
    }
}

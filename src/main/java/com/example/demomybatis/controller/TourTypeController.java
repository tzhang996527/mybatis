package com.example.demomybatis.controller;

import com.example.demomybatis.dao.ResvTypeMapper;
import com.example.demomybatis.dao.TourTypeMapper;
import com.example.demomybatis.entity.ResvType;
import com.example.demomybatis.entity.TourType;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class TourTypeController {

    private final TourTypeMapper tourTypeMapper;

    @Autowired
    public TourTypeController(TourTypeMapper tourTypeMapper) {
        this.tourTypeMapper = tourTypeMapper;
    }

    @GetMapping(path = "tourType")
    public List<TourType> selectByPrimaryKey(@Param("tourType") TourType tourType){
        return this.tourTypeMapper.selectByPrimaryKey(tourType);
    }

    @PostMapping(path = "tourType")
    public List<TourType> create(@RequestBody TourType tourType){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        tourType.setCreatedBy(username);
        tourType.setCreatedOn(new Date());
        this.tourTypeMapper.insert(tourType);
        //return all customer
        return this.tourTypeMapper.selectByPrimaryKey(null);
    }

    @PutMapping(path = "tourType")
    public List<TourType> update(@RequestBody TourType tourType){
        this.tourTypeMapper.updateByPrimaryKeySelective(tourType);
        return this.tourTypeMapper.selectByPrimaryKey(null);
    }
    @DeleteMapping(path="tourType/{id}")
    public List<TourType> delete(@PathVariable(name="id") String id){
        this.tourTypeMapper.deleteByPrimaryKey(id);
        return this.tourTypeMapper.selectByPrimaryKey(null);
    }
}

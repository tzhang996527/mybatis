package com.example.demomybatis.controller;

import com.example.demomybatis.dao.TourItemMapper;
import com.example.demomybatis.entity.TourItem;
import com.example.demomybatis.entity.TourItemKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class TourItemController {

    private final TourItemMapper tourItemMapper;

    @Autowired
    public TourItemController(TourItemMapper tourItemMapper) {
        this.tourItemMapper = tourItemMapper;
    }

    @GetMapping(path = "tourItem")
    public List<TourItem> selectByPrimaryKey(@Param("tourItem") TourItem tourItem){
        return this.tourItemMapper.selectByPrimaryKey(tourItem);
    }

    @PostMapping(path = "tourItem")
    public List<TourItem> create(@RequestBody TourItem tourItem){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        tourItem.setCreatedBy(username);
        tourItem.setCreatedOn(new Date());
        this.tourItemMapper.insert(tourItem);
        //return all customer
        return this.tourItemMapper.selectByPrimaryKey(null);
    }

    @PutMapping(path = "tourItem")
    public List<TourItem> update(@RequestBody TourItem tourItem){
        this.tourItemMapper.updateByPrimaryKeySelective(tourItem);
        return this.tourItemMapper.selectByPrimaryKey(null);
    }
    @DeleteMapping(path="tourItem")
    public List<TourItem> delete(@Param("tourItemKey") TourItemKey tourItemKey){
        this.tourItemMapper.deleteByPrimaryKey(tourItemKey);
        return this.tourItemMapper.selectByPrimaryKey(null);
    }
}

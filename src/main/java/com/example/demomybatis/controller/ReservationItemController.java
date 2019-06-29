package com.example.demomybatis.controller;

import com.example.demomybatis.dao.ReservationMapper;
import com.example.demomybatis.dao.ResvItemMapper;
import com.example.demomybatis.entity.Reservation;
import com.example.demomybatis.entity.ResvItem;
import com.example.demomybatis.entity.ResvItemKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ReservationItemController {

    private final ResvItemMapper resvItemMapper;

    @Autowired
    public ReservationItemController(ResvItemMapper resvItemMapper) {
        this.resvItemMapper = resvItemMapper;
    }

    @GetMapping(path = "resvItem")
    public List<ResvItem> selectByPrimaryKey(@Param("reseItem") ResvItemKey resvItem){
        return this.resvItemMapper.selectByPrimaryKey(resvItem);
    }

    @PostMapping(path = "resvItem")
    public List<ResvItem> create(@RequestBody ResvItem resvItem){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        resvItem.setCreatedBy(username);
        resvItem.setCreatedOn(new Date());
        this.resvItemMapper.insert(resvItem);
        //return all customer
        return this.resvItemMapper.selectByPrimaryKey(null);
    }

    @PutMapping(path = "resvItem")
    public List<ResvItem> update(@RequestBody ResvItem resvItem){
        this.resvItemMapper.updateByPrimaryKeySelective(resvItem);
        return this.resvItemMapper.selectByPrimaryKey(null);
    }
    @DeleteMapping(path="resvItem")
    public List<ResvItem> delete(@Param("resvItem") ResvItemKey resvItemKey){
        this.resvItemMapper.deleteByPrimaryKey(resvItemKey);
        return this.resvItemMapper.selectByPrimaryKey(null);
    }
}

package com.example.demomybatis.controller;

import com.example.demomybatis.dao.NotificationMapper;
import com.example.demomybatis.dao.PlannedStopMapper;
import com.example.demomybatis.entity.Notification;
import com.example.demomybatis.entity.PlannedStop;
import com.example.demomybatis.entity.PlannedStopKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class PlannedStopController {

    private final PlannedStopMapper plannedStopMapper;

    @Autowired
    public PlannedStopController(PlannedStopMapper plannedStopMapper) {
        this.plannedStopMapper = plannedStopMapper;
    }

    @GetMapping(path = "plannedStop")
    public List<PlannedStop> selectByPrimaryKey(@Param("plannedStop") PlannedStopKey plannedStopKey){
        return this.plannedStopMapper.selectByPrimaryKey(plannedStopKey);
    }

    @PostMapping(path = "plannedStop")
    public List<PlannedStop> create(@RequestBody PlannedStop plannedStop){
        this.plannedStopMapper.insert(plannedStop);
        //return all customer
        return this.plannedStopMapper.selectByPrimaryKey(null);
    }

    @PutMapping(path = "plannedStop")
    public List<PlannedStop> update(@RequestBody PlannedStop plannedStop){
        this.plannedStopMapper.updateByPrimaryKeySelective(plannedStop);
        return this.plannedStopMapper.selectByPrimaryKey(null);
    }
    @DeleteMapping(path="plannedStop")
    public List<PlannedStop> delete(@Param("plannedStop") PlannedStopKey plannedStopKey){
        this.plannedStopMapper.deleteByPrimaryKey(plannedStopKey);
        return this.plannedStopMapper.selectByPrimaryKey(null);
    }
}

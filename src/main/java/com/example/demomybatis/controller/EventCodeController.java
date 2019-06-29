package com.example.demomybatis.controller;

import com.example.demomybatis.dao.DriverMapper;
import com.example.demomybatis.dao.EventCodeMapper;
import com.example.demomybatis.entity.EventCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class EventCodeController {

    private final EventCodeMapper eventCodeMapper;

    @Autowired
    public EventCodeController(EventCodeMapper eventCodeMapper) {
        this.eventCodeMapper = eventCodeMapper;
    }

    @GetMapping(path = "eventCode")
    public List<EventCode> selectByPrimaryKey(@Param("EventCode") EventCode eventCode){
        return this.eventCodeMapper.selectByPrimaryKey(eventCode);
    }

    @PostMapping(path = "eventCode")
    public List<EventCode> create(@RequestBody EventCode eventCode){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        eventCode.setCreatedBy(username);
        eventCode.setCreatedOn(new Date());
        this.eventCodeMapper.insert(eventCode);
        //return all customer
        return this.eventCodeMapper.selectByPrimaryKey(null);
    }

    @PutMapping(path = "eventCode")
    public List<EventCode> update(@RequestBody EventCode eventCode){
        this.eventCodeMapper.updateByPrimaryKeySelective(eventCode);
        return this.eventCodeMapper.selectByPrimaryKey(null);
    }
    @DeleteMapping(path="eventCode/{id}")
    public List<EventCode> delete(@PathVariable(name="id") String id){
        this.eventCodeMapper.deleteByPrimaryKey(id);
        return this.eventCodeMapper.selectByPrimaryKey(null);
    }
}

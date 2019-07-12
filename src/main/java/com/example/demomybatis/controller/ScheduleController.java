package com.example.demomybatis.controller;

import com.example.demomybatis.dao.SchTypeMapper;
import com.example.demomybatis.entity.SchType;
import com.example.demomybatis.entity.Schedule;
import com.example.demomybatis.entity.ScheduleDetail;
import com.example.demomybatis.service.ScheduleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    
    @GetMapping(path = "sch")
    public List<ScheduleDetail> selectByPrimaryKey(@Param("sch") SchType sch){
        return this.scheduleService.selectByPrimaryKey(sch);
    }

    @PostMapping(path = "sch")
    public List<SchType> create(@RequestBody SchType sch){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        sch.setCreatedBy(username);
        sch.setCreatedOn(new Date());
        this.schMapper.insert(sch);
        //return all type
        return this.schMapper.selectByPrimaryKey(null);
    }

    @PutMapping(path = "sch")
    public List<SchType> update(@RequestBody SchType sch){
        this.schMapper.updateByPrimaryKeySelective(sch);
        return this.schMapper.selectByPrimaryKey(null);
    }
    @DeleteMapping(path="sch/{id}")
    public List<SchType> delete(@PathVariable(name="id") String id){
        this.schMapper.deleteByPrimaryKey(id);
        return this.schMapper.selectByPrimaryKey(null);
    }
}

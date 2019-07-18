package com.example.demomybatis.controller;

import com.example.demomybatis.entity.Schedule;
import com.example.demomybatis.entity.ScheduleDetail;
import com.example.demomybatis.service.ScheduleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping(path = "sch")
    public List<Schedule> selectByPrimaryKey(@Param("sch") Schedule sch){
        return this.scheduleService.selectByPrimaryKey(sch);
    }

    @PostMapping(path = "sch")
    public String create(@RequestBody ScheduleDetail schedule){
        return this.scheduleService.create(schedule);
    }

    @PutMapping(path = "sch")
    public List<Schedule> update(@RequestBody Schedule sch){
        this.scheduleService.update(sch);
        return this.scheduleService.selectByPrimaryKey(null);
    }
    @DeleteMapping(path="sch/{id}")
    public List<Schedule> delete(@PathVariable(name="id") String id){
        this.scheduleService.delete(id);
        return this.scheduleService.selectByPrimaryKey(null);
    }

    @PostMapping(path ="schGenTour")
    public List<String> generateTour(@RequestBody Schedule sch) throws ParseException {
        return this.scheduleService.createTourViaSch(sch.getSchId());
    }
}

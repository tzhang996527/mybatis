package com.example.demomybatis.service;

import com.example.demomybatis.dao.SchStopMapper;
import com.example.demomybatis.dao.ScheduleMapper;
import com.example.demomybatis.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Service("scheduleService")
public class ScheduleService {
    
    @Autowired
    private ScheduleMapper scheduleMapper;
    
    @Autowired
    private SchStopMapper schStopMapper;

    public List<Schedule> selectByPrimaryKey(@Param("sch") Schedule sch){
        return this.scheduleMapper.selectByPrimaryKey(sch);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public String create(Schedule schedule){
//  public String create(ScheduleDetail scheduleDetail){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String nextId = Long.toString(this.scheduleMapper.getNextSchId());
//        Schedule sch = new Schedule();
        schedule.setSchId(nextId);
//        sch.setCustId(scheduleDetail.getCustId());
//        sch.setSchType(scheduleDetail.getSchType());
//        sch.setShipTo(scheduleDetail.getShipTo());
//        sch.setCustId(scheduleDetail.getCustId());
//        sch.setStartDt(scheduleDetail.getStartDt());
//        sch.setEndDt(scheduleDetail.getEndDt());
//        sch.setSourceLocid(scheduleDetail.getSourceLocid());
//        sch.setDestLocid(scheduleDetail.getDestLocid());
//        sch.setVehicleId(scheduleDetail.getVehicleId());
//        sch.setDriverId(scheduleDetail.getDriverId());
        //Planned
        schedule.setStatus("P");
        schedule.setCreatedBy(username);
        schedule.setCreatedOn(new Date());
        this.scheduleMapper.insert(schedule);

//        //planned stop
//        List<SchStop> plannedStopDetails = scheduleDetail.getSchStops();
//        int len = plannedStopDetails.size();
//        for(int i=0; i< len;i++){
//            SchStop plannedStop = plannedStopDetails.get(i);
//            plannedStop.setSchId(nextId);
//            plannedStop.setLocid(plannedStop.getLocid());
//            plannedStop.setSeq(i+1);
//            plannedStop.setStatus("P"); //Planned
//            this.schStopMapper.insert(plannedStop);
//        }

        //return all type
        return nextId;
    }

    public List<Schedule> update(@RequestBody Schedule sch){
        this.scheduleMapper.updateByPrimaryKeySelective(sch);
        return this.scheduleMapper.selectByPrimaryKey(null);
    }

    public List<Schedule> delete(@PathVariable(name="id") String id){
        this.scheduleMapper.deleteByPrimaryKey(id);
        return this.scheduleMapper.selectByPrimaryKey(null);
    }
}

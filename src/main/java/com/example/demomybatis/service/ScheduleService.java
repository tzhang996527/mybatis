package com.example.demomybatis.service;

import com.example.demomybatis.dao.PlannedStopMapper;
import com.example.demomybatis.dao.SchStopMapper;
import com.example.demomybatis.dao.ScheduleMapper;
import com.example.demomybatis.dao.TourMapper;
import com.example.demomybatis.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("scheduleService")
public class ScheduleService {

    @Autowired
    private TourService tourService;
    
    @Autowired
    private ScheduleMapper scheduleMapper;
    
    @Autowired
    private SchStopMapper schStopMapper;

    @Autowired
    private TourMapper tourMapper;

    @Autowired
    private PlannedStopMapper plannedStopMapper;

    public List<Schedule> selectByPrimaryKey(@Param("sch") Schedule sch){
        return this.scheduleMapper.selectByPrimaryKey(sch);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public String create(ScheduleDetail scheduleDetail){
//  public String create(ScheduleDetail scheduleDetail){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String nextId = Long.toString(this.scheduleMapper.getNextSchId());
        Schedule sch = scheduleDetail;

        sch.setSchId(nextId);
        sch.setStatus("P");
        sch.setCreatedBy(username);
        sch.setCreatedOn(new Date());
        this.scheduleMapper.insert(sch);

        //planned stop
        List<SchStop> plannedStopDetails = scheduleDetail.getSchStops();
        int len = plannedStopDetails.size();
        for(int i=0; i< len;i++){
            SchStop plannedStop = plannedStopDetails.get(i);
            plannedStop.setSchId(nextId);
            plannedStop.setLocid(plannedStop.getLocid());
            plannedStop.setSeq(i+1);
            plannedStop.setStatus("P"); //Planned
            this.schStopMapper.insert(plannedStop);
        }

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

    //Generate tours from schedule
    public List<String> createTourViaSch(String schId){

        List<String> tourIds = new ArrayList<>();
        List<String> schWD = new ArrayList<>();

        //get schedule data
        Schedule sch = new Schedule();
        sch.setSchId(schId);
        SchStop schStop = new SchStop();
        schStop.setSchId(schId);
        List<SchStop> schStops = this.schStopMapper.selectByPrimaryKey(schStop);
        List<Schedule> schedules = this.scheduleMapper.selectByPrimaryKey(sch);

        for (int j = 0; j < schedules.size(); j++) {

            Schedule schedule = schedules.get(j);

            //get start and end date
            Date startDat = schedule.getStartDt();
            Date endDat = schedule.getEndDt();

            //get weekdays of schedule
            String mon = schedule.getMon();
            if (mon == "true") {
                schWD.add("mon");
            }

            String tue = schedule.getTue();
            if (tue == "true") {
                schWD.add("tue");
            }

            String wed = schedule.getWed();
            if (wed == "true") {
                schWD.add("wed");
            }

            String thu = schedule.getThu();
            if (thu == "true") {
                schWD.add("thu");
            }

            String fri = schedule.getFri();
            if (fri == "true") {
                schWD.add("fri");
            }

            String sat = schedule.getSat();
            if (sat == "true") {
                schWD.add("sat");
            }

            String sun = schedule.getSun();
            if (sun == "true") {
                schWD.add("sun");
            }

            //get day of start date
            List<Date> lt_date = getBetweenDates(startDat, endDat);
            for (int i = 0; i < lt_date.size(); i++) {
                if (schWD.contains(dateToWeek(lt_date.get(i)))) {
                    //Creat tour
                    String username = SecurityContextHolder.getContext().getAuthentication().getName();
                    String nextId = Long.toString(this.tourMapper.getNextTourId());
                    Tour tour = new Tour();
                    tour.setTourid(nextId);
                    //tour type
                    tour.setTourType("SHORT");
                    //asset id
                    tour.setVehicleId(null);
                    tour.setSourceLocid(schedule.getSourceLocid());
                    tour.setDestLocid(schedule.getDestLocid());
                    tour.setPlanDepart(null);
                    tour.setPlanArr(null);

                    //planned
                    tour.setExeStatus("01");
                    tour.setShipTo(null);
                    tour.setCustId(null);
                    tour.setDriverId(null);
                    tour.setCreatedBy(username);
                    tour.setCreatedOn(new Date());
                    this.tourMapper.insert(tour);

                    //planned stop
                    int len = schStops.size();
                    for (int k = 0; k < len; k++) {
                        SchStop schStop1 = schStops.get(k);
                        PlannedStop plannedStop = new PlannedStop();
                        plannedStop.setTourid(nextId);
                        plannedStop.setLocid(schStop1.getLocid());
                        plannedStop.setPlanDepart(null);
                        plannedStop.setPlanArr(null);
                        plannedStop.setSeq(k + 1);
                        plannedStop.setStatus("P"); //Planned
                        this.plannedStopMapper.insert(plannedStop);
                    }

                    tourIds.add(nextId);
                }
            }
        }
        return tourIds;
    }

    //get all dates
    private List<Date> getBetweenDates(Date start, Date end){

        List<Date> result = new ArrayList<>();
//        List<>

        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);

        tempEnd.add(Calendar.DAY_OF_YEAR,1);
        while(tempStart.before(tempEnd)){
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR,1);
        }

        return result;
    }

    private String dateToWeek(Date date){
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

        String[] weekDays = {"mon","tue","wed","thu","fri","sat","sun"};

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0){
            w = 0;
        }

        return weekDays[w];
    }

}

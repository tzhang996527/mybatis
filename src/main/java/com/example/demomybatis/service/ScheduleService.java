package com.example.demomybatis.service;

import com.example.demomybatis.dao.PlannedStopMapper;
import com.example.demomybatis.dao.SchStopMapper;
import com.example.demomybatis.dao.ScheduleMapper;
import com.example.demomybatis.dao.TourMapper;
import com.example.demomybatis.entity.*;
import com.example.demomybatis.util.DateUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    public List<String> createTourViaSch(String schId) throws ParseException{

        List<String> tourIds = new ArrayList<>();

        //get schedule data
        Schedule sch = new Schedule();
        sch.setSchId(schId);
        SchStop schStop = new SchStop();
        schStop.setSchId(schId);
        List<SchStop>   schStops = this.schStopMapper.selectByPrimaryKey(schStop);
        List<Schedule> schedules = this.scheduleMapper.selectByPrimaryKey(sch);

        Integer lastStopSeq = schStops.size() - 1;
        //source location id
        String sourceLoc = schStops.get(0).getLocid();
        //destination location id
        String destLoc = schStops.get(lastStopSeq).getLocid();

        //get current schedule
        Schedule schedule = schedules.get(0);
        //get tour date
        List<SchDate> schDates = calculateTourDate(schedule,schStops);
        //User name
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        SchDate tourDate = null;

        for (int i = 0; i < schDates.size(); i++) {

            tourDate = schDates.get(i);
            //Creat tour
            String nextId = Long.toString(this.tourMapper.getNextTourId());
            Tour tour = new Tour();
            tour.setTourid(nextId);
            //tour type
            tour.setTourType("SHORT");
            //asset id
            tour.setVehicleId(null);
            tour.setSourceLocid(sourceLoc);
            tour.setDestLocid(destLoc);
            tour.setPlanDepart(tourDate.getPlanDepart());
            tour.setPlanArr(tourDate.getPlanArr());
            //planned
            tour.setExeStatus("01");
            tour.setShipTo(null);
            tour.setCustId(null);
            tour.setDriverId(null);
            tour.setCreatedBy(username);
            tour.setCreatedOn(new Date());
            this.tourMapper.insert(tour);

            //planned stop
            List<PlannedStop> tourStops = tourDate.getPlannedStops();
            int len = tourStops.size();
            for (int k = 0; k < len; k++) {
                PlannedStop plannedStop = tourStops.get(k);
                plannedStop.setTourid(nextId);
                this.plannedStopMapper.insert(plannedStop);
            }
            tourIds.add(nextId);
        }

        return tourIds;
    }

    //calculate tour date
    private List<SchDate> calculateTourDate(Schedule schedule,List<SchStop> schStops) throws ParseException{

        List<SchDate> resultTourDT = new ArrayList<>();
        List<String> schWD = new ArrayList<>();

        SimpleDateFormat f_date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat f_time = new SimpleDateFormat("HH:mm:ss");

        //get schedule start and end date
        Date startDat = schedule.getStartDt();
        Date endDat = schedule.getEndDt();

        //get weekdays of schedule
        String mon = schedule.getMon();
        if (mon.equals("true")) {
            schWD.add("mon");
        }

        String tue = schedule.getTue();
        if (tue.equals("true")){
            schWD.add("tue");
        }

        String wed = schedule.getWed();
        if (wed.equals("true")) {
            schWD.add("wed");
        }

        String thu = schedule.getThu();
        if (thu.equals("true")) {
            schWD.add("thu");
        }

        String fri = schedule.getFri();
        if (fri.equals("true")) {
            schWD.add("fri");
        }

        String sat = schedule.getSat();
        if (sat.equals("true")) {
            schWD.add("sat");
        }

        String sun = schedule.getSun();
        if (sun.equals("true")) {
            schWD.add("sun");
        }

        //get day of start date
        List<Date> lt_date = getBetweenDates(startDat, endDat);

        Date tourDate;
        Date lastStopArrivalDate;
        Date nextStopArrival;
        String str_dep_DT = null;
        String str_arr_DT = null;
        String str_departTime = null;
        String str_arrTime = null;
        Integer len = schStops.size();

        for (int i = 0; i < lt_date.size(); i++) {

            tourDate = lt_date.get(i);
            //initial date
            lastStopArrivalDate = tourDate;

            String str_date = f_date.format(tourDate);
            if (schWD.contains(dateToWeek(tourDate))) {

                SchDate schDate = new SchDate();
                List<PlannedStop> tourStops = new ArrayList<>();

                Date tourDeparture = null;
                Date tourArrival = null;

                for (int j = 0; j < len; j++) {
                    //current stop
                    SchStop schStop = schStops.get(j);
                    //departure time
                    Date plannedDep_T = schStop.getPlanDepart();
                    //arrival time
                    Date plannedArr_T = schStop.getPlanArr();
                    //Execution days
                    Integer exeDays = schStop.getDays();

                    if(plannedDep_T != null){
                        str_departTime = f_time.format(plannedDep_T);
                    }

                    if(plannedArr_T != null){
                        str_arrTime = f_time.format(plannedArr_T);
                    }

                    //arrival date
                    Calendar tempEnd = Calendar.getInstance();
                    nextStopArrival = lastStopArrivalDate;
                    tempEnd.setTime(nextStopArrival);
                    if (exeDays > 0){
                        tempEnd.add(Calendar.DAY_OF_YEAR,exeDays);
                        nextStopArrival = tempEnd.getTime();
                    }

                    String str_arrDate = f_date.format(nextStopArrival);

                    //current departure date & time
                    if(plannedDep_T != null) {
                        str_dep_DT = str_date + " " + str_departTime;
                    }
                    //next stop's arrival date & time
                    if(plannedArr_T != null) {
                        str_arr_DT = str_arrDate + " " + str_arrTime;
                    }
                    //Save arrival date of last stop
                    lastStopArrivalDate = nextStopArrival;

                    //Set planned stop date
                    PlannedStop plannedStop = new PlannedStop();
                    plannedStop.setSeq(j+1);
                    plannedStop.setLocid(schStop.getLocid());
                    plannedStop.setStatus("P");

                    if(j==0){
                        tourDeparture = DateUtil.parse(str_dep_DT);
                        plannedStop.setPlanDepart(tourDeparture);
                        plannedStop.setPlanArr(null); //first stop
                    }else if(j == len - 1){
                        tourArrival = DateUtil.parse(str_arr_DT);
                        plannedStop.setPlanDepart(null); //last stop
                        plannedStop.setPlanArr(tourArrival);
                    }else{
                        //intermediate stops
                        plannedStop.setPlanDepart(DateUtil.parse(str_dep_DT));
                        plannedStop.setPlanArr(DateUtil.parse(str_arr_DT));
                    }

                    tourStops.add(plannedStop);
                }

                schDate.setPlanDepart(tourDeparture);
                schDate.setPlanArr(tourArrival);
                schDate.setPlannedStops(tourStops);
                //Store date
                resultTourDT.add(schDate);
            }
        }

        return resultTourDT;
    }

    //get all dates
    private List<Date> getBetweenDates(Date start, Date end){

        List<Date> result = new ArrayList<>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);

//        tempEnd.add(Calendar.DAY_OF_YEAR,1);
        while(tempStart.before(tempEnd)){
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR,1);
        }

        return result;
    }

    private String dateToWeek(Date date){
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

        String[] weekDays = {"sun","mon","tue","wed","thu","fri","sat"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0){
            w = 0;
        }
        return weekDays[w];
    }

}

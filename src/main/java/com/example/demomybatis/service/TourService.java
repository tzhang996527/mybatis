package com.example.demomybatis.service;

import com.example.demomybatis.dao.PlannedStopMapper;
import com.example.demomybatis.dao.TourMapper;
import com.example.demomybatis.entity.PlannedStop;
import com.example.demomybatis.entity.PlannedStopDetail;
import com.example.demomybatis.entity.Tour;
import com.example.demomybatis.entity.TourDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

//@Transactional()//spring boot 会自动配置一个 DataSourceTransactionManager
@Service("tourService")
public class TourService {

    @Autowired
    private TourMapper tourMapper;

    @Autowired
    private PlannedStopMapper plannedStopMapper;

    public List<Tour> getTour(){
        return tourMapper.selectByPrimaryKey(null);
    }

    //Create tour
    @Transactional(propagation = Propagation.REQUIRED)
    public String saveTour(TourDetail tourDetail){
        //Creat tour
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String nextId = Long.toString(this.tourMapper.getNextTourId());
        Tour tour = new Tour();
        tour.setTourid(nextId);
        //tour type
        tour.setTourType(tourDetail.getTourType());
        //asset id
        tour.setVehicleId(tourDetail.getVehicle().getAssetId());
        tour.setSourceLocid(tourDetail.getSourceLoc().getLocId());
        tour.setDestLocid(tourDetail.getDestLoc().getLocId());
        tour.setPlanDepart(tourDetail.getPlanDepart());
        tour.setPlanArr(tourDetail.getPlanArr());
        tour.setExeStatus("01");
//        tour.setShipTo("");
        tour.setCreatedBy(username);
        tour.setCreatedOn(new Date());
        this.tourMapper.insert(tour);
//        if(true){
//            throw new RuntimeException("Save tour error......");
//        }
        //planned stop
        List<PlannedStopDetail> plannedStopDetails = tourDetail.getPlannedStopsDetail();
        int len = plannedStopDetails.size();
        for(int i=0; i< len;i++){
            PlannedStop plannedStop = plannedStopDetails.get(i);
            plannedStop.setTourid(nextId);
            plannedStop.setLocid(plannedStop.getLocid());
            plannedStop.setSeq(i+1);
            plannedStop.setStatus("P"); //Planned
            this.plannedStopMapper.insert(plannedStop);
        }

        return nextId;
    }
//    private TourMapper tourMapper;
//
//    @Autowired
//    public TourService(TourMapper tourMapper) {
//        this.tourMapper = tourMapper;
//    }
//
//    @Override
//    @Transactional(readOnly = true,propagation = Propagation.REQUIRED)
//    public List<Tour> getAllTours() {
//        return tourMapper.selectByPrimaryKey(null);
//        //如果异常被抓起之后，需要回滚只能手动回滚，否则事务会认为异常已经被处理，就不在进行回滚
////        try {
////            int i=1/0;//抛出异常
////        } catch (Exception e) {
////            //事务回滚
////            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
////        }
//        //如果异常没有被抓起，则自动回滚
//    }
}


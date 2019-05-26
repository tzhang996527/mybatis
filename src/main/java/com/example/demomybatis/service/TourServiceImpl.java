package com.example.demomybatis.service;

import com.example.demomybatis.entity.Tour;
import com.example.demomybatis.dao.TourMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Transactional()//spring boot 会自动配置一个 DataSourceTransactionManager
@Service("tourService")
public class TourServiceImpl implements TourService {

    private TourMapper tourMapper;

    @Autowired
    public TourServiceImpl(TourMapper tourMapper) {
        this.tourMapper = tourMapper;
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.REQUIRED)
    public List<Tour> getAllTours() {
        return tourMapper.selectTour();
        //如果异常被抓起之后，需要回滚只能手动回滚，否则事务会认为异常已经被处理，就不在进行回滚
//        try {
//            int i=1/0;//抛出异常
//        } catch (Exception e) {
//            //事务回滚
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//        }
        //如果异常没有被抓起，则自动回滚
    }
}


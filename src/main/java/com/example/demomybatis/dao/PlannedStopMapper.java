package com.example.demomybatis.dao;

import com.example.demomybatis.entity.PlannedStop;
import com.example.demomybatis.entity.PlannedStopKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlannedStopMapper {
    int deleteByPrimaryKey(PlannedStopKey key);

    int insert(PlannedStop record);

    int insertSelective(PlannedStop record);

    PlannedStop selectByPrimaryKey(PlannedStopKey key);

    int updateByPrimaryKeySelective(PlannedStop record);

    int updateByPrimaryKey(PlannedStop record);
}
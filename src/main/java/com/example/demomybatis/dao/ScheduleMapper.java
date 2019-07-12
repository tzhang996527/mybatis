package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ScheduleMapper {
    int deleteByPrimaryKey(String schId);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    List<Schedule> selectByPrimaryKey(Schedule schedule);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);

    long getNextSchId();
}
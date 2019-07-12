package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Schedule;

public interface ScheduleMapper {
    int deleteByPrimaryKey(String schId);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(String schId);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);
}
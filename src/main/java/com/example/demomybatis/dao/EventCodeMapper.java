package com.example.demomybatis.dao;

import com.example.demomybatis.entity.EventCode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventCodeMapper {
    int deleteByPrimaryKey(String eventCode);

    int insert(EventCode record);

    int insertSelective(EventCode record);

    EventCode selectByPrimaryKey(String eventCode);

    int updateByPrimaryKeySelective(EventCode record);

    int updateByPrimaryKey(EventCode record);
}
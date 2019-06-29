package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Event;
import com.example.demomybatis.entity.EventCode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventCodeMapper {
    int deleteByPrimaryKey(String eventCode);

    int insert(EventCode record);

    int insertSelective(EventCode record);

    List<EventCode> selectByPrimaryKey(EventCode eventCode);

    int updateByPrimaryKeySelective(EventCode record);

    int updateByPrimaryKey(EventCode record);
}
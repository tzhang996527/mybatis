package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Event;
import com.example.demomybatis.entity.EventKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventMapper {
    int deleteByPrimaryKey(EventKey key);

    int insert(Event record);

    int insertSelective(Event record);

    Event selectByPrimaryKey(EventKey key);

    int updateByPrimaryKeySelective(Event record);

    int updateByPrimaryKey(Event record);
}
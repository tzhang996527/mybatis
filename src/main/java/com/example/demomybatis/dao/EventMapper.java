package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Event;
import com.example.demomybatis.entity.EventKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventMapper {
    int deleteByPrimaryKey(EventKey key);

    int insert(Event record);

    int insertSelective(Event record);

    List<Event> selectByPrimaryKey(Event event);

    int updateByPrimaryKeySelective(Event record);

    int updateByPrimaryKey(Event record);
}
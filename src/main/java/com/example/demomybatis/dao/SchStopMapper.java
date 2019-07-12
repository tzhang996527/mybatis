package com.example.demomybatis.dao;

import com.example.demomybatis.entity.SchStop;
import com.example.demomybatis.entity.SchStopKey;

public interface SchStopMapper {
    int deleteByPrimaryKey(SchStopKey key);

    int insert(SchStop record);

    int insertSelective(SchStop record);

    SchStop selectByPrimaryKey(SchStopKey key);

    int updateByPrimaryKeySelective(SchStop record);

    int updateByPrimaryKey(SchStop record);
}
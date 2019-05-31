package com.example.demomybatis.dao;

import com.example.demomybatis.entity.ActualStop;
import com.example.demomybatis.entity.ActualStopKey;

public interface ActualStopMapper {
    int deleteByPrimaryKey(ActualStopKey key);

    int insert(ActualStop record);

    int insertSelective(ActualStop record);

    ActualStop selectByPrimaryKey(ActualStopKey key);

    int updateByPrimaryKeySelective(ActualStop record);

    int updateByPrimaryKey(ActualStop record);
}
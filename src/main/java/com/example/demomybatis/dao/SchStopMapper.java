package com.example.demomybatis.dao;

import com.example.demomybatis.entity.SchStop;
import com.example.demomybatis.entity.SchStopKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SchStopMapper {
    int deleteByPrimaryKey(SchStopKey key);

    int insert(SchStop record);

    int insertSelective(SchStop record);

    List<SchStop> selectByPrimaryKey(SchStop schStop);

    int updateByPrimaryKeySelective(SchStop record);

    int updateByPrimaryKey(SchStop record);
}
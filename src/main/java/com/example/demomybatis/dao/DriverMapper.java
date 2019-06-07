package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Driver;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DriverMapper {
    int deleteByPrimaryKey(String driverId);

    int insert(Driver record);

    int insertSelective(Driver record);

    Driver selectByPrimaryKey(String driverId);

    int updateByPrimaryKeySelective(Driver record);

    int updateByPrimaryKey(Driver record);
}
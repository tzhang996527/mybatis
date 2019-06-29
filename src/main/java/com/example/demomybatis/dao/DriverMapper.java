package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Driver;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DriverMapper {
    int deleteByPrimaryKey(String driverId);

    int insert(Driver record);

    int insertSelective(Driver record);

    List<Driver> selectByPrimaryKey(Driver driver);

//    List<Driver> selectByPrimaryKey(String driverId);

    int updateByPrimaryKeySelective(Driver record);

    int updateByPrimaryKey(Driver record);
}
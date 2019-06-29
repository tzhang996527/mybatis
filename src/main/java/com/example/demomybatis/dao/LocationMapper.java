package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Location;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LocationMapper {
    int deleteByPrimaryKey(String locId);

    int insert(Location record);

    int insertSelective(Location record);

    List<Location> selectByPrimaryKey(Location loc);

    int updateByPrimaryKeySelective(Location record);

    int updateByPrimaryKey(Location record);

}
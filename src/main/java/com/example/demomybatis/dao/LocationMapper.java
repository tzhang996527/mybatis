package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Location;

public interface LocationMapper {
    int deleteByPrimaryKey(String locId);

    int insert(Location record);

    int insertSelective(Location record);

    Location selectByPrimaryKey(String locId);

    int updateByPrimaryKeySelective(Location record);

    int updateByPrimaryKey(Location record);
}
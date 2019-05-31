package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Reservation;

public interface ReservationMapper {
    int deleteByPrimaryKey(String resvId);

    int insert(Reservation record);

    int insertSelective(Reservation record);

    Reservation selectByPrimaryKey(String resvId);

    int updateByPrimaryKeySelective(Reservation record);

    int updateByPrimaryKey(Reservation record);
}
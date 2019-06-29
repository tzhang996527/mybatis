package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Reservation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
    int deleteByPrimaryKey(String resvId);

    int insert(Reservation record);

    int insertSelective(Reservation record);

    List<Reservation> selectByPrimaryKey(Reservation resv);

    int updateByPrimaryKeySelective(Reservation record);

    int updateByPrimaryKey(Reservation record);
}
package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Notification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notification record);

    int insertSelective(Notification record);

    List<Notification> selectByPrimaryKey(Notification notification);

    int updateByPrimaryKeySelective(Notification record);

    int updateByPrimaryKey(Notification record);
}
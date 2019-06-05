package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Notification;

public interface NotificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notification record);

    int insertSelective(Notification record);

    Notification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notification record);

    int updateByPrimaryKey(Notification record);
}
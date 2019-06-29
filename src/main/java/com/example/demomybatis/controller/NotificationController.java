package com.example.demomybatis.controller;

import com.example.demomybatis.dao.EventCodeMapper;
import com.example.demomybatis.dao.NotificationMapper;
import com.example.demomybatis.entity.EventCode;
import com.example.demomybatis.entity.Notification;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class NotificationController {

    private final NotificationMapper notificationMapper;

    @Autowired
    public NotificationController(NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }

    @GetMapping(path = "notification")
    public List<Notification> selectByPrimaryKey(@Param("Notification") Notification notification){
        return this.notificationMapper.selectByPrimaryKey(notification);
    }

    @PostMapping(path = "notification")
    public List<Notification> create(@RequestBody Notification notification){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        notification.setCreatedBy(username);
        notification.setCreatedOn(new Date());
        this.notificationMapper.insert(notification);
        //return all customer
        return this.notificationMapper.selectByPrimaryKey(null);
    }

    @PutMapping(path = "notification")
    public List<Notification> update(@RequestBody Notification notification){
        this.notificationMapper.updateByPrimaryKeySelective(notification);
        return this.notificationMapper.selectByPrimaryKey(null);
    }
//    @DeleteMapping(path="notification")
//    public List<Notification> delete(@PathVariable(name="id") String id){
//        this.notificationMapper.deleteByPrimaryKey(id);
//        return this.notificationMapper.selectByPrimaryKey(null);
//    }
}

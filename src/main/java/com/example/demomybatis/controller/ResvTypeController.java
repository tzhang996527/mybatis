package com.example.demomybatis.controller;

import com.example.demomybatis.dao.EventCodeMapper;
import com.example.demomybatis.dao.ResvTypeMapper;
import com.example.demomybatis.entity.EventCode;
import com.example.demomybatis.entity.ResvType;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ResvTypeController {

    private final ResvTypeMapper resvTypeMapper;

    @Autowired
    public ResvTypeController(ResvTypeMapper resvTypeMapper) {
        this.resvTypeMapper = resvTypeMapper;
    }

    @GetMapping(path = "resvType")
    public List<ResvType> selectByPrimaryKey(@Param("resvType") ResvType resvType){
        return this.resvTypeMapper.selectByPrimaryKey(resvType);
    }

    @PostMapping(path = "resvType")
    public List<ResvType> create(@RequestBody ResvType resvType){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        resvType.setCreatedBy(username);
        resvType.setCreatedOn(new Date());
        this.resvTypeMapper.insert(resvType);
        //return all customer
        return this.resvTypeMapper.selectByPrimaryKey(null);
    }

    @PutMapping(path = "resvType")
    public List<ResvType> update(@RequestBody ResvType resvType){
        this.resvTypeMapper.updateByPrimaryKeySelective(resvType);
        return this.resvTypeMapper.selectByPrimaryKey(null);
    }
    @DeleteMapping(path="resvType/{id}")
    public List<ResvType> delete(@PathVariable(name="id") String id){
        this.resvTypeMapper.deleteByPrimaryKey(id);
        return this.resvTypeMapper.selectByPrimaryKey(null);
    }
}

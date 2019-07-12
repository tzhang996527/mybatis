package com.example.demomybatis.controller;

import com.example.demomybatis.dao.SchTypeMapper;
import com.example.demomybatis.entity.SchType;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class SchTypeController {

    @Autowired
    private SchTypeMapper schTypeMapper;
    
    @GetMapping(path = "schType")
    public List<SchType> selectByPrimaryKey(@Param("schType") SchType schType){
        return this.schTypeMapper.selectByPrimaryKey(schType);
    }

    @PostMapping(path = "schType")
    public List<SchType> create(@RequestBody SchType schType){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        schType.setCreatedBy(username);
        schType.setCreatedOn(new Date());
        this.schTypeMapper.insert(schType);
        //return all type
        return this.schTypeMapper.selectByPrimaryKey(null);
    }

    @PutMapping(path = "schType")
    public List<SchType> update(@RequestBody SchType schType){
        this.schTypeMapper.updateByPrimaryKeySelective(schType);
        return this.schTypeMapper.selectByPrimaryKey(null);
    }
    @DeleteMapping(path="schType/{id}")
    public List<SchType> delete(@PathVariable(name="id") String id){
        this.schTypeMapper.deleteByPrimaryKey(id);
        return this.schTypeMapper.selectByPrimaryKey(null);
    }
}

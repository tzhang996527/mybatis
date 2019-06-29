package com.example.demomybatis.controller;

import com.example.demomybatis.dao.DriverMapper;
import com.example.demomybatis.entity.Driver;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class DriverController {

    private final DriverMapper driverMapper;

    @Autowired
    public DriverController(DriverMapper driverMapper) {
        this.driverMapper = driverMapper;
    }

    @GetMapping(path = "driver")
    public List<Driver> selectByPrimaryKey(@Param("Driver") Driver driver){
        return this.driverMapper.selectByPrimaryKey(driver);
    }

    @PostMapping(path = "driver")
    public List<Driver> createDriver(@RequestBody Driver driver){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        driver.setCreatedBy(username);
        driver.setCreatedOn(new Date());
        this.driverMapper.insert(driver);
        //return all customer
        return this.driverMapper.selectByPrimaryKey(null);
    }

    @PutMapping(path = "driver")
    public List<Driver> updateDriver(@RequestBody Driver driver){
        this.driverMapper.updateByPrimaryKeySelective(driver);
        return this.driverMapper.selectByPrimaryKey(null);
    }
    @DeleteMapping(path="driver/{id}")
    public List<Driver> deleteDriver(@PathVariable(name="id") String id){
        this.driverMapper.deleteByPrimaryKey(id);
        return this.driverMapper.selectByPrimaryKey(null);
    }
}

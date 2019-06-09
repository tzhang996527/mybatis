package com.example.demomybatis.controller;

import com.example.demomybatis.dao.LocationMapper;
import com.example.demomybatis.entity.Location;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class LocController {

    private final LocationMapper locationMapper;

    @Autowired
    public LocController(LocationMapper locationMapper) {
        this.locationMapper = locationMapper;
    }

    //get all Location
    @GetMapping(path="loc")
    public List<Location> getAllLocation(@Param("locId") String locId, @Param("address") String address){
        return this.locationMapper.selectByField(locId,address);
    }

    @GetMapping(path="loc/{id}")
    public Location getLocationById(@PathVariable(name="id") String id){
        return this.locationMapper.selectByPrimaryKey(id);
    }
    @PostMapping(path="loc")
    public List<Location> createLocation(@RequestBody Location location){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        location.setCreatedBy(username);
        location.setCreatedOn(new Date());
        this.locationMapper.insert(location);
        return this.locationMapper.selectAll();
//        return String.format("LocationType %s created.",LocationType.getLocationType());
    }

    @PutMapping(path="loc")
    public List<Location> updateLocationType(@RequestBody Location location){
        this.locationMapper.updateByPrimaryKeySelective(location);
        return this.locationMapper.selectAll();
    }
    @DeleteMapping(path="loc/{id}")
    public List<Location> deleteLocation(@PathVariable(name="id") String id){
        this.locationMapper.deleteByPrimaryKey(id);
        return this.locationMapper.selectAll();
    }
}

package com.example.demomybatis.controller;

import com.example.demomybatis.dao.ReservationMapper;
import com.example.demomybatis.entity.Reservation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ReservationController {

    private final ReservationMapper reservationMapper;

    @Autowired
    public ReservationController(ReservationMapper reservationMapper) {
        this.reservationMapper = reservationMapper;
    }

    @GetMapping(path = "reservation")
    public List<Reservation> selectByPrimaryKey(@Param("reservation") Reservation reservation){
        return this.reservationMapper.selectByPrimaryKey(reservation);
    }

    @PostMapping(path = "reservation")
    public List<Reservation> create(@RequestBody Reservation reservation){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        reservation.setCreatedBy(username);
        reservation.setCreatedOn(new Date());
        this.reservationMapper.insert(reservation);
        //return all customer
        return this.reservationMapper.selectByPrimaryKey(null);
    }

    @PutMapping(path = "reservation")
    public List<Reservation> update(@RequestBody Reservation reservation){
        this.reservationMapper.updateByPrimaryKeySelective(reservation);
        return this.reservationMapper.selectByPrimaryKey(null);
    }
    @DeleteMapping(path="reservation/{id}")
    public List<Reservation> delete(@PathVariable(name="id") String id){
        this.reservationMapper.deleteByPrimaryKey(id);
        return this.reservationMapper.selectByPrimaryKey(null);
    }
}

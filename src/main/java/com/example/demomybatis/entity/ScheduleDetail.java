package com.example.demomybatis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(value = {"handler"})
public class ScheduleDetail extends Schedule{
    private List<SchStop> schStops;

    public List<SchStop> getSchStops() {
        return schStops;
    }

    public void setSchStops(List<SchStop> schStops) {
        this.schStops = schStops;
    }
}

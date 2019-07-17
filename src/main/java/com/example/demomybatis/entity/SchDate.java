package com.example.demomybatis.entity;

import java.util.Date;
import java.util.List;

public class SchDate {

    private Date planDepart;

    private Date planArr;

    private List<PlannedStop> plannedStops;

    public Date getPlanDepart() {
        return planDepart;
    }

    public void setPlanDepart(Date planDepart) {
        this.planDepart = planDepart;
    }

    public Date getPlanArr() {
        return planArr;
    }

    public void setPlanArr(Date planArr) {
        this.planArr = planArr;
    }

    public List<PlannedStop> getPlannedStops() {
        return plannedStops;
    }

    public void setPlannedStops(List<PlannedStop> plannedStops) {
        this.plannedStops = plannedStops;
    }
}

package com.example.demomybatis.entity;

import java.io.Serializable;
import java.util.List;

public class PlannedStopDetail extends PlannedStop implements Serializable {
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}

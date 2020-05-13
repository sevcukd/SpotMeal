package com.example.spotmeal.objects;

import java.util.List;

public class AllSpot {
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<SpotById> getSpots() {
        return spots;
    }

    public void setSpots(List<SpotById> spots) {
        this.spots = spots;
    }

    private int count;
    private List<SpotById> spots;
}

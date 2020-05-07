package com.example.spotmeal.days;

public class Day {
    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public Day(){

    }

    private String close;
    private String open;
}

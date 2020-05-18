package com.example.spotmeal.days;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Day(){

    }



    private boolean closed;
    private String close;
    private String open;
}

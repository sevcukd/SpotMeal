package com.example.spotmeal.objects;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Reviews {
    private int count;

    public List<Rows> getRows() {
        return rows;
    }

    public void setRows(List<Rows> rows) {
        this.rows = rows;
    }

    private List<Rows>  rows;



    public Reviews(){
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

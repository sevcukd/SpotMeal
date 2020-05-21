package com.example.spotmeal.objects;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)




public class Reviews {
    @JsonProperty("count")
    private int count;
    @JsonProperty("rows")
    private List<Rows>  rows;




    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Rows> getRows() {
        return rows;
    }

    public void setRows(List<Rows> rows) {
        this.rows = rows;
    }







    public Reviews(){
    }

}

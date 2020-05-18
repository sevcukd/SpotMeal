package com.example.spotmeal.objects;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllSpot {

    private int count;

    public List<SpotById> getSpost() {
        return spost;
    }

    public void setSpost(List<SpotById> spost) {
        this.spost = spost;
    }

    private List<SpotById>  spost;



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }




}

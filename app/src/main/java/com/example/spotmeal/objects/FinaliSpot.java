package com.example.spotmeal.objects;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class FinaliSpot {

    private SpotById spot;
    private Reviews reviews;

    public FinaliSpot(){
    }

    public SpotById getSpot() {
        return spot;
    }

    public void setSpot(SpotById spot) {
        this.spot = spot;
    }

    public Reviews getReviews() {
        return reviews;
    }

    public void setReviews(Reviews reviews) {
        this.reviews = reviews;
    }

}

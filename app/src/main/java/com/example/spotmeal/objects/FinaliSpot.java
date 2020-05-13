package com.example.spotmeal.objects;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class FinaliSpot {

    private SpotById spotById;
    private Reviews reviews;

    public FinaliSpot(){
    }

    public SpotById getSpotById() {
        return spotById;
    }

    public void setSpotById(SpotById spotById) {
        this.spotById = spotById;
    }

    public Reviews getReviews() {
        return reviews;
    }

    public void setReviews(Reviews reviews) {
        this.reviews = reviews;
    }

}

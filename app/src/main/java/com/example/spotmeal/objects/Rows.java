package com.example.spotmeal.objects;

import android.content.Intent;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Rows {
    @JsonProperty("id")
    private String id;

    @JsonProperty("user")
    private UserForRows user;

    @JsonProperty("spot")
    private String spot;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("rating")
    private double rating;

    @JsonProperty("prices")
    private double prices;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("updatedAt")
    private String updatedAt;

    public Rows(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserForRows getUser() {
        return user;
    }

    public void setUser(UserForRows user) {
        this.user = user;
    }

    public String getSpot() {
        return spot;
    }

    public void setSpot(String spot) {
        this.spot = spot;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }







    public Rows (String spot, String comment, String rating, String price){

        this.spot = spot;
        this.comment = comment;
        this.rating = Double.parseDouble(rating);
        this.prices = Double.parseDouble(price);

    }


}

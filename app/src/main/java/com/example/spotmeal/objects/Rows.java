package com.example.spotmeal.objects;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Rows {
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
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

    private String id;
    private UserForRows user;
    private String spot;
    private String comment;
    private int rating;
    private int prices;
    private String createdAt;
    private String updatedAt;


}

package com.example.spotmeal.objects;

public class Rows {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserForRows getUserForRows() {
        return userForRows;
    }

    public void setUserForRows(UserForRows userForRows) {
        this.userForRows = userForRows;
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

    private String id;
    private UserForRows userForRows;
    private String spot;
    private String comment;
    private double rating;
    private double prices;
    private String createdAt;
    private String updatedAt;


}

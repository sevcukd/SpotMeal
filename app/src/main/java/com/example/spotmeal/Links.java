package com.example.spotmeal;

import java.net.MalformedURLException;
import java.net.URL;

public class Links {
    private final String BASE_URL= "https://spot-meal.herokuapp.com/";
    private final String SPOTS = "spots/";
    private final String REVIEWS = "reviews/";
    private final String USERS = "users/";
    private final String LOGIN = "login/";
    private  final String CURRENT_USER = "me/";


    public URL getSpotsURL(){
        URL url = null;
        try{
            url = new URL(this.BASE_URL+this.SPOTS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public URL getSpotURL(String spotId){
        URL url = null;
        spotId+="/";
        try{
            url = new URL(this.BASE_URL+this.SPOTS+spotId);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }





    public URL getSignInURL(){
        URL url = null;
        try{
            url = new URL(this.BASE_URL+this.USERS+this.LOGIN);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public URL getSignUpURL(){
        URL url = null;
        try{
            url = new URL(this.BASE_URL+this.USERS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public URL getCurrentUserURL(){
        URL url = null;
        try{
            url = new URL(this.BASE_URL+this.USERS+this.CURRENT_USER);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }


}

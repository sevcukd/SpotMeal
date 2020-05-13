package com.example.spotmeal;

import android.util.Log;

import com.example.spotmeal.objects.AllSpot;
import com.example.spotmeal.objects.FinaliSpot;
import com.example.spotmeal.objects.Token;
import com.example.spotmeal.objects.User;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JSON {

    final static String LOG_TAG= "debug";


    public static User getUser(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(json);
        User user = new User();
        try {
            user = mapper.readValue(json,User.class);
        }
        catch (IOException e)
        {
            Log.e(LOG_TAG,"Parsing error");
        }
        return user;
    }

    public static Token getToken(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(json);
        Token token = new Token();
        try {
            token = mapper.readValue(json,Token.class);
        }
        catch (IOException e)
        {
            Log.e(LOG_TAG,"Parsing error");
        }
        return token;
    }
    public static FinaliSpot getFinaliSpot(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(json);
        FinaliSpot finaliSpot = new FinaliSpot();
        try {
            finaliSpot = mapper.readValue(json,FinaliSpot.class);
        }
        catch (IOException e)
        {
            Log.e(LOG_TAG,"Parsing error");
        }
        return finaliSpot;
    }

    public static AllSpot getAllSpot(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(json);
        AllSpot allSpot = new AllSpot();
        try {
            allSpot = mapper.readValue(json,AllSpot.class);
        }
        catch (IOException e)
        {
            Log.e(LOG_TAG,"Parsing error");
        }
        return allSpot;
    }

    public static String buildUser(User user) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(user);
        }catch (IOException e)
        {
            Log.e(LOG_TAG,"Parsing error");
        }
        return result;
    }
}
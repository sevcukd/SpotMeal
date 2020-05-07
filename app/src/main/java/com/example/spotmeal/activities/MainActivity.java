package com.example.spotmeal.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.spotmeal.R;

public class MainActivity extends AppCompatActivity {
    SharedPreferences mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mData = getSharedPreferences(getString(R.string.APP_PREFERENCES_NAME), Context.MODE_PRIVATE);
        if(mData.contains(getString(R.string.APP_PREFERENCES_NAME))){
            Toast.makeText(getApplicationContext(),"Всьо охуєнно",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, SignUp.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(MainActivity.this, LogIn.class);
            startActivity(intent);
            this.finish();
        }
    }
}

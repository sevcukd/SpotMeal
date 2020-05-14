package com.example.spotmeal.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.spotmeal.JSON;
import com.example.spotmeal.Links;
import com.example.spotmeal.R;
import com.example.spotmeal.Requests;
import com.example.spotmeal.ServerResponse;
import com.example.spotmeal.objects.AllSpot;
import com.example.spotmeal.objects.User;

import java.io.IOException;
import java.util.Arrays;

public class AllSpotsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_spots);
    }

//    class APIQueryTask extends AsyncTask<Void,Void, ServerResponse> {
//
//        @Override
//        protected ServerResponse doInBackground(AllSpot... allSpots) {
//            Links link = new Links();
//            ServerResponse response = null;
//            try {
//                response = Requests.postRequest(link.getSpotsURL(), JSON.getAllSpot(allSpots[0]));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return response;
//        }

//    AllSpot json = JSON.getAllSpot(response.getResponseBody());
//    final List<Course> courses = Arrays.asList(json.getRows());
//    LinearLayout.LayoutParams lParams= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//    lParams.gravity = Gravity.CENTER_HORIZONTAL;
//    ///ТАРАССССС Тута Створення списку
//    ////
//    ////
//    ////
//    ////
//
//            for(int i =0;i<courses.size();i++){
//        System.out.println(courses.get(i).getTitle());
//        ////////////
//        ////////
//        ////////////
//        ////////
//
//        ////А канкрєтніє тут
//        TextView textView = new TextView(CoursesActivity.this);
//        textView.setText(courses.get(i).getTitle());
//        textView.setId(i);
//        textView.setBackgroundColor(getResources().getColor(R.color.design_default_color_secondary_variant));
//        textView.setTextSize(25);
//        ////Вишеееее
//        //
//        ////
//        ////
//        ////
//        ////
//        ////
//        final int finali = i;
//        textView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(CoursesActivity.this,CourseActivity.class);
//                intent.putExtra("Id",courses.get(finali).getId());
//                startActivity(intent);
//
//            }
//        });
//        textView.setGravity(Gravity.CENTER);
//        liner.addView(textView);

}

package com.example.spotmeal.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spotmeal.JSON;
import com.example.spotmeal.Links;
import com.example.spotmeal.R;
import com.example.spotmeal.Requests;
import com.example.spotmeal.ServerResponse;
import com.example.spotmeal.objects.AllSpot;
import com.example.spotmeal.objects.SpotById;
import com.example.spotmeal.objects.User;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AllSpotsActivity extends AppCompatActivity {

    LinearLayout linear ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_spots);
        linear = findViewById(R.id.spotsLinerLayout);
        new APIQueryTask().execute();
    }

    class APIQueryTask extends AsyncTask<Void,Void, ServerResponse> {

        @Override
        protected ServerResponse doInBackground(Void... voids) {
            Links link = new Links();
            ServerResponse response = null;
            try {
                response = Requests.getRequest(link.getSpotsURL());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(ServerResponse response) {


            if(response.getResponseCode()==200) {
                final AllSpot spots = JSON.getAllSpot(response.getResponseBody());

                for(int i=0;i<spots.getCount();i++){
                    CardView card = new CardView(AllSpotsActivity.this);

                    TextView titleTextView = new TextView(AllSpotsActivity.this);
                    titleTextView.setPadding(0,0,0,0);
                    TextView veganTextView = new TextView(AllSpotsActivity.this);
                    TextView categoryTextView = new TextView(AllSpotsActivity.this);

                    titleTextView.setText(spots.getSpost().get(i).getName());
                    titleTextView.setId(i);
                    titleTextView.setTextSize(40);

                    categoryTextView.setText(spots.getSpost().get(i).getCategory());
                    categoryTextView.setId(i);
                    categoryTextView.setTextSize(20);
                    categoryTextView.setPadding(0,100,0,0);

                    card.addView(titleTextView);
                    card.addView(categoryTextView);
                    final int finalI = i;
                    card.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(AllSpotsActivity.this,SpotActivity.class);
                            intent.putExtra("Id",spots.getSpost().get(finalI).getId());
                            startActivity(intent);
                        }
                    });
                    linear.addView(card);

                }
            }
            else{
                Toast.makeText(getApplicationContext(),"Oh no, bitch!",Toast.LENGTH_LONG).show();
            }


        }

    }

}

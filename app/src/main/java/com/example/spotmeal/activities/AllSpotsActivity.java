package com.example.spotmeal.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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
                    TextView categoryTextView = new TextView(AllSpotsActivity.this);

                    ImageView wifiImageView = new ImageView(AllSpotsActivity.this);
                    ImageView veganImageView = new ImageView(AllSpotsActivity.this);


//              НАЙДИ НОРМ ФОТКИ
                    if (spots.getSpost().get(i).isVegan()== true){
                        //ЯКЩО ВЕГАН ТОДІ ТАКА ФОТКА
                        wifiImageView.setImageResource(R.drawable.vegant);
                    }
                    else{
                        //ЯКЩО НЕ ВЕГАН
                        wifiImageView.setImageResource(R.drawable.veganf);
                    }
                    //ТУТ ТАК САМО
                    if (spots.getSpost().get(i).isHasFreeWifi()== true){
                        veganImageView.setImageResource(R.drawable.wifit);
                    }
                    else{
                        veganImageView.setImageResource(R.drawable.wifif);
                    }
                    wifiImageView.setPadding(-100,300,0,0);
                    veganImageView.setPadding(100,300,0,0);

                    titleTextView.setText(spots.getSpost().get(i).getName());
                    titleTextView.setId(i);
                    titleTextView.setTextSize(40);

                    categoryTextView.setText(spots.getSpost().get(i).getCategory());
                    categoryTextView.setId(i);
                    categoryTextView.setTextSize(20);
                    categoryTextView.setPadding(0,100,0,0);

                    TextView ratingTextView = new TextView(AllSpotsActivity.this);
                    ratingTextView.setText("Rating: " + Double.toString(spots.getSpost().get(i).getRating()));
                    ratingTextView.setId(i);
                    ratingTextView.setTextSize(20);
                    ratingTextView.setPadding(0,200,0,0);

                    TextView priceTextView = new TextView(AllSpotsActivity.this);
                    priceTextView.setText("Price: " + Double.toString(spots.getSpost().get(i).getPrices()));
                    priceTextView.setId(i);
                    priceTextView.setTextSize(20);
                    priceTextView.setPadding(0,250,0,0);

                    card.addView(titleTextView);
                    card.addView(categoryTextView);
                    card.addView(ratingTextView);
                    card.addView(priceTextView);
                    card.addView(veganImageView);
                    card.addView(wifiImageView);
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

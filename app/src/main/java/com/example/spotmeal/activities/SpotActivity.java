package com.example.spotmeal.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spotmeal.JSON;
import com.example.spotmeal.Links;
import com.example.spotmeal.R;
import com.example.spotmeal.Requests;
import com.example.spotmeal.ServerResponse;
import com.example.spotmeal.objects.FinaliSpot;

import java.io.IOException;

public class SpotActivity extends AppCompatActivity {

    String SPOT_ID;
    LinearLayout spotLinear;
    LinearLayout reviewLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot);
        SPOT_ID = getIntent().getStringExtra("Id");
        spotLinear = findViewById(R.id.spotLinearLayout);
        reviewLinear = findViewById(R.id.reviewLinerLayout);

        new APIQueryTask().execute();
    }


    class APIQueryTask extends AsyncTask<Void, Void, ServerResponse> {

        @Override
        protected ServerResponse doInBackground(Void... voids) {
            Links link = new Links();
            ServerResponse response = null;
            try {
                response = Requests.getRequest(link.getSpotURL(SPOT_ID));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }


        @Override
        protected void onPostExecute(ServerResponse response) {

            System.out.println(response.getResponseCode());
            final FinaliSpot spot = JSON.getFinaliSpot(response.getResponseBody());
            if (response.getResponseCode() == 200) {

//                CardView card = new CardView(SpotActivity.this);
                TextView titleTextView = new TextView(SpotActivity.this);
                TextView categoryTextView = new TextView(SpotActivity.this);
                titleTextView.setText(spot.getSpot().getName());
                titleTextView.setId(0);
                titleTextView.setTextSize(40);
                categoryTextView.setText(spot.getSpot().getCategory());
                categoryTextView.setId(0);
                categoryTextView.setTextSize(20);
//                card.addView(titleTextView);
//                card.addView(categoryTextView);
                spotLinear.addView(titleTextView);
                spotLinear.addView(categoryTextView);
                for(int i =0;i<spot.getReviews().getRows().size();i++){
                    CardView cardReview = new CardView(SpotActivity.this);

                    TextView commentTextView = new TextView(SpotActivity.this);
                    commentTextView.setText(spot.getReviews().getRows().get(i).getComment());
                    commentTextView.setId(i);
                    commentTextView.setTextSize(40);

                    TextView ratingTextView = new TextView(SpotActivity.this);
                    ratingTextView.setText("Rating: " + Integer.toString(spot.getReviews().getRows().get(i).getRating()));
                    ratingTextView.setId(i);
                    ratingTextView.setTextSize(20);
                    ratingTextView.setPadding(0,200,0,0);

                    TextView priceTextView = new TextView(SpotActivity.this);
                    priceTextView.setText("Price: " + Integer.toString(spot.getReviews().getRows().get(i).getPrices()));
                    priceTextView.setId(i);
                    priceTextView.setTextSize(20);
                    priceTextView.setPadding(0,240,0,0);

                    cardReview.addView(commentTextView);
                    cardReview.addView(ratingTextView);
                    cardReview.addView(priceTextView);

                    reviewLinear.addView(cardReview);
                }
            } else {
                Toast.makeText(getApplicationContext(), "Oh no, bitch!", Toast.LENGTH_LONG).show();
            }


        }
    }
}

package com.example.spotmeal.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

import okhttp3.HttpUrl;

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
                TextView phoneTextView = new TextView(SpotActivity.this);
                TextView descriptionTextView = new TextView(SpotActivity.this);
                ImageView wifiImageView = new ImageView(SpotActivity.this);
                ImageView veganImageView = new ImageView(SpotActivity.this);


//              НАЙДИ НОРМ ФОТКИ
                if (spot.getSpot().isVegan() == true){
                    //ЯКЩО ВЕГАН ТОДІ ТАКА ФОТКА
                    wifiImageView.setImageResource(R.drawable.wifi);
                }
                else{
                    //ЯКЩО НЕ ВЕГАН
                    wifiImageView.setImageResource(R.drawable.wifi);
                }
                //ТУТ ТАК САМО
                if (spot.getSpot().isVegan() == true){
                    veganImageView.setImageResource(R.drawable.wifi);
                }
                else{
                    veganImageView.setImageResource(R.drawable.wifi);
                }

                phoneTextView.setText("Телефон: " + spot.getSpot().getPhone());

                descriptionTextView.setText("Опис: \n " + spot.getSpot().getDescription());
                descriptionTextView.setTextSize(30);

                titleTextView.setText(spot.getSpot().getName());
                titleTextView.setId(0);
                titleTextView.setTextSize(40);
                titleTextView.setPadding(50,0,50,0);

                categoryTextView.setText("Категорія: " + spot.getSpot().getCategory());
                categoryTextView.setId(0);
                categoryTextView.setTextSize(20);

                spotLinear.addView(titleTextView);
                spotLinear.addView(categoryTextView);
                spotLinear.addView(phoneTextView);
                spotLinear.addView(descriptionTextView);
                spotLinear.addView(wifiImageView);
                spotLinear.addView(veganImageView);
//                spotLinear.addView(wifiImageView);
                for(int i =0;i<spot.getReviews().getRows().size();i++){
                    CardView cardReview = new CardView(SpotActivity.this);


                    TextView commentTextView = new TextView(SpotActivity.this);
                    commentTextView.setText(spot.getReviews().getRows().get(i).getComment());
                    commentTextView.setId(i);
                    commentTextView.setTextSize(40);

                    TextView ratingTextView = new TextView(SpotActivity.this);
                    ratingTextView.setText("Rating: " + Double.toString(spot.getReviews().getRows().get(i).getRating()));
                    ratingTextView.setId(i);
                    ratingTextView.setTextSize(20);
//                    ratingTextView.setPadding(0,200,0,0);

                    TextView priceTextView = new TextView(SpotActivity.this);
                    priceTextView.setText("Price: " + Double.toString(spot.getReviews().getRows().get(i).getPrices()));
                    priceTextView.setId(i);
                    priceTextView.setTextSize(20);

                    TextView userNameTextView = new TextView(SpotActivity.this);
//                    userNameTextView.setText(spot.getReviews().getRows().);

//                    priceTextView.setPadding(0,240,0,0);

//                    cardReview.addView(commentTextView);
//                    cardReview.addView(ratingTextView);
//                    cardReview.addView(priceTextView);

//                    reviewLinear.addView(cardReview);
                    reviewLinear.addView(commentTextView);
                    reviewLinear.addView(ratingTextView);
                    reviewLinear.addView(priceTextView);
                }
                Button AddButtonReviews = new Button(getApplicationContext());
                AddButtonReviews.setText("Додати коментар");
                AddButtonReviews.setLayoutParams(
                        new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT)
                );
                AddButtonReviews.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SpotActivity.this, CreateReviewActivity.class);
                        intent.putExtra("spotId",spot.getSpot().getId());
                        startActivity(intent);
                    }
                });
                reviewLinear.addView(AddButtonReviews);
            } else {
                Toast.makeText(getApplicationContext(), "Oh no, bitch!", Toast.LENGTH_LONG).show();
            }


        }
    }
}

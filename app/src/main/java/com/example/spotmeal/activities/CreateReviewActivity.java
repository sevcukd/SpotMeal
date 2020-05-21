package com.example.spotmeal.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spotmeal.JSON;
import com.example.spotmeal.Links;
import com.example.spotmeal.R;
import com.example.spotmeal.Requests;
import com.example.spotmeal.ServerResponse;
import com.example.spotmeal.objects.Rows;
import com.example.spotmeal.objects.Token;
import com.example.spotmeal.objects.User;

import java.io.IOException;

public class CreateReviewActivity extends AppCompatActivity {

    EditText commentEdit;
    EditText ratingEdit;
    EditText priceEdit;
    Button button ;
    String spotId;
    SharedPreferences mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_review);
        commentEdit = findViewById(R.id.commentEditText);
        ratingEdit = findViewById(R.id.ratingEditText);
        priceEdit = findViewById(R.id.priceEditText);
        button = findViewById(R.id.createReviewButton);
        mData = getSharedPreferences(getString(R.string.APP_PREFERENCES_NAME), MODE_PRIVATE);
        spotId =  getIntent().getStringExtra("spotId");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mData.contains(getString(R.string.APP_PREFERENCES_NAME))){
                    if(!commentEdit.getText().toString().isEmpty()&&!priceEdit.getText().toString().isEmpty()
                            &&!priceEdit.getText().toString().isEmpty()){
                        Rows review = new Rows(spotId,commentEdit.getText().toString(),ratingEdit.getText().toString(),priceEdit.getText().toString());
                        new APIQueryTask().execute(review);
                    }else{
                        Toast.makeText(getApplicationContext(),"Please, enter your data",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Please, Log In",Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    class APIQueryTask extends AsyncTask<Rows,Void, ServerResponse> {

        @Override
        protected ServerResponse doInBackground(Rows... reviews) {
            Links link = new Links();
            ServerResponse response = null;
            try {
                response = Requests.postRequest(link.getReviewsURL(), JSON.buildRows(reviews[0]),mData.getString(getString(R.string.APP_PREFERENCES_NAME),""));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(ServerResponse response) {

            if(response.getResponseCode()==201)
            {

                Intent intent = new Intent(CreateReviewActivity.this,SpotActivity.class);
                intent.putExtra("Id",spotId);
                startActivity(intent);
                CreateReviewActivity.this.finish();

            }
            else if(response.getResponseCode()==401){
                Toast.makeText(getApplicationContext(),"Please, Sign In aaaaaaa",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(),"Помилка ",Toast.LENGTH_LONG).show();
            }


        }

    }


}

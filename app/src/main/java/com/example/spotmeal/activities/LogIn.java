package com.example.spotmeal.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spotmeal.JSON;
import com.example.spotmeal.Links;
import com.example.spotmeal.R;
import com.example.spotmeal.Requests;
import com.example.spotmeal.ServerResponse;
import com.example.spotmeal.objects.Token;
import com.example.spotmeal.objects.User;

import java.io.IOException;

public class LogIn extends AppCompatActivity {

    EditText email;
    EditText password;
    SharedPreferences mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        email = (EditText) findViewById(R.id.userNameEditText);
        password = (EditText) findViewById(R.id.passwordEditText);
        mData = getSharedPreferences(getString(R.string.APP_PREFERENCES_NAME), MODE_PRIVATE);

    }

    public void onButtonClick (View view){
        String emailString = email.getText().toString();
        String passwordString = password.getText().toString();
        if(!emailString.isEmpty()&&!passwordString.isEmpty()){
            User user = new User(emailString,passwordString);
            new APIQueryTask().execute(user);
        }else
            {
                Toast.makeText(getApplicationContext(),"Перевірте поля",Toast.LENGTH_LONG).show();
            }
    }

    class APIQueryTask extends AsyncTask<User,Void, ServerResponse> {

        @Override
        protected ServerResponse doInBackground(User... users) {
            Links link = new Links();
            ServerResponse response = null;
            try {
                response = Requests.postRequest(link.getSignInURL(), JSON.buildUser(users[0]));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(ServerResponse response) {

            if(response.getResponseCode()==201)
            {

                Token token = JSON.getToken(response.getResponseBody());
                System.out.println(token.getToken());
                SharedPreferences.Editor editor = mData.edit();
                editor.putString(getString(R.string.APP_PREFERENCES_NAME),token.getToken());
                editor.apply();
                Toast.makeText(getApplicationContext(),"You authorized",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(),"Помилка авторизації",Toast.LENGTH_LONG).show();
            }


        }

    }
}

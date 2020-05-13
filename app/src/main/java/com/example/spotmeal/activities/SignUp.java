package com.example.spotmeal.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class SignUp extends AppCompatActivity {
    EditText email;
    EditText password;
    EditText confirmPassword;
    EditText name;
    SharedPreferences mData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email = (EditText) findViewById(R.id.emailEditTextSignUp);
        password = (EditText) findViewById(R.id.passwordEditTextSignUp);
        name = (EditText) findViewById(R.id.nameEditTextSignUp);
        confirmPassword = (EditText) findViewById(R.id.confirmPasswordEditTextSignUp);
        mData = getSharedPreferences(getString(R.string.APP_PREFERENCES_NAME), MODE_PRIVATE);
    }
    public void onButtonClick (View view){
        String emailString = email.getText().toString();
        String passwordString = password.getText().toString();
        String nameString = name.getText().toString();
        String confirmPasswordString = confirmPassword.getText().toString();
        if(!emailString.isEmpty()&&!passwordString.isEmpty()&&!nameString.isEmpty()&&passwordString.equals(confirmPasswordString)){
            User user = new User(emailString,passwordString,nameString);
            new APIQueryTask().execute(user);

        }else
        {
            Toast.makeText(getApplicationContext(),"Провірь поля, далбадятел",Toast.LENGTH_LONG).show();
        }
    }
    public void onButtonClickLogin (View view){
        Intent intent4 = new Intent(SignUp.this, LogIn.class);
        this.finish();
        startActivity(intent4);
    }
    class APIQueryTask extends AsyncTask<User,Void, ServerResponse> {

        @Override
        protected ServerResponse doInBackground(User... users) {
            Links link = new Links();
            ServerResponse response = null;
            try {
                response = Requests.postRequest(link.getSignUpURL(), JSON.buildUser(users[0]));
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
                Toast.makeText(getApplicationContext(),"Ти зареєструвався",Toast.LENGTH_LONG).show();
                SignUp.this.finish();
            }
            else{
                Toast.makeText(getApplicationContext(),"Хуйло",Toast.LENGTH_LONG).show();
            }


        }

    }
}

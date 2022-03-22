package com.example.foundit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseObject;

public class MainActivity extends AppCompatActivity {

    private EditText emailAddress, password;
    private TextView emailWarning, passwordWarning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        ParseObject firstObject = new  ParseObject("FirstClass" );
        firstObject.put("message","Hey ! First message from android. Parse is now connected");
        firstObject.saveInBackground(e -> {
            if (e != null){
                Log.e("MainActivity", e.getLocalizedMessage());
            }else{
                Log.d("MainActivity","Object saved.");
            }
        });
    }
    public void signUp(View v){

        Intent i = new Intent(this, SignUp.class);
        startActivity(i);

    }
    public void logIn(View v){
        //TODO: compare the inputs with database and log user in
        if(validate()) {
            setInvisible();
            Intent i = new Intent(this, MainMenuActivity.class);
            startActivity(i);
        }

    }

    private void initViews(){
        emailAddress = findViewById(R.id.emailAddress);
        password = findViewById(R.id.password);
        emailWarning = findViewById(R.id.emailWarningTxt);
        passwordWarning = findViewById(R.id.passwordWarningTxt);

    }

    private boolean validate(){
        if(emailAddress.getText().toString().equals("")){
            emailWarning.setVisibility(View.VISIBLE);
            emailWarning.setText("Enter your email");
            return false;
        }
        //TODO: add condition to compare email address to the database

        if(password.getText().toString().equals("")){
            passwordWarning.setVisibility(View.VISIBLE);
            passwordWarning.setText("Enter your Password");
            return false;
        }
        //TODO: add condition to compare password to the database
        return true;
    }
    private void setInvisible(){
        emailWarning.setVisibility(View.GONE);
        passwordWarning.setVisibility(View.GONE);
    }
}
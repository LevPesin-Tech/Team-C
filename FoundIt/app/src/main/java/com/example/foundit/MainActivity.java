package com.example.foundit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    private EditText emailAddress, password;
    private TextView emailWarning, passwordWarning, troubleLogIn;
    Button loginButton, signupButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ParseInstallation.getCurrentInstallation().saveInBackground();

        initViews();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    setInvisible();
                //if(!emailAddress.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
                    ParseUser.logInInBackground(emailAddress.getText().toString(), password.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {
                            if (user != null) {
                                //Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(view.getContext(), MainMenuActivity.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }
            }
        });

        troubleLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Function not available yet...", Toast.LENGTH_SHORT).show();
            }
        });
//        ParseObject firstObject = new  ParseObject("FirstClass" );
//        firstObject.put("message","Hey ! First message from android. Parse is now connected");
//        firstObject.saveInBackground(e -> {
//            if (e != null){
//                Log.e("MainActivity", e.getLocalizedMessage());
//            }else{
//                Log.d("MainActivity","Object saved.");
//            }
//        });
    }
    public void signUp(View v){

        Intent i = new Intent(this, SignUp.class);
        startActivity(i);

    }
//    public void logIn(View v){
//        if(validate()) {
//            setInvisible();
//            Intent i = new Intent(this, MainMenuActivity.class);
//            startActivity(i);
//        }

//    }
    private void initViews(){
        emailAddress = findViewById(R.id.emailAddress);
        password = findViewById(R.id.password);
        emailWarning = findViewById(R.id.emailWarningTxt);
        passwordWarning = findViewById(R.id.passwordWarningTxt);
        loginButton = findViewById(R.id.loginButton);
        signupButton = findViewById(R.id.signupButton);
        troubleLogIn = findViewById(R.id.troublelogintxt);
        setInvisible();

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
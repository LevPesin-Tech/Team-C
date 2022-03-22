package com.example.foundit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {
    private EditText personName, institution, emailAddress, password, passwordReEnt;
    private TextView nameWarning, institutionWarning, emailWarning, passwordWarning, rePasswordWarning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        setContentView(R.layout.activity_sign_up);
    }
    public void signUp(View v){
        if (validate()) {
            setInvisible();
            //TODO: add the inputs to database
            Intent i = new Intent(this, MainMenuActivity.class);
            startActivity(i);
        }
    }

    public void back(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private void initViews(){
        personName = findViewById(R.id.personNameEdt);
        institution = findViewById(R.id.institutionEdt);
        emailAddress = findViewById(R.id.emailAddressEdt);
        password = findViewById(R.id.passwordEdt);
        passwordReEnt = findViewById(R.id.rePasswordEdt);
        nameWarning = findViewById(R.id.nameWarning);
        institutionWarning = findViewById(R.id.institutionWarning);
        emailWarning = findViewById(R.id.emailWarning);
        passwordWarning = findViewById(R.id.passwordWarning);
        rePasswordWarning= findViewById(R.id.rePasswordWarning);
    }

    private boolean validate(){
        if(personName.getText().toString().equals("")){
            nameWarning.setVisibility(View.VISIBLE);
            nameWarning.setText("enter your name");
            return false;
        }
        if(institution.getText().toString().equals("")){
            institutionWarning.setVisibility(View.VISIBLE);
            institutionWarning.setText("enter your institution");
            return false;
        }
        if(emailAddress.getText().toString().equals("")){
            emailWarning.setVisibility(View.VISIBLE);
            emailWarning.setText("enter your email address");
            return false;
        }
        //TODO: add condition to check if email address already exist
        if(password.getText().toString().equals("")){
            passwordWarning.setVisibility(View.VISIBLE);
            passwordWarning.setText("enter your password");
            return false;
        }
        if(!password.getText().toString().equals(passwordReEnt.getText().toString())){
            rePasswordWarning.setVisibility(View.VISIBLE);
            rePasswordWarning.setText("password does not match");
            return false;
        }
        return true;
    }

    private void setInvisible(){
        nameWarning.setVisibility(View.GONE);
        institutionWarning.setVisibility(View.GONE);
        emailWarning.setVisibility(View.GONE);
        passwordWarning.setVisibility(View.GONE);
        rePasswordWarning.setVisibility(View.GONE);
    }
}
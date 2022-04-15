package com.example.foundit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class SettingActivity extends AppCompatActivity {
    private TextView name, institution, email, password;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        initViews();

        name.setText(ParseUser.getCurrentUser().getString("FullName"));
        email.setText(ParseUser.getCurrentUser().getUsername());
        institution.setText(ParseUser.getCurrentUser().getString("institution"));

    }


    private void initViews(){
        name = findViewById(R.id.nameTxt);
        email = findViewById(R.id.emailTxt);
        institution = findViewById(R.id.institutionTxt);
        password = findViewById(R.id.passwordTxt);
    }
}
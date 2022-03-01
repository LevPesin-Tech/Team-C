package com.example.foundit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_page);
    }
    public void Confpage(View v){
        Intent i = new Intent(this, ConfirmationActivity.class);
        startActivity(i);
    }
}
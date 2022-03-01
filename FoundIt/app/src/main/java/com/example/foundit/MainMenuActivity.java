package com.example.foundit;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;

public class MainMenuActivity extends AppCompatActivity {
    private Button searchBttn, histBttn;
    private ShapeableImageView iitWallpaper, userAvatar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        initViews();

        searchBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenuActivity.this, "Search function coming soon...", Toast.LENGTH_SHORT).show();
            }
        });


        histBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenuActivity.this, "History function coming soon...", Toast.LENGTH_SHORT).show();
            }
        });

        iitWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenuActivity.this, "You cannot change wallpaper yet...", Toast.LENGTH_SHORT).show();
            }
        });

        userAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenuActivity.this, "You cannot change avatar yet...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews(){
        searchBttn = findViewById(R.id.searchBttn);
        histBttn = findViewById(R.id.histBttn);
        iitWallpaper = findViewById(R.id.iitWallpaper);
        userAvatar =  findViewById(R.id.userAvatar);
    }

    public void Listing(View v){
        Intent i = new Intent(this, ConfirmationActivity.class);
        startActivity(i);
    }
}

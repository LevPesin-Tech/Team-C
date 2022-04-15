package com.example.foundit;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;
import com.parse.ParseUser;

public class MainMenuActivity extends AppCompatActivity {
    private TextView helloTxt;
    private Button searchBttn, histBttn, addBttn, logOutBttn;
    private ShapeableImageView iitWallpaper, userAvatar;
    private ImageButton settingBttn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        initViews();

        searchBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), SearchActivity.class);
                startActivity(i);
            }
        });


        histBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), HistoryActivity.class);
                startActivity(i);
            }
        });

        addBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ListingActivity.class);
                startActivity(i);
            }
        });

        settingBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), SettingActivity.class);
                startActivity(i);
            }
        });

        logOutBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: log user out of database
                Intent i = new Intent(view.getContext(), MainActivity.class);
                startActivity(i);
            }
        });

        iitWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: add function to allow user change wallpaper
                Toast.makeText(MainMenuActivity.this, "You cannot change wallpaper yet...", Toast.LENGTH_SHORT).show();
            }
        });

        userAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: add function to allow user change avatar
                Toast.makeText(MainMenuActivity.this, "You cannot change avatar yet...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews(){
        searchBttn = findViewById(R.id.searchBttn);
        histBttn = findViewById(R.id.histBttn);
        iitWallpaper = findViewById(R.id.iitWallpaper);
        userAvatar =  findViewById(R.id.userAvatar);
        addBttn = findViewById(R.id.addListBttn);
        logOutBttn = findViewById(R.id.logoutBttn);
        settingBttn = findViewById(R.id.settingBttn);
        helloTxt = findViewById(R.id.helloTxt);
        helloTxt.setText("Hello "+ ParseUser.getCurrentUser().getUsername());
    }

    //public void Listing(View v){
   //     Intent i = new Intent(this, ListingPage.class);
  //      startActivity(i);
  //  }
}

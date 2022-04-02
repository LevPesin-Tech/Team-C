package com.example.foundit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

public class ListingActivity extends AppCompatActivity {
    private ImageView bookUri;
    private EditText title, author, isbn, price;
    private TextView picErr, titleErr, authorErr,isbnErr, priceErr, condErr;
    //private ArrayList<Uri> imageUris = new ArrayList<>();
    private static final int PICK_IMAGE_CODE=0;
    //int position = 0;
    private Spinner condition;
    private boolean picChanged= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_page);
        initViews();

        bookUri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, PICK_IMAGE_CODE);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_CODE){
            if(resultCode == Activity.RESULT_OK){
                if(data.getData()!=null){
                    Uri imageUri = data.getData();
                    bookUri.setImageURI(imageUri);
                    picChanged=true;
                }
            }
        }
    }



    private void initViews(){
        bookUri = findViewById(R.id.bookImage);
        title = findViewById(R.id.titleEdt);
        author = findViewById(R.id.authorEdt);
        isbn = findViewById(R.id.ISBNEdt);
        price = findViewById(R.id.priceEdt);
        condition = findViewById(R.id.conditionSpnr);
        titleErr = findViewById(R.id.bookErr);
        authorErr = findViewById(R.id.authorErr);
        priceErr = findViewById(R.id.priceErr);
        condErr = findViewById(R.id.conditionErr);
        picErr = findViewById(R.id.picErr);
        isbnErr = findViewById(R.id.ISBNErr);
        setInvisible();
    }


    public void Confpage(View v){
        if (validate()){
            setInvisible();
            Intent i = new Intent(this, ConfirmationActivity.class);
            startActivity(i);
        }
    }


    private boolean validate(){
        if(!picChanged){
            picErr.setVisibility(View.VISIBLE);
            picErr.setText("Choose your book's picture");
            return false;
        }
        if(title.getText().toString().equals("")) {
            setInvisible();
            titleErr.setVisibility(View.VISIBLE);
            titleErr.setText("Enter book's name");
            return false;
        }
        if(author.getText().toString().equals("")){
            setInvisible();
            authorErr.setVisibility(View.VISIBLE);
            authorErr.setText("Enter Author's name");
            return false;
        }
        if(isbn.getText().toString()!=null){
            setInvisible();
            try {
                Double.parseDouble(isbn.getText().toString());
            }
            catch(NumberFormatException e) {
                isbnErr.setVisibility(View.VISIBLE);
                isbnErr.setText("Enter number only");
                return false;
            }
        }
        if(price.getText().toString().equals("")){
            setInvisible();
            priceErr.setVisibility(View.VISIBLE);
            priceErr.setText("Enter book's price");
            return false;
        }
        if(price.getText().toString()!=null){
            setInvisible();
            try {
                Double.parseDouble(price.getText().toString());
            }
            catch(NumberFormatException e) {
                priceErr.setVisibility(View.VISIBLE);
                priceErr.setText("Enter decimal number only");
                return false;
            }
        }
        if(condition.getSelectedItem().toString().equals("--Please select your book condition--")){
            condErr.setVisibility(View.VISIBLE);
            condErr.setText("Choose your book's condition");
            return false;
        }

        return true;
    }

    public void back(View v){
        Intent i = new Intent(this, MainMenuActivity.class);
        startActivity(i);
    }
    private void setInvisible(){
        picErr.setVisibility(View.GONE);
        authorErr.setVisibility(View.GONE);
        titleErr.setVisibility(View.GONE);
        priceErr.setVisibility(View.GONE);
        condErr.setVisibility(View.GONE);
        isbnErr.setVisibility(View.GONE);
    }
}

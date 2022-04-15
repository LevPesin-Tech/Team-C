package com.example.foundit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ArrayList<Product> products = new ArrayList<>();
        //TODO: add products from database to the arraylist for display
        //TODO: below all all just sample code below. Change it accordingly

        products.add(new Product("title1","author1", "isbn1","seller1","condition1",0,"https://images.routledge.com/common/jackets/crclarge/978041547/9780415479554.jpg"));

        RecyclerView purchasedView = findViewById(R.id.searchResultView);

        SampleRecViewAdapter adapter = new SampleRecViewAdapter(this);
        adapter.setProducts(products);

        purchasedView.setAdapter(adapter);
        purchasedView.setLayoutManager(new GridLayoutManager(this, 2));

    }

    public void back(View view) {
        Intent i = new Intent(this, MainMenuActivity.class);
        startActivity(i);
    }
}
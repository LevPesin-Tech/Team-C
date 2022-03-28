package com.example.foundit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class PurchasedFragment extends Fragment {

    public PurchasedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
        ArrayList<Product> products = new ArrayList<>();
        //TODO: add products from database to the arraylist for display
        //Sample code below. Change it accordingly

        products.add(new Product("title1","author1", "isbn1","seller1","condition1",0,"https://images.routledge.com/common/jackets/crclarge/978041547/9780415479554.jpg"));
        products.add(new Product("title2","author2", "isbn2","seller2","condition2",1,"https://www.bookbaby.com/Images/textbook-thumb-ustrade.webp"));
        products.add(new Product("title3","author3", "isbn3","seller3","condition3",2,"https://images-na.ssl-images-amazon.com/images/I/41tHpR-tJdL._SX352_BO1,204,203,200_.jpg"));
        products.add(new Product("title4","author4", "isbn4","seller4","condition4",3,"https://www.appi.org/ProductImages/37150.jpg"));
        products.add(new Product("title5","author5", "isbn5","seller5","condition5",4,"https://images-na.ssl-images-amazon.com/images/I/51TxS6AKzeL._SX258_BO1,204,203,200_.jpg"));

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_purchased, container, false);
        RecyclerView purchasedView = view.findViewById(R.id.purchasedRecView);

        RecViewAdapter adapter = new RecViewAdapter(view.getContext());
        adapter.setProducts(products);

        purchasedView.setAdapter(adapter);
        purchasedView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        return view;
   }

}
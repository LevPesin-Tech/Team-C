package com.example.foundit;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PagerAdapter extends FragmentPagerAdapter {

    private int numberOfFrag;
    private String [] tabTitle = new String[] {"Purchased", "Sold"};
    public PagerAdapter(FragmentManager fm, int numberOfFrag) {
        super(fm);
        this.numberOfFrag = numberOfFrag;

    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PurchasedFragment();
            case 1:
                return new SoldFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfFrag;
    }

    public CharSequence getPageTitle(int position){
        return tabTitle[position];
    }
}

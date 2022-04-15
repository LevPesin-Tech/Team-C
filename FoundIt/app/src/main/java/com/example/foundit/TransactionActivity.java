package com.example.foundit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TransactionActivity extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private Spinner delivery;
    private EditText name, address;
    private Button dateBttn, timeBttn;
    private int hour, min;
    private TextView price;
    private NumberFormat format = NumberFormat.getCurrencyInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        initViews();
        delivery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(delivery.getSelectedItem().toString().equals("Shipping")){
                    setInvisible();
                    name.setVisibility(View.VISIBLE);
                    address.setVisibility(View.VISIBLE);

                }
                else if(delivery.getSelectedItem().toString().equals("On campus Delivery")){
                    setInvisible();
                    dateBttn.setVisibility(View.VISIBLE);
                    timeBttn.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        initDatePicker();
        //dateBttn.setText(getTodaysDate());

        timeBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        TransactionActivity.this, android.R.style.Theme_Holo_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                hour = hourOfDay;
                                min = minute;
                                String time = hour + ":" + min;
                                SimpleDateFormat f24Hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24Hours.parse(time);
                                    SimpleDateFormat f12Hours = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    timeBttn.setText(f12Hours.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }


                            }
                        }, 12,0,false
                );
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(hour,min);
                timePickerDialog.show();
            }
        });



        Product product = new Product("Sample","sample", "sample","sample","sample",10,"https://images.routledge.com/common/jackets/crclarge/978041547/9780415479554.jpg");
        //TODO: add products from database to the arraylist for display
        //Sample code below. Change it accordingly


        RecyclerView productView = findViewById(R.id.productRecView);

        RecViewAdapterHorizontal adapter = new RecViewAdapterHorizontal(this);
        adapter.setProduct(product);

        productView.setAdapter(adapter);
        productView.setLayoutManager(new LinearLayoutManager(this));
        price.setText(format.format(product.getPrice()));

    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month+=1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day,month,year);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String date = makeDateString(dayOfMonth, month, year);
                dateBttn.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this, AlertDialog.THEME_DEVICE_DEFAULT_DARK, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
    }


    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + ", " + year;
    }

    private String getMonthFormat(int month) {
        if(month==1){
            return "JAN";
        }
        if(month==2){
            return "FEB";
        }
        if(month==3){
            return "MAR";
        }
        if(month==4){
            return "APR";
        }
        if(month==5){
            return "MAY";
        }
        if(month==6){
            return "JUN";
        }
        if(month==7){
            return "JUL";
        }
        if(month==8){
            return "AUG";
        }
        if(month==9){
            return "SEP";
        }
        if(month==10){
            return "OCT";
        }
        if(month==11){
            return "NOV";
        }
        if(month==12){
            return "DEC";
        }
        return "JAN";
    }

    private void initViews() {
        dateBttn = findViewById(R.id.deliverDaySpinner);
        timeBttn = findViewById(R.id.deliverTimeSpinner);
        price = findViewById(R.id.priceTxt);
        delivery = findViewById(R.id.handOffSpinner);
        name = findViewById(R.id.nameEdt);
        address = findViewById(R.id.addressEdt);
        setInvisible();
    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }

    private void setInvisible(){
        name.setVisibility(View.GONE);
        address.setVisibility(View.GONE);
        timeBttn.setVisibility(View.GONE);
        dateBttn.setVisibility(View.GONE);
    }

    public void back(View view) {
        Intent i = new Intent(this, SearchActivity.class);
        startActivity(i);
    }
}
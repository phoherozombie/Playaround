package com.example.past1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity2 extends AppCompatActivity {
    private TextView tvDetail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2);
       tvDetail=findViewById(R.id.tv_detail);
       Intent recieveIntent =getIntent();
       if(recieveIntent!=null){
           String data=recieveIntent.getStringExtra("number");
           tvDetail.setText(data);
       }


    }
}
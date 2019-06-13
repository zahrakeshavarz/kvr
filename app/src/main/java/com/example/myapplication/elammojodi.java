package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class elammojodi extends AppCompatActivity {
   String credit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mjdi);
        credit= getIntent().getStringExtra("credit");
        TextView textView=findViewById(R.id.textView7);
//        textView.setText(credit);
    }
}

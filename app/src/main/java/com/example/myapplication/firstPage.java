package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class firstPage extends AppCompatActivity {
    private Button kartbekart;
    private Button mojodi;
    private Button charge;
    private Button ghabz;
    private Button gozaresh;
    private Button news;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);
        kartbekart=findViewById(R.id.kartbekart);
        mojodi=findViewById(R.id.mojodi);
        charge=findViewById(R.id.charge);
        ghabz=findViewById(R.id.ghabz);
        gozaresh=findViewById(R.id.gozaresh);
        news=findViewById(R.id.news);
        mojodi.setOnClickListener(v->{
            Intent intent=new Intent(this,mojodi.class);
            startActivity(intent);
        });
        charge.setOnClickListener(v->{
            Intent intent=new Intent(this,charge.class);
            startActivity(intent);
        });

    }
}

package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

public class NewsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);
        ListView listView = findViewById(R.id.lv);
        //todo: listo biar inja ke addesh koni be adapter et
//        dataAdapter adapter = new dataAdapter(this,R.layout.adapter_item,)
//        listView.setAdapter(adapter);
    }
}

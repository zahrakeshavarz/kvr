package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class charge extends AppCompatActivity {
    private EditText phonenum;
    private EditText cost;
    private Button submit;
    String phone;
    String costt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.charge);
        phonenum=findViewById(R.id.phonenum);
        cost=findViewById(R.id.mablagh);
        submit=findViewById(R.id.submitbtn);
        submit.setOnClickListener(v->{
            phone=phonenum.getText().toString();
            costt=cost.getText().toString();
            Intent intent=new Intent(this,pay.class);
            intent.putExtra("cost",costt);
            startActivity(intent);
        });
    }
}

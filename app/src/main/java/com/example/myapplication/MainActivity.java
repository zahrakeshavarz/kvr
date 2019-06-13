package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private Button signup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.loginbtn);
        signup=findViewById(R.id.signupbtn);
        login.setOnClickListener(v ->{
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        });

        signup.setOnClickListener(v->{
            Intent intent=new Intent(this,signup.class);
            startActivity(intent);
        });
}
}

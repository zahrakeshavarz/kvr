package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class signup extends AppCompatActivity {
    private Button signup;
    private EditText firstname;
    private EditText lastname;
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        signup=findViewById(R.id.signbtn);
        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);
        username=findViewById(R.id.signupusername);
        password=findViewById(R.id.signuppassword);
        signup=findViewById(R.id.signbtn);
        databaseAccess databaseAccess=new databaseAccess(this);
        signup.setOnClickListener(v->{
            user user=new user(firstname.getText().toString(),lastname.getText().toString(),username.getText().toString(),password.getText().toString());
            ContentValues contentValues=new ContentValues();
            contentValues.put("firstName",user.getFirstname());
            contentValues.put("lastName",user.getLastname());
            contentValues.put("userName",user.getUsername());
            contentValues.put("password",user.getPassword());
            SQLiteDatabase db  = databaseAccess.getDb();
                  db.insert("user",null,contentValues);
            Intent intent=new Intent(this,firstPage.class);
            startActivity(intent);
        });
    }
}

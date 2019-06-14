package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ghabz extends AppCompatActivity {
    EditText ghabz1;
    Button submit;
    int pay;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ghabz);
       ghabz1=findViewById(R.id.editText);
        submit=findViewById(R.id.ghabz1);


        submit.setOnClickListener(v->{
            String billnum=ghabz1.getText().toString();
            databaseAccess databaseAccess = new databaseAccess(this);
            Cursor c = databaseAccess.getDb().rawQuery("SELECT * from bill WHERE userName=? ", new String[]{billnum});
            c.moveToFirst();
            if (c.isAfterLast()) {
                Toast toast = new Toast(this);
                toast.makeText(this, "This user is not available!",
                        Toast.LENGTH_LONG).show();
            } else {
                pay=c.getInt(2);
            Intent intent=new Intent(this,pay.class);
            intent.putExtra("cost",pay);
            startActivity(intent);
            }
        });
    }
    }

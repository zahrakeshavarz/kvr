package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class mojodi extends AppCompatActivity {
    private EditText shomarekart;
    private EditText password;
    private EditText cvv2;
    private EditText date;
    private Button submit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mojodi);
        shomarekart=findViewById(R.id.shomarekarttext);
        password=findViewById(R.id.ramz);
        cvv2=findViewById(R.id.cvv2);
        date=findViewById(R.id.engheza);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(v->{
            String cardnum=shomarekart.getText().toString();
            int pass= Integer.parseInt(password.getText().toString());
            int pass2=Integer.parseInt(cvv2.getText().toString());
            databaseAccess databaseAccess = new databaseAccess(this);
            Cursor c = databaseAccess.getDb().rawQuery("SELECT * from bankaccount WHERE cardnum=? ", new String[]{cardnum});
            c.moveToFirst();
            if (c.isAfterLast()) {
                Toast toast = new Toast(this);
                toast.makeText(this, "شماره کارت اشتباه است!",
                        Toast.LENGTH_LONG).show();
            } else {
                if (pass==c.getInt(2) && pass2==c.getInt(4)) {
                    bankaccount bankaccount = new bankaccount(c.getString(1),c.getInt(2),c.getInt(3),c.getInt(4));
                    int credit=bankaccount.getCredit();
                    Intent intent = new Intent(this, elammojodi.class);
                    intent.putExtra("credit",cardnum);
                    startActivity(intent);
                } else {
                    Toast toast = new Toast(this);
                    toast.makeText(this, "رمز عبور صحیح نیست",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

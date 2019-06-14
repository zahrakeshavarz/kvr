package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class kartbekartAcitivy extends AppCompatActivity {
    private EditText shomarekart1;
    private EditText shomarekart2;
    private EditText password;
    private EditText cvv2;
    private EditText date;
    private EditText mablagh;
    private Button submit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kartbekart);
    shomarekart1=findViewById(R.id.kart1);
    shomarekart2=findViewById(R.id.kart2);
    password=findViewById(R.id.pass1);
    cvv2=findViewById(R.id.pass2);
    date=findViewById(R.id.date1);
    submit=findViewById(R.id.enteghal);
    mablagh=findViewById(R.id.mablagh1);
    submit.setOnClickListener(v -> {
        String cardnum1= shomarekart1.getText().toString();
        String cardnum2 = shomarekart2.getText().toString();
        int pass = Integer.parseInt(password.getText().toString());
        int pass2 = Integer.parseInt(cvv2.getText().toString());
        int pay= Integer.parseInt(mablagh.getText().toString());
        databaseAccess databaseAccess = new databaseAccess(this);
        Cursor c = databaseAccess.getDb().rawQuery("SELECT * from bankaccount WHERE cardnum=? ", new String[]{cardnum1});
        c.moveToFirst();
        if (c.isAfterLast()) {
            Toast toast = new Toast(this);
            toast.makeText(this, "شماره کارت اشتباه است!",
                    Toast.LENGTH_LONG).show();
        } else {
            if (pass == c.getInt(2) && pass2 == c.getInt(4)) {
                bankaccount bankaccount = new bankaccount(c.getString(1), c.getInt(2), c.getInt(3), c.getInt(4));

                Cursor cursor = databaseAccess.getDb().rawQuery("SELECT * from bankaccount WHERE cardnum=? ", new String[]{cardnum2});
                cursor.moveToFirst();
                if (cursor.isAfterLast()) {
                    Toast toast = new Toast(this);
                    toast.makeText(this, "شماره کارت اشتباه است!",
                            Toast.LENGTH_LONG).show();
                } else {
                        bankaccount bankaccountt = new bankaccount(c.getString(1), c.getInt(2), c.getInt(3), c.getInt(4));
                        int creditt = bankaccount.getCredit();
                        creditt+= pay;
                        ContentValues contentValues1 = new ContentValues();
                        contentValues1.put("cardnum", bankaccountt.getCardnum());
                        contentValues1.put("password", bankaccountt.getPassword());
                        contentValues1.put("credit", creditt);
                        contentValues1.put("cvv2", bankaccountt.getPass2());
                        databaseAccess.getDb().update("bamkaccount", contentValues1, "cardnum = ?", new String[]{cardnum2});
                    int credit = bankaccount.getCredit();
                    credit -= pay;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("cardnum", bankaccount.getCardnum());
                    contentValues.put("password", bankaccount.getPassword());
                    contentValues.put("credit", credit);
                    contentValues.put("cvv2", bankaccount.getPass2());
                    databaseAccess.getDb().update("bamkaccount", contentValues, "cardnum = ?", new String[]{cardnum1});
                        Intent intent = new Intent(this, firstPage.class);
                        startActivity(intent);
                }
                Intent intent = new Intent(this, firstPage.class);
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
